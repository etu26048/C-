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
    public class HospitalsController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Hospitals
        public IEnumerable<Hospital> GetHospital()
        {
            return db.Hospital.Include("locality").ToList();
        }

        // GET: api/Hospitals/5
        [ResponseType(typeof(Hospital))]
        public async Task<IHttpActionResult> GetHospital(long id)
        {
            //Hospital hospital = await db.Hospital.FindAsync(id);
            Hospital hospital = await db.Hospital.Include("locality").FirstAsync(h => h.Id == id);
            if (hospital == null)
            {
                return NotFound();
            }

            return Ok(hospital);
        }

        // PUT: api/Hospitals/5
        [Authorize]
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutHospital(long id, [FromBody]Hospital hospital)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != hospital.Id)
            {
                return BadRequest();
            }

            //db.Entry(hospital).State = EntityState.Modified;
            var entity = db.Hospital.Find(id);
            entity.Locality = await db.Locations.FindAsync(hospital.Locality.City, hospital.Locality.PostalCode);
            entity.Name = hospital.Name;
            entity.Fax = hospital.Fax;
            entity.Email = hospital.Email;
            entity.EmergencyPhone = hospital.EmergencyPhone;
            entity.latitude = hospital.latitude;
            entity.longitude = hospital.longitude;
            entity.Number = hospital.Number;
            entity.Street = hospital.Street;
            entity.PhoneNumber = hospital.PhoneNumber;
            entity.URLWebSite = hospital.URLWebSite;
            //entity.Schedule = hospital.Schedule;
            entity.RowVersion = hospital.RowVersion;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!HospitalExists(id))
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

        // POST: api/Hospitals
        [Authorize]
        [ResponseType(typeof(Hospital))]
        public async Task<IHttpActionResult> PostHospital([FromBody] Hospital hospital)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            if (await db.Locations.FindAsync(hospital.Locality.City,hospital.Locality.PostalCode) != null)
            {

                hospital.Locality = await db.Locations.FindAsync(hospital.Locality.City, hospital.Locality.PostalCode);
                db.Hospital.Add(hospital);  
            }
            await db.SaveChangesAsync();
            return CreatedAtRoute("DefaultApi", new { id = hospital.Id }, hospital);
        }

        // DELETE: api/Hospitals/5
        [Authorize]
        [ResponseType(typeof(Hospital))]
        public async Task<IHttpActionResult> DeleteHospital(long id)
        {
            Hospital hospital = await db.Hospital.FindAsync(id);
            if (hospital == null)
            {
                return NotFound();
            }
            IEnumerable<Schedule> schedules = hospital.Schedule.ToList();
            if(schedules != null)
            {
                foreach(var schedule in schedules)
                {
                    db.Schedules.Remove(schedule);
                }
            }

            db.Hospital.Remove(hospital);
            await db.SaveChangesAsync();

            return Ok(hospital);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool HospitalExists(long id)
        {
            return db.Hospital.Count(e => e.Id == id) > 0;
        }
    }
}