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
    public class PostguardsController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Postguards
        public IEnumerable<Postguard> GetGuardPost()
        {
            return db.GuardPost.Include("locality").ToList();
        }

        // GET: api/Postguards/5
        [ResponseType(typeof(Postguard))]
        public async Task<IHttpActionResult> GetPostguard(long id)
        {
            Postguard postguard = await db.GuardPost.FirstAsync(p => p.Id == id);
            if (postguard == null)
            {
                return NotFound();
            }

            return Ok(postguard);
        }

        // PUT: api/Postguards/5
        [Authorize]
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutPostguard(long id, Postguard postguard)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != postguard.Id)
            {
                return BadRequest();
            }

            db.Entry(postguard).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PostguardExists(id))
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

        // POST: api/Postguards
        [Authorize]
        [ResponseType(typeof(Postguard))]
        public async Task<IHttpActionResult> PostPostguard(Postguard postguard)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (await db.Locations.FindAsync(postguard.Locality.City, postguard.Locality.PostalCode) != null)
            {

                postguard.Locality = await db.Locations.FindAsync(postguard.Locality.City, postguard.Locality.PostalCode);
                db.GuardPost.Add(postguard);
            }
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = postguard.Id }, postguard);
        }

        // DELETE: api/Postguards/5
        [Authorize]
        [ResponseType(typeof(Postguard))]
        public async Task<IHttpActionResult> DeletePostguard(long id)
        {
            Postguard postguard = await db.GuardPost.FindAsync(id);
            if (postguard == null)
            {
                return NotFound();
            }

            IEnumerable<Schedule> schedules = postguard.Schedule.ToList();
            if (schedules != null)
            {
                foreach (var schedule in schedules)
                {
                    db.Schedules.Remove(schedule);
                }

            }

            IEnumerable<Holiday> holidays = postguard.Holiday.ToList();
            if (holidays != null)
            {
                foreach (var holiday in holidays)
                {
                    db.Holidays.Remove(holiday);
                }

            }

            db.GuardPost.Remove(postguard);
            await db.SaveChangesAsync();

            return Ok(postguard);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PostguardExists(long id)
        {
            return db.GuardPost.Count(e => e.Id == id) > 0;
        }
    }
}