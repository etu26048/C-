using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartCity.Models
{
    public class Holiday
    {
        [Timestamp]
        public byte[] RowVersion { get; set; }
        public Holiday()
        {
            //this.Doctor = new HashSet<Doctor>();
            //this.Hospital = new HashSet<Hospital>();
            //this.Postguard = new HashSet<Postguard>();
            //this.Drugstore = new HashSet<Drugstore>();
        }
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long ID { get; set; }
        [Required]
        public DateTime StartDate { get; set; }
        [Required]
        public DateTime EndDate { get; set; }
        public string label { get; set; }
    }
}
