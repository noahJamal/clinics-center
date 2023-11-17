package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CLINIC_CENTER database table.
 * 
 */
@Entity
@Table(name="CLINIC_CENTER")
@NamedQueries({@NamedQuery(name="ClinicCenter.findAll", query="SELECT c FROM ClinicCenter c")
,@NamedQuery(name="ClinicCenterByName.findAll", query="SELECT c FROM ClinicCenter c where c.cliName=:clinicName")})
public class ClinicCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLI_ID")
	private long cliId;

	@Column(name="CLI_CODE")
	private BigDecimal cliCode;

	@Column(name="CLI_LOC")
	private String cliLoc;

	@Column(name="CLI_NAME")
	private String cliName;

	@Column(name="CLI_NOTE")
	private String cliNote;
	
	@Column(name="CLI_PHONE_NO")
	private String cliPhoneNo;
	
	
	
	public String getCliPhoneNo() {
		return cliPhoneNo;
	}

	public void setCliPhoneNo(String cliPhoneNo) {
		this.cliPhoneNo = cliPhoneNo;
	}

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="clinicCenter")
	private List<Appointment> appointments;

	//bi-directional many-to-one association to CardInsurance
	@OneToMany(mappedBy="clinicCenter")
	private List<CardInsurance> cardInsurances;

	//bi-directional many-to-one association to Diagnosi
	@OneToMany(mappedBy="clinicCenter")
	private List<Diagnosi> diagnosis;

	//bi-directional many-to-one association to DiagnList
	@OneToMany(mappedBy="clinicCenter")
	private List<DiagnList> diagnLists;

	//bi-directional many-to-one association to DiscretionSer
	@OneToMany(mappedBy="clinicCenter")
	private List<DiscretionSer> discretionSers;

	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="clinicCenter")
	private List<Doctor> doctors;

	//bi-directional many-to-one association to Dose
	@OneToMany(mappedBy="clinicCenter")
	private List<Dose> doses;

	//bi-directional many-to-one association to InsuranceCompany
	@OneToMany(mappedBy="clinicCenter")
	private List<InsuranceCompany> insuranceCompanies;

	//bi-directional many-to-one association to MedicalCheck
	@OneToMany(mappedBy="clinicCenter")
	private List<MedicalCheck> medicalChecks;

	//bi-directional many-to-one association to Medicine
	@OneToMany(mappedBy="clinicCenter")
	private List<Medicine> medicines;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="clinicCenter")
	private List<Patient> patients;

	//bi-directional many-to-one association to PatientVisit
	@OneToMany(mappedBy="clinicCenter")
	private List<PatientVisit> patientVisits;

	//bi-directional many-to-one association to PatSerivce
	@OneToMany(mappedBy="clinicCenter")
	private List<PatSerivce> patSerivces;

	//bi-directional many-to-one association to RequestMedChk
	@OneToMany(mappedBy="clinicCenter")
	private List<RequestMedChk> requestMedChks;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="clinicCenter")
	private List<User> users;

	public ClinicCenter() {
	}

	public long getCliId() {
		return this.cliId;
	}

	public void setCliId(long cliId) {
		this.cliId = cliId;
	}

	public BigDecimal getCliCode() {
		return this.cliCode;
	}

	public void setCliCode(BigDecimal cliCode) {
		this.cliCode = cliCode;
	}

	public String getCliLoc() {
		return this.cliLoc;
	}

	public void setCliLoc(String cliLoc) {
		this.cliLoc = cliLoc;
	}

	public String getCliName() {
		return this.cliName;
	}

	public void setCliName(String cliName) {
		this.cliName = cliName;
	}

	public String getCliNote() {
		return this.cliNote;
	}

	public void setCliNote(String cliNote) {
		this.cliNote = cliNote;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setClinicCenter(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setClinicCenter(null);

		return appointment;
	}

	public List<CardInsurance> getCardInsurances() {
		return this.cardInsurances;
	}

	public void setCardInsurances(List<CardInsurance> cardInsurances) {
		this.cardInsurances = cardInsurances;
	}

	public CardInsurance addCardInsurance(CardInsurance cardInsurance) {
		getCardInsurances().add(cardInsurance);
		cardInsurance.setClinicCenter(this);

		return cardInsurance;
	}

	public CardInsurance removeCardInsurance(CardInsurance cardInsurance) {
		getCardInsurances().remove(cardInsurance);
		cardInsurance.setClinicCenter(null);

		return cardInsurance;
	}

	public List<Diagnosi> getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(List<Diagnosi> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Diagnosi addDiagnosi(Diagnosi diagnosi) {
		getDiagnosis().add(diagnosi);
		diagnosi.setClinicCenter(this);

		return diagnosi;
	}

	public Diagnosi removeDiagnosi(Diagnosi diagnosi) {
		getDiagnosis().remove(diagnosi);
		diagnosi.setClinicCenter(null);

		return diagnosi;
	}

	public List<DiagnList> getDiagnLists() {
		return this.diagnLists;
	}

	public void setDiagnLists(List<DiagnList> diagnLists) {
		this.diagnLists = diagnLists;
	}

	public DiagnList addDiagnList(DiagnList diagnList) {
		getDiagnLists().add(diagnList);
		diagnList.setClinicCenter(this);

		return diagnList;
	}

	public DiagnList removeDiagnList(DiagnList diagnList) {
		getDiagnLists().remove(diagnList);
		diagnList.setClinicCenter(null);

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
		discretionSer.setClinicCenter(this);

		return discretionSer;
	}

	public DiscretionSer removeDiscretionSer(DiscretionSer discretionSer) {
		getDiscretionSers().remove(discretionSer);
		discretionSer.setClinicCenter(null);

		return discretionSer;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setClinicCenter(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setClinicCenter(null);

		return doctor;
	}

	public List<Dose> getDoses() {
		return this.doses;
	}

	public void setDoses(List<Dose> doses) {
		this.doses = doses;
	}

	public Dose addDos(Dose dos) {
		getDoses().add(dos);
		dos.setClinicCenter(this);

		return dos;
	}

	public Dose removeDos(Dose dos) {
		getDoses().remove(dos);
		dos.setClinicCenter(null);

		return dos;
	}

	public List<InsuranceCompany> getInsuranceCompanies() {
		return this.insuranceCompanies;
	}

	public void setInsuranceCompanies(List<InsuranceCompany> insuranceCompanies) {
		this.insuranceCompanies = insuranceCompanies;
	}

	public InsuranceCompany addInsuranceCompany(InsuranceCompany insuranceCompany) {
		getInsuranceCompanies().add(insuranceCompany);
		insuranceCompany.setClinicCenter(this);

		return insuranceCompany;
	}

	public InsuranceCompany removeInsuranceCompany(InsuranceCompany insuranceCompany) {
		getInsuranceCompanies().remove(insuranceCompany);
		insuranceCompany.setClinicCenter(null);

		return insuranceCompany;
	}

	public List<MedicalCheck> getMedicalChecks() {
		return this.medicalChecks;
	}

	public void setMedicalChecks(List<MedicalCheck> medicalChecks) {
		this.medicalChecks = medicalChecks;
	}

	public MedicalCheck addMedicalCheck(MedicalCheck medicalCheck) {
		getMedicalChecks().add(medicalCheck);
		medicalCheck.setClinicCenter(this);

		return medicalCheck;
	}

	public MedicalCheck removeMedicalCheck(MedicalCheck medicalCheck) {
		getMedicalChecks().remove(medicalCheck);
		medicalCheck.setClinicCenter(null);

		return medicalCheck;
	}

	public List<Medicine> getMedicines() {
		return this.medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public Medicine addMedicine(Medicine medicine) {
		getMedicines().add(medicine);
		medicine.setClinicCenter(this);

		return medicine;
	}

	public Medicine removeMedicine(Medicine medicine) {
		getMedicines().remove(medicine);
		medicine.setClinicCenter(null);

		return medicine;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient addPatient(Patient patient) {
		getPatients().add(patient);
		patient.setClinicCenter(this);

		return patient;
	}

	public Patient removePatient(Patient patient) {
		getPatients().remove(patient);
		patient.setClinicCenter(null);

		return patient;
	}

	public List<PatientVisit> getPatientVisits() {
		return this.patientVisits;
	}

	public void setPatientVisits(List<PatientVisit> patientVisits) {
		this.patientVisits = patientVisits;
	}

	public PatientVisit addPatientVisit(PatientVisit patientVisit) {
		getPatientVisits().add(patientVisit);
		patientVisit.setClinicCenter(this);

		return patientVisit;
	}

	public PatientVisit removePatientVisit(PatientVisit patientVisit) {
		getPatientVisits().remove(patientVisit);
		patientVisit.setClinicCenter(null);

		return patientVisit;
	}

	public List<PatSerivce> getPatSerivces() {
		return this.patSerivces;
	}

	public void setPatSerivces(List<PatSerivce> patSerivces) {
		this.patSerivces = patSerivces;
	}

	public PatSerivce addPatSerivce(PatSerivce patSerivce) {
		getPatSerivces().add(patSerivce);
		patSerivce.setClinicCenter(this);

		return patSerivce;
	}

	public PatSerivce removePatSerivce(PatSerivce patSerivce) {
		getPatSerivces().remove(patSerivce);
		patSerivce.setClinicCenter(null);

		return patSerivce;
	}

	public List<RequestMedChk> getRequestMedChks() {
		return this.requestMedChks;
	}

	public void setRequestMedChks(List<RequestMedChk> requestMedChks) {
		this.requestMedChks = requestMedChks;
	}

	public RequestMedChk addRequestMedChk(RequestMedChk requestMedChk) {
		getRequestMedChks().add(requestMedChk);
		requestMedChk.setClinicCenter(this);

		return requestMedChk;
	}

	public RequestMedChk removeRequestMedChk(RequestMedChk requestMedChk) {
		getRequestMedChks().remove(requestMedChk);
		requestMedChk.setClinicCenter(null);

		return requestMedChk;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setClinicCenter(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setClinicCenter(null);

		return user;
	}

}