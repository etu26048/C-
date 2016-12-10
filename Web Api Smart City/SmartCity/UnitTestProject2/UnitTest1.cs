using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Data.Entity.Infrastructure;
using Models;
using System.Data.Entity;
using System.Linq;

namespace UnitTestProject2
{
    [TestClass]
    public class UnitTest1
    {
        [TestInitialize]
        public void Setup()
        {
            Database.SetInitializer(new DbInitializer());
            using (SmartCityContext context = GetContext())
            {
                context.Database.Initialize(true);
            }
        }

        private static SmartCityContext GetContext()
        {
            return new SmartCityContext();
        }

        [TestMethod]
        public void HasOneHospital()
        {
            using (var context = GetContext())
            {
                Assert.AreEqual(1, context.Hospital.ToList().Count);
            }
        }

    }
}
