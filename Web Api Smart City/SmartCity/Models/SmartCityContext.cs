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
        public DbSet<Hospital> Hospital { get; set; }
        public DbSet<Doctor> Doctor { get; set; }
        public DbSet<Drugstore> Pharmacy { get; set; }
        public DbSet<Postguard> GuardPost { get; set; }
        public DbSet<EmergencyCall> EmergencyCall { get; set; }
        public DbSet<Locality> Locations { get; set; }
        public DbSet<Holiday> Holidays { get; set; }
        public DbSet<Days> Days { get; set; }
        public DbSet<Schedule> Schedules { get; set; }
        public SmartCityContext() : base(@"Data Source=smartcity.database.windows.net;Initial Catalog=OkDocSQL;Integrated Security=False;User ID=yassin;Password=Katybatter1972;Connect Timeout=60;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False")
        {

        }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
        }
    }
}
