using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class SmartCityContext : DbContext
    {
        public DbSet<Hopital> Hospital { get; set; }
        public DbSet<Medecin> Medecin { get; set; }
        public SmartCityContext() : base(@"Data Source=smartcity.database.windows.net;Initial Catalog=OkDocSQL;Integrated Security=False;User ID=yassin;Password=Katybatter1972;Connect Timeout=60;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False") { 

        }
    }
}
