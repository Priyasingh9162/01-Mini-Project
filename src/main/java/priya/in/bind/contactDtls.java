package priya.in.bind;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="contact_dtls")
public class contactDtls {
	@Id
	@SequenceGenerator(name = "contact_dtl", sequenceName ="contact_details", allocationSize =1)
	@GeneratedValue(generator="contact_dtl", strategy = GenerationType.SEQUENCE)
	@Column(name="contact_id")
	private Integer id;
	@Column(name="contact_name")
	private String name;
	@Column(name="contact_email")
	private String email;
	@Column(name="contact_number")
	private Long number;
	
	@CreationTimestamp
	@Column(name="Create_Date",updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(name="Update_Date", insertable = false)
	private LocalDate updatedDate;
	@Column(name="Active_Sw")
	private String activesw;
}
