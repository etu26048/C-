using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartCity.Models
{
    public class EmergencyCall
    {
        [Key]
        [Required]
        [StringLength(15)]
        public string PhoneNumberID { get; set; }
        [Required]
        [StringLength(60)]
        public string Label { get; set; }
        [StringLength(50)]
        public string WebsiteUrl { get; set; }

    }
}
