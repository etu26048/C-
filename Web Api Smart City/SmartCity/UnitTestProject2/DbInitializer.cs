using Microsoft.VisualStudio.TestTools.UnitTesting;
using SmartCity.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Spatial;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestProject2
{
    class DbInitializer : DropCreateDatabaseAlways<SmartCityContext>
    {
        protected override void Seed(SmartCityContext context)
        {
            Hospital hospital = new Hospital()
            {
                URLWebSite = "https://www.chrn.be/",
                PhoneNumber = "081726707",
                Name = "Centre hospitalier regional de namur et maternite - CHRN",
                Fax = "081726111",
                Email = "direction@chrnamur.be",
                EmergencyPhone = "081726805",
                Street = "Avenue Albert 1er",
                Number = "185",
                Locality = new Locality()
                {
                    City = "Namur",
                    PostalCode = 5000
                },
            };

            Schedule schedule = new Schedule()
            {
                StartHour = DateTime.Now,
                Endhour = DateTime.Now,
                Day = "lundi"
            };

            context.Schedules.Add(schedule);
            context.Hospital.Add(hospital);
            context.SaveChanges();
        }

}
}
