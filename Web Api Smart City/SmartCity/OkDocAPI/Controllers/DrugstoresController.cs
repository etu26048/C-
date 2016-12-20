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
    public class DrugstoresController : ApiController
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET: api/Drugstores
        public IEnumerable<Drugstore> GetPharmacy()
        {
            return db.Pharmacy.Include("locality").ToList();
        }

        // GET: api/Drugstores/5
        [ResponseType(typeof(Drugstore))]
        public async Task<IHttpActionResult> GetDrugstore(long id)
        {
            Drugstore drugstore = await db.Pharmacy.Include("locality").FirstAsync(d => d.Id == id);
            if (drugstore == null)
            {
                return NotFound();
            }

            return Ok(drugstore);
        }

        // PUT: api/Drugstores/5
        [Authorize]
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutDrugstore(long id, Drugstore drugstore)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != drugstore.Id)
            {
                return BadRequest();
            }

            var entity = db.Pharmacy.Find(id);
            entity.Locality = await db.Locations.FindAsync(drugstore.Locality.City, drugstore.Locality.PostalCode);
            
            //if (await db.Locations.FindAsync(drugstore.Locality.City, drugstore.Locality.PostalCode) != null)
            //{
            //    var tmpLocality = drugstore.Locality;
            //    drugstore.Locality = null;
            //    drugstore.Locality = await db.Locations.FindAsync(tmpLocality.City, tmpLocality.PostalCode);
            //}

            //db.Entry(drugstore).State = EntityState.Modified;
            //db.Entry(drugstore.Locality).State = EntityState.Modified;
            entity.Name = drugstore.Name;
            entity.latitude = drugstore.latitude;
            entity.longitude = drugstore.longitude;
            entity.Number = drugstore.Number;
            entity.Street = drugstore.Street;
            entity.PhoneNumber = drugstore.PhoneNumber;
            entity.URLWebSite = drugstore.URLWebSite;
            entity.Watch = drugstore.Watch;
            //entity.Schedule = drugstore.Schedule;
            //entity.Holiday = drugstore.Holiday;
            entity.RowVersion = drugstore.RowVersion;

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
        [Authorize]
        [ResponseType(typeof(Drugstore))]
        public async Task<IHttpActionResult> PostDrugstore(Drugstore drugstore)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            if (await db.Locations.FindAsync(drugstore.Locality.City, drugstore.Locality.PostalCode) != null)
            {

                drugstore.Locality = await db.Locations.FindAsync(drugstore.Locality.City, drugstore.Locality.PostalCode);
                db.Pharmacy.Add(drugstore);
            }
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = drugstore.Id }, drugstore);
        }

        // DELETE: api/Drugstores/5
        [Authorize]
        [ResponseType(typeof(Drugstore))]
        public async Task<IHttpActionResult> DeleteDrugstore(long id)
        {
            Drugstore drugstore = await db.Pharmacy.FindAsync(id);
            if (drugstore == null)
            {
                return NotFound();
            }

            IEnumerable<Schedule> schedules = drugstore.Schedule.ToList();
            if (schedules != null)
            {
                foreach (var schedule in schedules)
                {
                    db.Schedules.Remove(schedule);
                }

            }

            IEnumerable<Holiday> holidays = drugstore.Holiday.ToList();
            if (holidays != null)
            {
                foreach (var holiday in holidays)
                {
                    db.Holidays.Remove(holiday);
                }

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

        private bool DrugstoreExists(long id)
        {
            return db.Pharmacy.Count(e => e.Id == id) > 0;
        }
    }
}