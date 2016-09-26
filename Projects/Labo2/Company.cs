using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo2
{ 
    class Company
    {
        public string CompanyName { get; set; }
        public string HQ_Location { get; set; }

        public Company(string companyName, string hQ_location)
        {
            CompanyName = companyName;
            HQ_Location = hQ_location;
        }
        public override string ToString()
        {
            return CompanyName + " " + HQ_Location;
        }
    }
}
