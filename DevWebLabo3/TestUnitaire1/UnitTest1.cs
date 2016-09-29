using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Data.Entity;
using LibrairieDevWeb;
using System.Linq;

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

       
    }
}
