using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo
{
    public class Activity
    {
        public string Title { get; set; }
        public Boolean Compulsory { get; set; }

        public Activity(string title, Boolean compulsory)
        {
            Title = title;
            Compulsory = compulsory;
        }

        public override string ToString()
        {
            string message = Title;
            if (Compulsory)
                message += " (obligatory)";
            return message;
        }
    }
}
