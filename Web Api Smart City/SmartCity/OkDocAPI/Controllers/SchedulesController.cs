using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Description;
using SmartCity.Models;
using OkDocAPI.Models;

namespace OkDocAPI.Controllers
{
    public class SchedulesController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Schedules
        public IEnumerable<Schedule> GetSchedules()
        {
            return db.Schedules.ToList();
        }

        // GET: api/Schedules/5
        [ResponseType(typeof(Schedule))]
        public async Task<IHttpActionResult> GetSchedule(long id)
        {
            Schedule schedule = await db.Schedules.FindAsync(id);
            if (schedule == null)
            {
                return NotFound();
            }

            return Ok(schedule);
        }

        // PUT: api/Schedules/5
        [Authorize]
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutSchedule(long id, Schedule schedule)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != schedule.ID)
            {
                return BadRequest();
            }

            db.Entry(schedule).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ScheduleExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Schedules/id
        [Authorize]
        [ResponseType(typeof(Schedule))]
        [Route("api/Schedules/Hospital/{hospitalId}")]
        public async Task<IHttpActionResult> PostScheduleForHospital(long hospitalId, [FromBody] Schedule schedule)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            Hospital hospital = db.Hospital.Include(h => h.Schedule).FirstOrDefault(h => h.Id == hospitalId);
            hospital.Schedule.Add(schedule);
            db.Schedules.Add(schedule);

            await db.SaveChangesAsync();
            return Created("api/Schedules/?Id=" + schedule.ID, schedule);
           // return CreatedAtRoute("DefaultApi", new { id = schedule.ID }, schedule);
        }

        [Authorize]
        [ResponseType(typeof(Schedule))]
        [Route("api/Schedules/Drugstore/{drugstoreId}")]
        public async Task<IHttpActionResult> PostScheduleForDrugstore(long drugstoreId, [FromBody] Schedule schedule)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            Drugstore drugstore = db.Pharmacy.Include(d => d.Schedule).FirstOrDefault(d => d.Id == drugstoreId);
            drugstore.Schedule.Add(schedule);
            db.Schedules.Add(schedule);

            await db.SaveChangesAsync();
            return Created("api/Schedules/?Id=" + schedule.ID, schedule);
            // return CreatedAtRoute("DefaultApi", new { id = schedule.ID }, schedule);
        }

        [Authorize]
        [ResponseType(typeof(Schedule))]
        [Route("api/Schedules/Doctors/{doctorId}")]
        public async Task<IHttpActionResult> PostScheduleForDoctors(long doctorId, [FromBody] Schedule schedule)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            Doctor doctor = db.Doctor.Include(h => h.Schedule).FirstOrDefault(h => h.Id == doctorId);
            doctor.Schedule.Add(schedule);
            db.Schedules.Add(schedule);

            await db.SaveChangesAsync();
            return Created("api/Schedules/?Id=" + schedule.ID, schedule);
            // return CreatedAtRoute("DefaultApi", new { id = schedule.ID }, schedule);
        }

        [Authorize]
        [ResponseType(typeof(Schedule))]
        [Route("api/Schedules/Postguards/{postguardId}")]
        public async Task<IHttpActionResult> PostScheduleForPostguard(long postguardId, [FromBody] Schedule schedule)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            Postguard postguard = db.GuardPost.Include(h => h.Schedule).FirstOrDefault(h => h.Id == postguardId);
            postguard.Schedule.Add(schedule);
            db.Schedules.Add(schedule);

            await db.SaveChangesAsync();
            return Created("api/Schedules/?Id=" + schedule.ID, schedule);
            // return CreatedAtRoute("DefaultApi", new { id = schedule.ID }, schedule);
        }

        // DELETE: api/Schedules/5
        [Authorize]
        [ResponseType(typeof(Schedule))]
        public async Task<IHttpActionResult> DeleteSchedule(long id)
        {
            Schedule schedule = await db.Schedules.FindAsync(id);
            if (schedule == null)
            {
                return NotFound();
            }

            db.Schedules.Remove(schedule);
            await db.SaveChangesAsync();

            return Ok(schedule);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool ScheduleExists(long id)
        {
            return db.Schedules.Count(e => e.ID == id) > 0;
        }
    }
}