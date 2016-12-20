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
    public class LocalitiesController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Localities
        public IEnumerable<Locality> GetLocations()
        {
            return db.Locations.ToList();
        }

        // GET: api/Localities/5
        [ResponseType(typeof(Locality))]
        public async Task<IHttpActionResult> GetLocality(string id)
        {
            Locality locality = await db.Locations.FindAsync(id);
            if (locality == null)
            {
                return NotFound();
            }

            return Ok(locality);
        }

        // PUT: api/Localities/5
        [Authorize]
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutLocality(string id, Locality locality)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != locality.City)
            {
                return BadRequest();
            }

            db.Entry(locality).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!LocalityExists(id))
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

        // POST: api/Localities
        [Authorize]
        [ResponseType(typeof(Locality))]
        public async Task<IHttpActionResult> PostLocality(Locality locality)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Locations.Add(locality);

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (LocalityExists(locality.City))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = locality.City }, locality);
        }

        // DELETE: api/Localities/5
        [Authorize]
        [ResponseType(typeof(Locality))]
        public async Task<IHttpActionResult> DeleteLocality(string id)
        {
            Locality locality = await db.Locations.FindAsync(id);
            if (locality == null)
            {
                return NotFound();
            }

            db.Locations.Remove(locality);
            await db.SaveChangesAsync();

            return Ok(locality);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool LocalityExists(string id)
        {
            return db.Locations.Count(e => e.City == id) > 0;
        }
    }
}