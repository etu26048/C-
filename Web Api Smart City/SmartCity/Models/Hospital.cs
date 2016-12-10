using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity.Spatial;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Models
{
    public class Hospital
    {
        public Hospital()
        {
            this.Holiday = new HashSet<Holiday>();
            this.Schedule = new HashSet<Schedule>();
        }
        [Required]
        public string Id { get; set; }
        [StringLength(80)]
        public string URLWebSite { get; set; }
        [StringLength(10)]
        public string EmergencyPhone { get; set; }
        [StringLength(50)]
        public string Description { get; set; }
        [Required]
        [StringLength(80)]
        public string Name { get; set; }
        [Required]
        [StringLength(10)]
        public string PhoneNumber { get; set; }
        [StringLength(10)]
        public string Fax { get; set; }
        [StringLength(50)]
        public string Email { get; set; }
        [Required]
        [StringLength(60)]
        public string Street { get; set; }
        [Required]
        public int Number { get; set; }
        [Required]
        public Locality locality { get; set; }
        //[Required]
        //public DbGeography LatLng { get; set; }
        public virtual ICollection<Holiday> Holiday { get; set; }
        public virtual ICollection<Schedule> Schedule { get; set; }
    }

}
