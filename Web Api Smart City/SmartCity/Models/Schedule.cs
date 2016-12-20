using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartCity.Models
{
    public class Schedule
    {
        [Timestamp]
        public byte[] RowVersion { get; set; }

        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long ID { get; set; }
        [Required]
        public TimeSpan StartHourAm { get; set; }
        [Required]
        public TimeSpan EndhourAm { get; set; }
        [Required]
        public TimeSpan StartHourPm { get; set; }
        [Required]
        public TimeSpan EndhourPm { get; set; }
        [Required]
        public string Day { get; set; }
        /*public long HospitalID { get; set; }
        [ForeignKey("HospitalID")]
        public Hospital Hospital { get; set; }*/
    }
}
