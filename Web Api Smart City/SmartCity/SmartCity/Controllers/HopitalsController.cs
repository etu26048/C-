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

namespace SmartCity.Controllers
{
    public class HopitalsController : ApiController
    {
        private SmartCityContext db = new SmartCityContext();

        // GET: api/Hopitals
        public IQueryable<Hopital> GetHospital()
        {
            return db.Hospital;
        }

        // GET: api/Hopitals/5
        [ResponseType(typeof(Hopital))]
        public async Task<IHttpActionResult> GetHopital(string id)
        {
            Hopital hopital = await db.Hospital.FindAsync(id);
            if (hopital == null)
            {
                return NotFound();
            }

            return Ok(hopital);
        }

        // PUT: api/Hopitals/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutHopital(string id, Hopital hopital)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != hopital.Id)
            {
                return BadRequest();
            }

            db.Entry(hopital).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!HopitalExists(id))
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

        // POST: api/Hopitals
        [ResponseType(typeof(Hopital))]
        public async Task<IHttpActionResult> PostHopital(Hopital hopital)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Hospital.Add(hopital);

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (HopitalExists(hopital.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = hopital.Id }, hopital);
        }

        // DELETE: api/Hopitals/5
        [ResponseType(typeof(Hopital))]
        public async Task<IHttpActionResult> DeleteHopital(string id)
        {
            Hopital hopital = await db.Hospital.FindAsync(id);
            if (hopital == null)
            {
                return NotFound();
            }

            db.Hospital.Remove(hopital);
            await db.SaveChangesAsync();

            return Ok(hopital);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool HopitalExists(string id)
        {
            return db.Hospital.Count(e => e.Id == id) > 0;
        }
    }
}