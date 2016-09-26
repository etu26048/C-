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
            Pupil pupil3 = new Pupil("Opde", 20,4);
            Pupil pupil4 = new Pupil("Xavier", 50,3);
            Pupil pupil5 = new Pupil("wolverine", 40, 5);
            Pupil pupil6 = new Pupil("Le fauve", 35);
            Pupil pupil7 = new Pupil("ouioui", 4);

            List<Pupil> listPupil = new List<Pupil>();
            listPupil.Add(pupil1);
            listPupil.Add(pupil2);
            listPupil.Add(pupil3);
            listPupil.Add(pupil7);
            listPupil.Add(pupil5);
            listPupil.Add(pupil4);
            listPupil.Add(pupil6);

            /*
            var pupilGrade1Plus6 = from pupil in listPupil
                                   where pupil.Age > 6 && pupil.Grade == 1
                                   select pupil;
            */

            //var pupilGrade1Plus6 = listPupil.Where(pupil => pupil.Age > 6 && pupil.Grade == 1);

            //if (pupilGrade1Plus6 != null)
            //{
            //    System.Console.Write("Liste des pupils de 1ère année et de plus de 6 ans\n");
            //    foreach (var pupil in pupilGrade1Plus6)
            //    {
            //        System.Console.Write(pupil.Name+"\n");
            //    }
            //}
            //System.Console.Write("Page 12 : covariance"+Environment.NewLine);
            
            //List<Pupil> listPupils = new List<Pupil>()
            //{
            //    new Pupil("Moi",12),
            //    new Pupil("Lui",15,6),
            //    new Pupil("Elle",6,2)
            //};
            //List<Person> listPersons = new List<Person>()
            //{
            //    new Person("Madame",25),
            //    new Person("Monsieur",35)
            //};

            //var listFusion = listPersons.Union(listPupils);
            //foreach(Object person in listFusion)
            //{
            //    System.Console.Write(person+Environment.NewLine);
            //}

            //List<Pupil> listPupilsDuplicated = new List<Pupil>()
            //{
            //    new Pupil("Wolverine",100,4),
            //    new Pupil("Charles Xavier",54),
            //    new Pupil("Le fauve",50,4),
            //    new Pupil("Wolverine",100,4),
            //    new Pupil("Charles Xavier",54),
            //    new Pupil("Le fauve",50,4)
            //};

            //System.Console.Write("No duplicated list" + Environment.NewLine);
            //IEnumerable<Pupil> listPupilsNoDuplicated = listPupilsDuplicated.Distinct<Pupil>(new PersonComparer());
            //foreach(Pupil pupil in listPupilsNoDuplicated)
            //{
            //    System.Console.Write(pupil + Environment.NewLine);
            //}

            System.Console.Write("Activité"+Environment.NewLine);
            Activity dessin = new Activity("dessin", true);
            Activity coloriage = new Activity("coloriage", false);
            pupil1.AddActivity("dessin");
            pupil1.AddActivity("coloriage");

            pupil1.AddEvaluation("dessin");
            pupil1.AddEvaluation(evaluation : 'B',title: "coloriage");
            
            pupil2.AddActivity("coloriage");
            
            System.Console.Write(pupil1);
            pupil1.PrintTab();
            System.Console.Write(pupil2);
            pupil2.AddEvaluation();
            System.Console.Read();

        }
    }
}
