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
    public class PostguardsController : ApiController
    {
        private SmartCityContext db = new SmartCityContext();

        // GET: api/Postguards
        public IQueryable<Postguard> GetGuardPost()
        {
            return db.GuardPost;
        }

        // GET: api/Postguards/5
        [ResponseType(typeof(Postguard))]
        public async Task<IHttpActionResult> GetPostguard(long id)
        {
            Postguard postguard = await db.GuardPost.FindAsync(id);
            if (postguard == null)
            {
                return NotFound();
            }

            return Ok(postguard);
        }

        // PUT: api/Postguards/5
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
        [ResponseType(typeof(Postguard))]
        public async Task<IHttpActionResult> PostPostguard(Postguard postguard)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.GuardPost.Add(postguard);
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = postguard.Id }, postguard);
        }

        // DELETE: api/Postguards/5
        [ResponseType(typeof(Postguard))]
        public async Task<IHttpActionResult> DeletePostguard(long id)
        {
            Postguard postguard = await db.GuardPost.FindAsync(id);
            if (postguard == null)
            {
                return NotFound();
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