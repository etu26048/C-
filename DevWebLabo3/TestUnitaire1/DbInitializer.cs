﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LibrairieDevWeb;
using System.Data.Entity;

namespace TestUnitaire1
{
    public class DbInitializer : DropCreateDatabaseAlways<CompanyContext>
    {
        protected override void Seed(CompanyContext context)
        {
            Customer customer = new Customer()
            {
                AccountBalance = 223.14,
                AddressLine1 = "Rue des cerises",
                AddressLine2 = "n25 boite 5",
                City = "Namur",
                Country = "Belgique",
                Email = "Salut.toi@hotmail.Fr",
                Id = 4,
                Name = "JeanJacques",
                PostCode = "5000",
                Remark ="Pas gentil"
            };
            context.Customers.Add(customer);
            context.SaveChanges();
        }
    }
}
