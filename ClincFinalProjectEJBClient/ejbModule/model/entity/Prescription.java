package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PRESCRIPTION database table.
 * 
 */
@Entity
@NamedQuery(name="Prescription.findAll", query="SELECT p FROM Prescription p")
public class Prescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRE_ID")
	private long preId;

	@Column(name="PRE_CODE")
	private BigDecimal preCode;

	@Temporal(TemporalType.DATE)
	@Column(name="PRE_DATE")
	private Date preDate;

	@Column(name="PRE_NAME")
	private String preName;

	//bi-directional many-to-one association to Dose
	@ManyToOne
	@JoinColumn(name="DOS_ID")
	private Dose dose;

	//bi-directional many-to-one association to Medicine
	@ManyToOne
	@JoinColumn(name="MED_ID")
	private Medicine medicine;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PAT_ID")
	private Patient patient;

	//bi-directional many-to-one association to PatientVisit
	@ManyToOne
	@JoinColumn(name="VIS_ID")
	private PatientVisit patientVisit;

	public Prescription() {
	}

	public long getPreId() {
		return this.preId;
	}

	public void setPreId(long preId) {
		this.preId = preId;
	}

	public BigDecimal getPreCode() {
		return this.preCode;
	}

	public void setPreCode(BigDecimal preCode) {
		this.preCode = preCode;
	}

	public Date getPreDate() {
		return this.preDate;
	}

	public void setPreDate(Date preDate) {
		this.preDate = preDate;
	}

	public String getPreName() {
		return this.preName;
	}

	public void setPreName(String preName) {
		this.preName = preName;
	}

	public Dose getDose() {
		return this.dose;
	}

	public void setDose(Dose dose) {
		this.dose = dose;
	}

	public Medicine getMedicine() {
		return this.medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
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

}