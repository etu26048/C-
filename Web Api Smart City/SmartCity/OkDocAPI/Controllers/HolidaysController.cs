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
    public class HolidaysController : ApiController
    {
        private SmartCityContext db = new SmartCityContext();

        // GET: api/Holidays
        public IQueryable<Holiday> GetHolidays()
        {
            return db.Holidays;
        }

        // GET: api/Holidays/5
        [ResponseType(typeof(Holiday))]
        public async Task<IHttpActionResult> GetHoliday(long id)
        {
            Holiday holiday = await db.Holidays.FindAsync(id);
            if (holiday == null)
            {
                return NotFound();
            }

            return Ok(holiday);
        }

        // PUT: api/Holidays/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutHoliday(long id, Holiday holiday)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != holiday.ID)
            {
                return BadRequest();
            }

            db.Entry(holiday).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!HolidayExists(id))
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

        // POST: api/Holidays
        [ResponseType(typeof(Holiday))]
        public async Task<IHttpActionResult> PostHoliday(Holiday holiday)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Holidays.Add(holiday);
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = holiday.ID }, holiday);
        }

        // DELETE: api/Holidays/5
        [ResponseType(typeof(Holiday))]
        public async Task<IHttpActionResult> DeleteHoliday(long id)
        {
            Holiday holiday = await db.Holidays.FindAsync(id);
            if (holiday == null)
            {
                return NotFound();
            }

            db.Holidays.Remove(holiday);
            await db.SaveChangesAsync();

            return Ok(holiday);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool HolidayExists(long id)
        {
            return db.Holidays.Count(e => e.ID == id) > 0;
        }
    }
}