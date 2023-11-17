package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the MEDICINE database table.
 * 
 */
@Entity
@NamedQuery(name="Medicine.findAll", query="SELECT m FROM Medicine m")

public class Medicine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MED_ID")
	private long medId;


	@Column(name="MED_CODE")
	private BigDecimal medCode;

	@Column(name="MED_NAME")
	private String medName;

	@Column(name="MED_PRICE")
	private BigDecimal medPrice;

	@Column(name="MED_S_NAME")
	private String medSName;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="medicine")
	private List<Prescription> prescriptions;

	public Medicine() {
	}

	public long getMedId() {
		return this.medId;
	}

	public void setMedId(long medId) {
		this.medId = medId;
	}

	

	

	public BigDecimal getMedCode() {
		return this.medCode;
	}

	public void setMedCode(BigDecimal medCode) {
		this.medCode = medCode;
	}

	public String getMedName() {
		return this.medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public BigDecimal getMedPrice() {
		return this.medPrice;
	}

	public void setMedPrice(BigDecimal medPrice) {
		this.medPrice = medPrice;
	}

	public String getMedSName() {
		return this.medSName;
	}

	public void setMedSName(String medSName) {
		this.medSName = medSName;
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
		prescription.setMedicine(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setMedicine(null);

		return prescription;
	}

}