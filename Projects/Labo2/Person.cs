using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo2
{
    public abstract class Person
    {
        public string Name { get; set; }
        public string LastName { get; set; }

        public Person(string name,string lastname)
        {
            Name = name;
            LastName = lastname;
        }
        public override string ToString()
        {
            return LastName + " " + Name;
        }

        public abstract bool HasHisBirthday();



    }
}
