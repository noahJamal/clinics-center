package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DISCRETION_SER database table.
 * 
 */
@Entity
@Table(name="DISCRETION_SER")
@NamedQuery(name="DiscretionSer.findAll", query="SELECT d FROM DiscretionSer d")
public class DiscretionSer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DISC_ID")
	private long discId;

	@Column(name="DISC_CODE")
	private BigDecimal discCode;

	@Temporal(TemporalType.DATE)
	@Column(name="DISC_DATE")
	private Date discDate;

	@Column(name="DISC_NAME")
	private String discName;

	@Column(name="DISC_NOTE")
	private String discNote;

	@Column(name="DISC_PRICE_TOT")
	private BigDecimal discPriceTot;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PAT_ID")
	private Patient patient;

	//bi-directional many-to-one association to PatientVisit
	@ManyToOne
	@JoinColumn(name="VIS_ID")
	private PatientVisit patientVisit;

	//bi-directional many-to-one association to PatSerivce
	@ManyToOne
	@JoinColumn(name="SER_ID")
	private PatSerivce patSerivce;

	public DiscretionSer() {
	}

	public long getDiscId() {
		return this.discId;
	}

	public void setDiscId(long discId) {
		this.discId = discId;
	}

	public BigDecimal getDiscCode() {
		return this.discCode;
	}

	public void setDiscCode(BigDecimal discCode) {
		this.discCode = discCode;
	}

	public Date getDiscDate() {
		return this.discDate;
	}

	public void setDiscDate(Date discDate) {
		this.discDate = discDate;
	}

	public String getDiscName() {
		return this.discName;
	}

	public void setDiscName(String discName) {
		this.discName = discName;
	}

	public String getDiscNote() {
		return this.discNote;
	}

	public void setDiscNote(String discNote) {
		this.discNote = discNote;
	}

	public BigDecimal getDiscPriceTot() {
		return this.discPriceTot;
	}

	public void setDiscPriceTot(BigDecimal discPriceTot) {
		this.discPriceTot = discPriceTot;
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

	public PatientVisit getPatientVisit() {
		return this.patientVisit;
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit = patientVisit;
	}

	public PatSerivce getPatSerivce() {
		return this.patSerivce;
	}

	public void setPatSerivce(PatSerivce patSerivce) {
		this.patSerivce = patSerivce;
	}

}