using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo2
{
    class ContactCar
    {
        private Person person;
        private Car car;

        public ContactCar(Person p, Car c)
        {
            person = p;
            car = c;
        }
        public void DynamicPrint(dynamic objet)
        {
            System.Console.Write(objet.Print() + " voiture : " + car.ToString()+Environment.NewLine);
        }

    }
}
