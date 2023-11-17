package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the APPOINTMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="APO_ID")
	private long apoId;

	@Column(name="APO_CODE")
	private BigDecimal apoCode;

	@Temporal(TemporalType.DATE)
	@Column(name="APO_DATE_TIME")
	private Date apoDateTime;

	@Column(name="APO_NAME")
	private String apoName;

	@Column(name="APO_NOTE")
	private String apoNote;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PAT_ID")
	private Patient patient;

//////////////////////////
@ManyToOne
@JoinColumn(name="DOC_ID")
private Doctor doctor;
/////////////////////////

	public Appointment() {
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public long getApoId() {
		return this.apoId;
	}

	public void setApoId(long apoId) {
		this.apoId = apoId;
	}

	public BigDecimal getApoCode() {
		return this.apoCode;
	}

	public void setApoCode(BigDecimal apoCode) {
		this.apoCode = apoCode;
	}

	public Date getApoDateTime() {
		return this.apoDateTime;
	}

	public void setApoDateTime(Date apoDateTime) {
		this.apoDateTime = apoDateTime;
	}

	public String getApoName() {
		return this.apoName;
	}

	public void setApoName(String apoName) {
		this.apoName = apoName;
	}

	public String getApoNote() {
		return this.apoNote;
	}

	public void setApoNote(String apoNote) {
		this.apoNote = apoNote;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}