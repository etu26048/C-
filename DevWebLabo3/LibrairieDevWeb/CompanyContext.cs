using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace LibrairieDevWeb
{
    public class CompanyContext : DbContext
    {
        public DbSet<Customer> Customers { get; set; }
        public CompanyContext() : base(@"Data Source = (localdb)\MSSQLLocalDB; Initial Catalog=FirstDataBase;")
        {

        }
    }
}
