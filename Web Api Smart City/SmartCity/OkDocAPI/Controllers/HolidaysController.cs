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
    public class HolidaysController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Holidays
        public IEnumerable<Holiday> GetHolidays()
        {
            return db.Holidays.ToList();
        }

        // GET: api/Holidays/5
        [ResponseType(typeof(Holiday))]
        public async Task<IHttpActionResult> GetHoliday(long id)
        {
            Holiday holiday = await db.Holidays.FindAsync(id);
            if (holiday == null)
            {
                return NotFound();
            }

            return Ok(holiday);
        }

        // PUT: api/Holidays/5
        [Authorize]
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutHoliday(long id, Holiday holiday)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != holiday.ID)
            {
                return BadRequest();
            }

            db.Entry(holiday).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!HolidayExists(id))
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

        // POST: api/Holidays
        [Authorize]
        [ResponseType(typeof(Schedule))]
        [Route("api/Holidays/Drugstore/{drugstoreId}")]
        public async Task<IHttpActionResult> PostScheduleForDrugstore(long drugstoreId, [FromBody] Holiday holiday)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            Drugstore drugstore = db.Pharmacy.Include(d => d.Schedule).FirstOrDefault(d => d.Id == drugstoreId);
            drugstore.Holiday.Add(holiday);
            db.Holidays.Add(holiday);

            await db.SaveChangesAsync();
            return Created("api/Holidays/?Id=" + holiday.ID, holiday);
            // return CreatedAtRoute("DefaultApi", new { id = schedule.ID }, schedule);
        }

        [Authorize]
        [ResponseType(typeof(Schedule))]
        [Route("api/Holidays/Doctors/{doctorId}")]
        public async Task<IHttpActionResult> PostScheduleForDoctors(long doctorId, [FromBody] Holiday holiday)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            Doctor doctor = db.Doctor.Include(h => h.Schedule).FirstOrDefault(h => h.Id == doctorId);
            doctor.Holiday.Add(holiday);
            db.Holidays.Add(holiday);

            await db.SaveChangesAsync();
            return Created("api/Holidays/?Id=" + holiday.ID, holiday);
            // return CreatedAtRoute("DefaultApi", new { id = schedule.ID }, schedule);
        }

        [Authorize]
        [ResponseType(typeof(Schedule))]
        [Route("api/Holidays/Postguards/{postguardId}")]
        public async Task<IHttpActionResult> PostScheduleForPostguard(long postguardId, [FromBody] Holiday holiday)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            Postguard postguard = db.GuardPost.Include(h => h.Schedule).FirstOrDefault(h => h.Id == postguardId);
            postguard.Holiday.Add(holiday);
            db.Holidays.Add(holiday);

            await db.SaveChangesAsync();
            return Created("api/Holidays/?Id=" + holiday.ID, holiday);
            // return CreatedAtRoute("DefaultApi", new { id = schedule.ID }, schedule);
        }

        // DELETE: api/Holidays/5
        [Authorize]
        [ResponseType(typeof(Holiday))]
        public async Task<IHttpActionResult> DeleteHoliday(long id)
        {
            Holiday holiday = await db.Holidays.FindAsync(id);
            if (holiday == null)
            {
                return NotFound();
            }

            db.Holidays.Remove(holiday);
            await db.SaveChangesAsync();

            return Ok(holiday);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool HolidayExists(long id)
        {
            return db.Holidays.Count(e => e.ID == id) > 0;
        }
    }
}