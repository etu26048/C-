using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo2
{
    class ProfessionalContact : Person
    {
        public string Profession { get; set; }
        public string ProfessionalPhoneNumber { get; set; }
        public string ProfessionalMail { get; set; }
        public List<Company> Companies { get; set; }
        public ProfessionalContact(string name, string lastname, string p, string ppn, string pm):base(name, lastname)
        {
            Profession = p;
            ProfessionalPhoneNumber = ppn;
            ProfessionalMail = pm;
            Companies = new List<Company>();         
        }

        public override string ToString()
        {
            return base.ToString()+" "+ProfessionalPhoneNumber+" "+Profession+" "+ProfessionalMail;
        }

        public override bool HasHisBirthday()
        {
            return false;
        }

        public void CompanyAdd(Company c)
        {
            Companies.Add(c);
        }




    }   
}
