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
    public class EmergencyCallsController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/EmergencyCalls
        public IEnumerable<EmergencyCall> GetEmergencyCall()
        {
            return db.EmergencyCall.ToList();
        }

        // GET: api/EmergencyCalls/5
        [ResponseType(typeof(EmergencyCall))]
        public async Task<IHttpActionResult> GetEmergencyCall(string id)
        {
            EmergencyCall emergencyCall = await db.EmergencyCall.FindAsync(id);
            if (emergencyCall == null)
            {
                return NotFound();
            }

            return Ok(emergencyCall);
        }

        // PUT: api/EmergencyCalls/5
        [Authorize]
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutEmergencyCall(string id, EmergencyCall emergencyCall)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != emergencyCall.PhoneNumberID)
            {
                return BadRequest();
            }

            db.Entry(emergencyCall).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!EmergencyCallExists(id))
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

        // POST: api/EmergencyCalls
        [Authorize]
        [ResponseType(typeof(EmergencyCall))]
        public async Task<IHttpActionResult> PostEmergencyCall(EmergencyCall emergencyCall)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.EmergencyCall.Add(emergencyCall);

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (EmergencyCallExists(emergencyCall.PhoneNumberID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = emergencyCall.PhoneNumberID }, emergencyCall);
        }

        // DELETE: api/EmergencyCalls/5
        [Authorize]
        [ResponseType(typeof(EmergencyCall))]
        public async Task<IHttpActionResult> DeleteEmergencyCall(string id)
        {
            EmergencyCall emergencyCall = await db.EmergencyCall.FindAsync(id);
            if (emergencyCall == null)
            {
                return NotFound();
            }

            db.EmergencyCall.Remove(emergencyCall);
            await db.SaveChangesAsync();

            return Ok(emergencyCall);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool EmergencyCallExists(string id)
        {
            return db.EmergencyCall.Count(e => e.PhoneNumberID == id) > 0;
        }
    }
}