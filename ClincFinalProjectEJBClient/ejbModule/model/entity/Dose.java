package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DOSE database table.
 * 
 */
@Entity
@NamedQuery(name="Dose.findAll", query="SELECT d FROM Dose d")
public class Dose implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DOSE_ID")
	private long doseId;

	@Column(name="DOES_CODE")
	private BigDecimal doesCode;

	@Column(name="DOES_COUN")
	private String doesCoun;

	@Column(name="DOES_NAME")
	private String doesName;

	@Column(name="DOES_NOTE")
	private String doesNote;

	@Column(name="DOES_SIZE")
	private String doesSize;

	@Column(name="DOES_TIME")
	private String doesTime;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="dose")
	private List<Prescription> prescriptions;

	public Dose() {
	}

	public long getDoseId() {
		return this.doseId;
	}

	public void setDoseId(long doseId) {
		this.doseId = doseId;
	}

	public BigDecimal getDoesCode() {
		return this.doesCode;
	}

	public void setDoesCode(BigDecimal doesCode) {
		this.doesCode = doesCode;
	}

	public String getDoesCoun() {
		return this.doesCoun;
	}

	public void setDoesCoun(String doesCoun) {
		this.doesCoun = doesCoun;
	}

	public String getDoesName() {
		return this.doesName;
	}

	public void setDoesName(String doesName) {
		this.doesName = doesName;
	}

	public String getDoesNote() {
		return this.doesNote;
	}

	public void setDoesNote(String doesNote) {
		this.doesNote = doesNote;
	}

	public String getDoesSize() {
		return this.doesSize;
	}

	public void setDoesSize(String doesSize) {
		this.doesSize = doesSize;
	}

	public String getDoesTime() {
		return this.doesTime;
	}

	public void setDoesTime(String doesTime) {
		this.doesTime = doesTime;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setDose(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setDose(null);

		return prescription;
	}

}