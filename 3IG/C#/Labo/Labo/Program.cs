using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo
{
    class Program
    {
        static void Main(string[] args)
        {
            Pupil pupil1 = new Pupil("chalal", 21);
            Pupil pupil2 = new Pupil("Genin", 25);
            Activity dessin = new Activity("dessin", true);
            Activity coloriage = new Activity("coloriage", false);
            pupil1.AddActivity(dessin);
            pupil1.AddActivity(coloriage);

            System.Console.Write(pupil1);
            System.Console.Write(pupil2);
            System.Console.Read();

        }
    }
}
