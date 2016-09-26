using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo2
{
    class Program
    {
        static void Main(string[] args)
        {
            PrivateContact private1 = new PrivateContact("yasser", "chalal", "0457897546", "chalal.yasser@hotmail.fr");
            PrivateContact private2 = new PrivateContact("jerome", "dey", "0758456584", "dey.jerome@hotmail.Fr",DateTime.Today);
            //if (private2.HasHisBirthday())
            //    System.Console.Write("Bon anniversaire");
            //else
            //    System.Console.Write("Bah non ");

            ProfessionalContact consultant1 = new ProfessionalContact("Antoine", "Durieux", "Consultant", "0481267834", "antoine.durieux@burco.be");
            ProfessionalContact consultant2 = new ProfessionalContact("Jean", "Dubuisson", "Consultant", "0485843791", "j.dubuisson@burco.be");
            ProfessionalContact independant = new ProfessionalContact("Philippe", "Malur", "Indépendant", "0483479412", "philippe.malur@gmail.com");

            Company company1 = new Company("Jerome & co", "rue des noisettes 5060 Sambreville");
            Company company2 = new Company("Chalal soccer", "rue des souliers 1000 Bruxelle");

            consultant1.CompanyAdd(company1);
            consultant1.CompanyAdd(company2);
            consultant2.CompanyAdd(company2);

            List<ProfessionalContact> contacts = new List<ProfessionalContact>() {consultant1, consultant2, independant };

            var independantContacts = from person in contacts
                                      where person.Profession == "Indépendant"
                                      select person;
            if (independantContacts != null)
            {
                foreach (ProfessionalContact contact in independantContacts)
                {
                    System.Console.Write(contact.ToString() + Environment.NewLine);
                }
                System.Console.Write(independantContacts.Count());
            }

            var consultantContacts = contacts.Where(consultant => consultant.Profession == "Consultant" && consultant.Companies);
            if (consultantContacts != null)
            {
                foreach (ProfessionalContact contact in consultantContacts)
                {
                    System.Console.Write(contact.ToString() + Environment.NewLine);
                }
                System.Console.Write(consultantContacts.Count());
            }

            System.Console.Read();

        }
        
    }
}
