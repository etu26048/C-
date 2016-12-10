using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class Locality
    {
        [Key]
        [Column(Order = 1)]
        [Required]
        [StringLength(25)]
        public string City { get; set; }
        [Key]
        [Column(Order = 2)]
        [Required]
        public int PostalCode { get; set; }
    }
}
