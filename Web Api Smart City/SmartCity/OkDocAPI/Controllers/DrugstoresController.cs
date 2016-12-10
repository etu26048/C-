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
    public class DrugstoresController : ApiController
    {
        private SmartCityContext db = new SmartCityContext();

        // GET: api/Drugstores
        public IQueryable<Drugstore> GetPharmacy()
        {
            return db.Pharmacy;
        }

        // GET: api/Drugstores/5
        [ResponseType(typeof(Drugstore))]
        public async Task<IHttpActionResult> GetDrugstore(string id)
        {
            Drugstore drugstore = await db.Pharmacy.FindAsync(id);
            if (drugstore == null)
            {
                return NotFound();
            }

            return Ok(drugstore);
        }

        // PUT: api/Drugstores/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutDrugstore(string id, Drugstore drugstore)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != drugstore.Id)
            {
                return BadRequest();
            }

            db.Entry(drugstore).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DrugstoreExists(id))
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

        // POST: api/Drugstores
        [ResponseType(typeof(Drugstore))]
        public async Task<IHttpActionResult> PostDrugstore(Drugstore drugstore)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Pharmacy.Add(drugstore);

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (DrugstoreExists(drugstore.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = drugstore.Id }, drugstore);
        }

        // DELETE: api/Drugstores/5
        [ResponseType(typeof(Drugstore))]
        public async Task<IHttpActionResult> DeleteDrugstore(string id)
        {
            Drugstore drugstore = await db.Pharmacy.FindAsync(id);
            if (drugstore == null)
            {
                return NotFound();
            }

            db.Pharmacy.Remove(drugstore);
            await db.SaveChangesAsync();

            return Ok(drugstore);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DrugstoreExists(string id)
        {
            return db.Pharmacy.Count(e => e.Id == id) > 0;
        }
    }
}