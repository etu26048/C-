using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo
{
    public class Pupil : Person
    {
        public int Grade { get; set; }
        public List<Activity> ListActivities { get; set; }
        public char[] pupilsEvaluations { get; set; }

        public delegate string DelegatePrintActivityCompulsory(Activity activity);

        public Dictionary<string, char> PupilActivities
        {
            get
            {
                return pupilActivities;
            }

            set
            {
                pupilActivities = value;
            }
        }

        //Base signifie qu'on fait appel à un constructeur de la classe mère
        private Dictionary<string, char> pupilActivities = new Dictionary<string, char>();

        public Pupil(string name, int age,int grade):base(name,age)
        {
            Grade = grade;
            ListActivities = new List<Activity>();
            //
            pupilsEvaluations = new char[Parameter.max];
            //
        }

        public Pupil(String name, int age) : this(name, age, 1) {}
        
        public void AddActivity(Activity a)
        {
            ListActivities.Add(a);
        }

        //public void AddActivity(String activityTitle)
        //{
        //    PupilActivities.Add(activityTitle, '0');
        //}

        public override string ToString()
        {
            string ch = HeaderPupil();
            ch = PrintActivities(ref ch);
            return ch;
        }

        private string HeaderPupil() { return base.ToString(); }
        //obliger de mettre ref ?
        /*private string PrintActivities(ref string ch)
        {
            int cptActivities = ListActivities.Count();
            if (cptActivities == 0)
                ch += " n'a pas encore choisi d'activité";
            else
            {
                //Pour remplacer le \n => Environement.NewLine , si on ne sait pas sur quel OS on tourne
                ch += " à choisi les activités suivantes : \n";
                foreach (Activity activity in ListActivities)
                {
                    ch += " " + activity + " " + pupilsEvaluations[ListActivities.IndexOf(activity)] + " \n";
                }
            }
            return ch;
        }*/
        private string PrintActivities(ref string ch)
        {
            int cptActivities = PupilActivities.Count();
            if (cptActivities == 0)
                ch += " n'a pas encore choisi d'activité";
            else
            {
                ch += " à choisi les activités suivantes : "+Environment.NewLine;
                for(int i=0;i<cptActivities;i++)
                {
                    ch += "\n" + PupilActivities.ElementAt(i).Key.ToString() + " : " + PupilActivities.ElementAt(i).Value;
                }
            }
            return ch;
        }
        //L'initialisation dans la méthode permet de ne pas mettre d'argument (comme  en js )
        /*public void AddEvaluation(String title = null,char evaluation = (char)Parameter.Evaluation.Satisfaisant)
        {
            if (title == null)
                System.Console.Write("Aucune activité à évaluée\n");
            else
            {
                foreach (Activity activity in ListActivities)
                {
                    if (activity.Title == title)
                        pupilsEvaluations[ListActivities.IndexOf(activity)] = evaluation;
                }
            }
        }*/
        public void AddEvaluation(string title = null, char evaluation = 'S')
        {
            if (title != null) PupilActivities[title] = evaluation;
        }
           

        public void PrintTab()
        {
            for(var i = 0; i < 10;i++)
            {
                System.Console.Write(pupilsEvaluations[i]+"\n");
            }
        }

        public string PrintPupilActivityCompulsory(DelegatePrintActivityCompulsory MyPrintActivity)
        {
            /*int numAct = 0;
            string ch = base.ToString() + " a choisi les activités obligatoires : \n";
            foreach(var  activity in PupilActivities)
            {
                var act = new Activity(activity.Key, true);
                if (act.Compulsory)
                    ch += (++numAct) + " " + MyPrintActivity(act);
            }
            return ch;*/

            int numAct = 0;
            string ch = base.ToString() + " a choisi les activités obligatoires : \n";
            foreach (var activity in ListActivities)
            {
                if (activity.Compulsory)
                    ch += (++numAct) + " " + MyPrintActivity(activity);
            }
            return ch;
        }




    }
}
