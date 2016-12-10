using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class Holiday
    {
        public Holiday()
        {
            this.Doctor = new HashSet<Doctor>();
            this.Hospital = new HashSet<Hospital>();
            this.Postguard = new HashSet<Postguard>();
            this.Drugstore = new HashSet<Drugstore>();
        }
        [Key]
        [Required]
        public long ID { get; set; }
        [Required]
        public DateTime StartDate { get; set; }
        [Required]
        public DateTime EndDate { get; set; }
        [Required]
        public string label { get; set; }
        public virtual ICollection<Doctor> Doctor { get; set; }
        public virtual ICollection<Hospital> Hospital { get; set; }
        public virtual ICollection<Drugstore> Drugstore { get; set; }
        public virtual ICollection<Postguard> Postguard { get; set; }
    }
}
