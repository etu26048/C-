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
    public class DoctorsController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Doctors
        public IEnumerable<Doctor> GetDoctor()
        {
            return db.Doctor.Include("locality").ToList();
        }

        // GET: api/Doctors/5
        [ResponseType(typeof(Doctor))]
        public async Task<IHttpActionResult> GetDoctor(long id)
        {
            Doctor doctor = await db.Doctor.Include("locality").FirstAsync(d => d.Id == id);
            if (doctor == null)
            {
                return NotFound();
            }
            
            return Ok(doctor);
        }

        // PUT: api/Doctors/5
        [Authorize]
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutDoctor(long id, Doctor doctor)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != doctor.Id)
            {
                return BadRequest();
            }

            //db.Entry(doctor).State = EntityState.Modified;
            var entity = db.Doctor.Find(id);
            entity.Locality = await db.Locations.FindAsync(doctor.Locality.City, doctor.Locality.PostalCode);
            entity.Name = doctor.Name;
            entity.LastName = doctor.LastName;
            entity.latitude = doctor.latitude;
            entity.longitude = doctor.longitude;
            entity.Number = doctor.Number;
            entity.Street = doctor.Street;
            entity.PhoneNumber = doctor.PhoneNumber;
            //entity.Schedule = doctor.Schedule;
            //entity.Holiday = doctor.Holiday;
            entity.RowVersion = doctor.RowVersion;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DoctorExists(id))
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

        // POST: api/Doctors
        [Authorize]
        [ResponseType(typeof(Doctor))]
        public async Task<IHttpActionResult> PostDoctor(Doctor doctor)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (await db.Locations.FindAsync(doctor.Locality.City, doctor.Locality.PostalCode) != null)
            {

                doctor.Locality = await db.Locations.FindAsync(doctor.Locality.City, doctor.Locality.PostalCode);
                db.Doctor.Add(doctor);
            }
            
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = doctor.Id }, doctor);
        }

        // DELETE: api/Doctors/5
        [Authorize]
        [ResponseType(typeof(Doctor))]
        public async Task<IHttpActionResult> DeleteDoctor(long id)
        {
            Doctor doctor = await db.Doctor.FindAsync(id);
            if (doctor == null)
            {
                return NotFound();
            }

            IEnumerable<Schedule> schedules = doctor.Schedule.ToList();
            if(schedules != null)
            {
                foreach(var schedule in schedules)
                {
                    db.Schedules.Remove(schedule);
                }
                    
            }

            IEnumerable<Holiday> holidays = doctor.Holiday.ToList();
            if (holidays != null)
            {
                foreach (var holiday in holidays)
                {
                    db.Holidays.Remove(holiday);
                }

            }

            db.Doctor.Remove(doctor);
            await db.SaveChangesAsync();

            return Ok(doctor);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DoctorExists(long id)
        {
            return db.Doctor.Count(e => e.Id == id) > 0;
        }
    }
}