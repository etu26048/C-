using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo
{
    public class PersonComparer : IEqualityComparer<Person>
    {
        
        Boolean IEqualityComparer<Person>.Equals(Person p1,Person p2)
        {
            return (p1 == p2 || (p1.Age == p2.Age && p1.Name == p2.Name)) ;
        }
        int IEqualityComparer<Person>.GetHashCode(Person obj)
        {
            return obj.Age ^ obj.Name.GetHashCode();
        }

    }
}
