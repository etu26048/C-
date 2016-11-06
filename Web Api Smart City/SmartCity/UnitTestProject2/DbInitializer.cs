using Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTestProject2
{
    class DbInitializer : DropCreateDatabaseAlways<SmartCityContext>
    {
        protected override void Seed(SmartCityContext context)
        {
            Hopital hospital = new Hopital();
            Medecin medecin = new Medecin();
            context.Medecin.Add(medecin);
            context.Hospital.Add(hospital);
            context.SaveChanges();
        }
    }
}
