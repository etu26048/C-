using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.Spatial;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartCity.Models
{
    public class Hospital
    {

        public Hospital()
        {
            this.Schedule = new HashSet<Schedule>();
        }

        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }
        [StringLength(80)]
        [Url (ErrorMessage = "L'Url n'est pas valide !")]
        public string URLWebSite { get; set; }
        [StringLength(10)]
        [RegularExpression("[0-9]{9,11}")]
        public string EmergencyPhone { get; set; }
        [Required]
        [StringLength(80)]
        [Index(IsUnique = true)]
        [RegularExpression("([a-z][A-Z])+")]
        public string Name { get; set; }
        [Required]
        [StringLength(10)]
        public string PhoneNumber { get; set; }
        [StringLength(10)]
        public string Fax { get; set; }
        [StringLength(50)]
        [EmailAddress]
        public string Email { get; set; }
        [Required]
        [StringLength(60)]
        public string Street { get; set; }
        [Required]
        [StringLength(6)]
        public string Number { get; set; }
        [Required]
        public Locality Locality { get; set; }
        [Required]
        public double longitude { get; set; }
        [Required]
        public double latitude { get; set; }
        public virtual ICollection<Schedule> Schedule { get; set; }
        [Timestamp]
        public byte[] RowVersion { get; set; }
    }

}
