package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the DIAGN_LIST database table.
 * 
 */
@Entity
@Table(name="DIAGN_LIST")
@NamedQuery(name="DiagnList.findAll", query="SELECT d FROM DiagnList d")
public class DiagnList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DIALI_ID")
	private long dialiId;

	@Column(name="DIALI_CODE")
	private BigDecimal dialiCode;

	@Temporal(TemporalType.DATE)
	@Column(name="DIALI_DATE")
	private Date dialiDate;

	@Column(name="DIALI_NAME")
	private String dialiName;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to Diagnosi
	@ManyToOne
	@JoinColumn(name="DIG_ID")
	private Diagnosi diagnosi;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PAT_ID")
	private Patient patient;

	//bi-directional many-to-one association to PatientVisit
	@ManyToOne
	@JoinColumn(name="VIS_ID")
	private PatientVisit patientVisit;

	public DiagnList() {
	}

	public long getDialiId() {
		return this.dialiId;
	}

	public void setDialiId(long dialiId) {
		this.dialiId = dialiId;
	}

	public BigDecimal getDialiCode() {
		return this.dialiCode;
	}

	public void setDialiCode(BigDecimal dialiCode) {
		this.dialiCode = dialiCode;
	}

	public Date getDialiDate() {
		return this.dialiDate;
	}

	public void setDialiDate(Date dialiDate) {
		this.dialiDate = dialiDate;
	}

	public String getDialiName() {
		return this.dialiName;
	}

	public void setDialiName(String dialiName) {
		this.dialiName = dialiName;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public Diagnosi getDiagnosi() {
		return this.diagnosi;
	}

	public void setDiagnosi(Diagnosi diagnosi) {
		this.diagnosi = diagnosi;
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