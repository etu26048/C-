using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class Hopital
    {
        public String Id { get; set; }
        public String URLWebSite { get; set; }
        public String EmergencyPhone { get; set; }
        public String Name { get; set; }
        public String PhoneNumber { get; set; }
        public String Fax { get; set; }
        public String Email { get; set; }
        public String Street { get; set; }
        public Int32 Number { get; set; }
        public Int32 PostalCode { get; set; }
        public String City { get; set; }
        public String Country { get; set; }
        public Double Latitude { get; set; }
        public Double Longitude { get; set; }
    }

}
