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
using Models;

namespace OkDocAPI.Controllers
{
    public class HospitalsController : ApiController
    {
        private SmartCityContext db = new SmartCityContext();

        // GET: api/Hospitals
        public IQueryable<Hospital> GetHospital()
        {
            return db.Hospital;
        }

        // GET: api/Hospitals/5
        [ResponseType(typeof(Hospital))]
        public async Task<IHttpActionResult> GetHospital(string id)
        {
            Hospital hospital = await db.Hospital.FindAsync(id);
            if (hospital == null)
            {
                return NotFound();
            }

            return Ok(hospital);
        }

        // PUT: api/Hospitals/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutHospital(string id, Hospital hospital)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != hospital.Id)
            {
                return BadRequest();
            }

            db.Entry(hospital).State = EntityState.Modified;

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
        [ResponseType(typeof(Hospital))]
        public async Task<IHttpActionResult> PostHospital(Hospital hospital)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Hospital.Add(hospital);

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (HospitalExists(hospital.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = hospital.Id }, hospital);
        }

        // DELETE: api/Hospitals/5
        [ResponseType(typeof(Hospital))]
        public async Task<IHttpActionResult> DeleteHospital(string id)
        {
            Hospital hospital = await db.Hospital.FindAsync(id);
            if (hospital == null)
            {
                return NotFound();
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

        private bool HospitalExists(string id)
        {
            return db.Hospital.Count(e => e.Id == id) > 0;
        }
    }
}