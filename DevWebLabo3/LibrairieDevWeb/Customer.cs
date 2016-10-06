using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibrairieDevWeb
{
    public class Customer
    {
        public double AccountBalance { get; set; }
        public string AddressLine1 { get; set; }
        public string AddressLine2 { get; set; }
        public string City { get; set; }
        public string Country { get; set; }
        public string Email { get; set; }
        public long Id { get; set; }
        public string Name { get; set; }
        public string PostCode { get; set; }
        public string Remark { get; set; }

        [Timestamp]
        public byte[] RowVersion { get; set; }
        //ajout aux close where(where rowVersion = rowVersion), permet de vérifier si le RowVersion du client est le même que celui dans la BD , va les comparer et si pas les même alors y'a eu maj
        //Permet de vérifier si quelqu'un à fait une modification sur la ligne RowVersion correspondante
    }
}
