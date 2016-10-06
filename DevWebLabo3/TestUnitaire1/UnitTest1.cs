using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Data.Entity;
using LibrairieDevWeb;
using System.Linq;
using System.Data.Entity.Infrastructure;

namespace TestUnitaire1
{
    [TestClass]
    public class UnitTest1
    {
        [TestInitialize]
        public void Setup()
        {
            Database.SetInitializer(new DbInitializer());
            using (CompanyContext context = GetContext())
            {
                context.Database.Initialize(true);
            }
        }

        [TestMethod]
        public void InsertionFonctionnelle()
        {
            using (var context = GetContext())  
            {
                Assert.AreEqual(1, context.Customers.ToList().Count);
            }
        }

        private CompanyContext GetContext()
        {
            return new CompanyContext();
        }

        [TestMethod]
        [ExpectedException(typeof(DbUpdateConcurrencyException))]
        public void AjouterMontantTest()
        {
            using (CompanyContext _contextDeJohn = GetContext())
            {
                using (CompanyContext _contextDeSophie = GetContext())
                {
                    var clientDeJohn = _contextDeJohn.Customers.First();
                    var clientDeSophie = _contextDeSophie.Customers.First();

                    clientDeJohn.AccountBalance += 25;
                    _contextDeJohn.SaveChanges();
                    clientDeSophie.AccountBalance += 100;
                    _contextDeSophie.SaveChanges();
                }
            }
        }
        
       
    }
}
