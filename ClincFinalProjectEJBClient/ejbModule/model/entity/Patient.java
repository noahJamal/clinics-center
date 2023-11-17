package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PATIENT database table.
 * 
 */
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PAT_ID")
	private long patId;

	@Column(name="PAT_ADDRESS")
	private String patAddress;

	@Column(name="PAT_AGE")
	private String patAge;

	@Temporal(TemporalType.DATE)
	@Column(name="PAT_BD")
	private Date patBd;

	@Column(name="PAT_CODE")
	private BigDecimal patCode;

	@Column(name="PAT_EMAIL")
	private String patEmail;

	@Column(name="PAT_F_NAME")
	private String patFName;

	@Column(name="PAT_L_NAME")
	private String patLName;

	@Column(name="PAT_M_NAME")
	private String patMName;

	@Column(name="PAT_PHONE1")
	private String patPhone1;

	@Column(name="PAT_PHONE2")
	private String patPhone2;

	@Column(name="PAT_SAVE_STATE")
	private String patSaveState;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="patient")
	private List<Appointment> appointments;

	//bi-directional many-to-one association to DiagnList
	@OneToMany(mappedBy="patient")
	private List<DiagnList> diagnLists;

	//bi-directional many-to-one association to DiscretionSer
	@OneToMany(mappedBy="patient")
	private List<DiscretionSer> discretionSers;

	//bi-directional many-to-one association to CardInsurance
	@ManyToOne
	@JoinColumn(name="CARD_ID")
	private CardInsurance cardInsurance;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to PatientVisit
	@OneToMany(mappedBy="patient")
	private List<PatientVisit> patientVisits;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="patient")
	private List<Prescription> prescriptions;

	//bi-directional many-to-one association to RequestMedChk
	@OneToMany(mappedBy="patient")
	private List<RequestMedChk> requestMedChks;

	public Patient() {
	}

	public long getPatId() {
		return this.patId;
	}

	public void setPatId(long patId) {
		this.patId = patId;
	}

	public String getPatAddress() {
		return this.patAddress;
	}

	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}

	public String getPatAge() {
		return this.patAge;
	}

	public void setPatAge(String patAge) {
		this.patAge = patAge;
	}

	public Date getPatBd() {
		return this.patBd;
	}

	public void setPatBd(Date patBd) {
		this.patBd = patBd;
	}

	public BigDecimal getPatCode() {
		return this.patCode;
	}

	public void setPatCode(BigDecimal patCode) {
		this.patCode = patCode;
	}

	public String getPatEmail() {
		return this.patEmail;
	}

	public void setPatEmail(String patEmail) {
		this.patEmail = patEmail;
	}

	public String getPatFName() {
		return this.patFName;
	}

	public void setPatFName(String patFName) {
		this.patFName = patFName;
	}

	public String getPatLName() {
		return this.patLName;
	}

	public void setPatLName(String patLName) {
		this.patLName = patLName;
	}

	public String getPatMName() {
		return this.patMName;
	}

	public void setPatMName(String patMName) {
		this.patMName = patMName;
	}

	public String getPatPhone1() {
		return this.patPhone1;
	}

	public void setPatPhone1(String patPhone1) {
		this.patPhone1 = patPhone1;
	}

	public String getPatPhone2() {
		return this.patPhone2;
	}

	public void setPatPhone2(String patPhone2) {
		this.patPhone2 = patPhone2;
	}

	public String getPatSaveState() {
		return this.patSaveState;
	}

	public void setPatSaveState(String patSaveState) {
		this.patSaveState = patSaveState;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setPatient(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setPatient(null);

		return appointment;
	}

	public List<DiagnList> getDiagnLists() {
		return this.diagnLists;
	}

	public void setDiagnLists(List<DiagnList> diagnLists) {
		this.diagnLists = diagnLists;
	}

	public DiagnList addDiagnList(DiagnList diagnList) {
		getDiagnLists().add(diagnList);
		diagnList.setPatient(this);

		return diagnList;
	}

	public DiagnList removeDiagnList(DiagnList diagnList) {
		getDiagnLists().remove(diagnList);
		diagnList.setPatient(null);

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
		discretionSer.setPatient(this);

		return discretionSer;
	}

	public DiscretionSer removeDiscretionSer(DiscretionSer discretionSer) {
		getDiscretionSers().remove(discretionSer);
		discretionSer.setPatient(null);

		return discretionSer;
	}

	public CardInsurance getCardInsurance() {
		return this.cardInsurance;
	}

	public void setCardInsurance(CardInsurance cardInsurance) {
		this.cardInsurance = cardInsurance;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public List<PatientVisit> getPatientVisits() {
		return this.patientVisits;
	}

	public void setPatientVisits(List<PatientVisit> patientVisits) {
		this.patientVisits = patientVisits;
	}

	public PatientVisit addPatientVisit(PatientVisit patientVisit) {
		getPatientVisits().add(patientVisit);
		patientVisit.setPatient(this);

		return patientVisit;
	}

	public PatientVisit removePatientVisit(PatientVisit patientVisit) {
		getPatientVisits().remove(patientVisit);
		patientVisit.setPatient(null);

		return patientVisit;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setPatient(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setPatient(null);

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
		requestMedChk.setPatient(this);

		return requestMedChk;
	}

	public RequestMedChk removeRequestMedChk(RequestMedChk requestMedChk) {
		getRequestMedChks().remove(requestMedChk);
		requestMedChk.setPatient(null);

		return requestMedChk;
	}

}