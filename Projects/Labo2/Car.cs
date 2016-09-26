using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo2
{
    class Car
    {
        private string plaque;

        public Car(string p)
        {
            plaque = p;
        }

        public override string ToString()
        {
            return plaque;
        }
    }
}
