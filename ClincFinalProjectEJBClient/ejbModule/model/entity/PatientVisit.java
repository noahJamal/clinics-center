package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PATIENT_VISIT database table.
 * 
 */
@Entity
@Table(name="PATIENT_VISIT")
@NamedQuery(name="PatientVisit.findAll", query="SELECT p FROM PatientVisit p")
public class PatientVisit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VIS_ID")
	private long visId;

	@Column(name="APO_ID")
	private BigDecimal apoId;

	@Column(name="VIS_CODE")
	private BigDecimal visCode;

	@Temporal(TemporalType.DATE)
	@Column(name="VIS_DATE")
	private Date visDate;

	@Column(name="VIS_NAME")
	private String visName;

	@Column(name="VIS_TYPE")
	private String visType;

	//bi-directional many-to-one association to DiagnList
	@OneToMany(mappedBy="patientVisit")
	private List<DiagnList> diagnLists;

	//bi-directional many-to-one association to DiscretionSer
	@OneToMany(mappedBy="patientVisit")
	private List<DiscretionSer> discretionSers;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="DOC_ID")
	private Doctor doctor;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PAT_ID")
	private Patient patient;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="patientVisit")
	private List<Prescription> prescriptions;

	//bi-directional many-to-one association to RequestMedChk
	@OneToMany(mappedBy="patientVisit")
	private List<RequestMedChk> requestMedChks;

	public PatientVisit() {
	}

	public long getVisId() {
		return this.visId;
	}

	public void setVisId(long visId) {
		this.visId = visId;
	}

	public BigDecimal getApoId() {
		return this.apoId;
	}

	public void setApoId(BigDecimal apoId) {
		this.apoId = apoId;
	}

	public BigDecimal getVisCode() {
		return this.visCode;
	}

	public void setVisCode(BigDecimal visCode) {
		this.visCode = visCode;
	}

	public Date getVisDate() {
		return this.visDate;
	}

	public void setVisDate(Date visDate) {
		this.visDate = visDate;
	}

	public String getVisName() {
		return this.visName;
	}

	public void setVisName(String visName) {
		this.visName = visName;
	}

	public String getVisType() {
		return this.visType;
	}

	public void setVisType(String visType) {
		this.visType = visType;
	}

	public List<DiagnList> getDiagnLists() {
		return this.diagnLists;
	}

	public void setDiagnLists(List<DiagnList> diagnLists) {
		this.diagnLists = diagnLists;
	}

	public DiagnList addDiagnList(DiagnList diagnList) {
		getDiagnLists().add(diagnList);
		diagnList.setPatientVisit(this);

		return diagnList;
	}

	public DiagnList removeDiagnList(DiagnList diagnList) {
		getDiagnLists().remove(diagnList);
		diagnList.setPatientVisit(null);

		return diagnList;
	}

	public List<DiscretionSer> getDiscretionSers() {
		return this.discretionSers;
	}

	public void setDiscretionSers(List<DiscretionSer> discretionSers) {
		this.discretionSers = discretionSers;
	}

	public DiscretionSer addDiscretionSer(DiscretionSer discretionSer) {
		getDiscretionSers().add(discretionSer);
		discretionSer.setPatientVisit(this);

		return discretionSer;
	}

	public DiscretionSer removeDiscretionSer(DiscretionSer discretionSer) {
		getDiscretionSers().remove(discretionSer);
		discretionSer.setPatientVisit(null);

		return discretionSer;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setPatientVisit(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setPatientVisit(null);

		return prescription;
	}

	public List<RequestMedChk> getRequestMedChks() {
		return this.requestMedChks;
	}

	public void setRequestMedChks(List<RequestMedChk> requestMedChks) {
		this.requestMedChks = requestMedChks;
	}

	public RequestMedChk addRequestMedChk(RequestMedChk requestMedChk) {
		getRequestMedChks().add(requestMedChk);
		requestMedChk.setPatientVisit(this);

		return requestMedChk;
	}

	public RequestMedChk removeRequestMedChk(RequestMedChk requestMedChk) {
		getRequestMedChks().remove(requestMedChk);
		requestMedChk.setPatientVisit(null);

		return requestMedChk;
	}

}