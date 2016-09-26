using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo2
{
    class PrivateContact : Person
    {
        public string PhoneNumber { get; set; }
        public string Mail { get; set; }
        public DateTime Birthdate { get; set; }

        //utilisation du this optionnel
        public PrivateContact(string n, string ln, string Pn, string m, DateTime b):base(n, ln)
        { 
            PhoneNumber = Pn;
            Mail = m;
            Birthdate = b;
        }

        public PrivateContact(string n, string ln, string Pn, string m) : base(n, ln)
        {
            PhoneNumber = Pn;
            Mail = m;
        }

        public override string ToString()
        {
            return base.ToString()+" "+PhoneNumber+" "+Mail;
        }
        public override bool HasHisBirthday()
        {
            return (DateTime.Today.Month == Birthdate.Month &&
                    DateTime.Today.Year == Birthdate.Year &&
                    DateTime.Today.Day == Birthdate.Day);
        }
        public string Print()
        {
            return this.ToString() + " est un contact privé";
        }
    }
}
