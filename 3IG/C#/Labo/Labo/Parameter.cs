using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo
{
    public static class Parameter
    {
        public const int max = 10;
        
        //Obliger de mettre max en public ?
        public enum Evaluation
        {
            Recommencer = 'R',Satisfaisant = 'S',TrèsBien = 'T'
        };
    }
}
