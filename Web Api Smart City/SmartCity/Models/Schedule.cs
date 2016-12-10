using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class Schedule
    {
        public Schedule()
        {
            this.Doctor = new HashSet<Doctor>();
            this.Hospital = new HashSet<Hospital>();
            this.Postguard = new HashSet<Postguard>();
            this.Drugstore = new HashSet<Drugstore>();
        }
        [Key]
        public long ID { get; set; }
        [Required]
        public DateTime StartHour { get; set; }
        [Required]
        public DateTime Endhour { get; set; }
        [Required]
        public Days days { get; set; }
        //Ca ne fonctionne pas 
        public virtual ICollection<Doctor> Doctor { get; set; }
        public virtual ICollection<Hospital> Hospital { get; set; }
        public virtual ICollection<Drugstore> Drugstore { get; set; }
        public virtual ICollection<Postguard> Postguard { get; set; }
    }
}
