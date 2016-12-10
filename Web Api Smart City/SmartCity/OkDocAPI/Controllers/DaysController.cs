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
    public class DaysController : ApiController
    {
        private SmartCityContext db = new SmartCityContext();

        // GET: api/Days
        public IQueryable<Days> GetDays()
        {
            return db.Days;
        }

        // GET: api/Days/5
        [ResponseType(typeof(Days))]
        public async Task<IHttpActionResult> GetDays(string id)
        {
            Days days = await db.Days.FindAsync(id);
            if (days == null)
            {
                return NotFound();
            }

            return Ok(days);
        }

        // PUT: api/Days/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutDays(string id, Days days)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != days.label)
            {
                return BadRequest();
            }

            db.Entry(days).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DaysExists(id))
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

        // POST: api/Days
        [ResponseType(typeof(Days))]
        public async Task<IHttpActionResult> PostDays(Days days)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Days.Add(days);

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (DaysExists(days.label))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = days.label }, days);
        }

        // DELETE: api/Days/5
        [ResponseType(typeof(Days))]
        public async Task<IHttpActionResult> DeleteDays(string id)
        {
            Days days = await db.Days.FindAsync(id);
            if (days == null)
            {
                return NotFound();
            }

            db.Days.Remove(days);
            await db.SaveChangesAsync();

            return Ok(days);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DaysExists(string id)
        {
            return db.Days.Count(e => e.label == id) > 0;
        }
    }
}