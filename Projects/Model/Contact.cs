using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Contact
    {
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Email { get; set; }

        public Contact(string firstName, string lastName,string email)
        {
            FirstName = firstName;
            LastName = lastName;
            Email = email;
        }
    }
}
