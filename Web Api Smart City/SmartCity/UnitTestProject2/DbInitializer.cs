using Microsoft.VisualStudio.TestTools.UnitTesting;
using Models;
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
                Id = "BE0123456789",
                URLWebSite = "https://www.chrn.be/",
                PhoneNumber = "081726707",
                Name = "Centre hospitalier regional de namur et maternite - CHRN",
                Description = "",
                Fax = "081726111",
                Email = "direction@chrnamur.be",
                EmergencyPhone = "081726805",
                Street = "Avenue Albert 1er",
                Number = 185,
                locality = new Locality()
                {
                    City = "Namur",
                    PostalCode = 5000
                },
                //LatLng = DbGeography.FromText("POINT(50.467079 4.886160)")
            };

            context.Hospital.Add(hospital);
            context.SaveChanges();
        }
        
    }
}
