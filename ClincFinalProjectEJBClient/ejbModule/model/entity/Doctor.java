package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DOCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DOC_ID")
	private long docId;

	@Column(name="DCO_NAME")
	private String dcoName;

	@Column(name="DOC_ADDRESS")
	private String docAddress;

	@Temporal(TemporalType.DATE)
	@Column(name="DOC_BD")
	private Date docBd;

	@Column(name="DOC_CODE")
	private BigDecimal docCode;

	@Column(name="DOC_EXP")
	private String docExp;

	@Column(name="DOC_MAJOR")
	private String docMajor;

	@Column(name="DOC_PHONE")
	private String docPhone;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to PatientVisit
	@OneToMany(mappedBy="doctor")
	private List<PatientVisit> patientVisits;

	
//////////////////
@OneToMany(mappedBy="doctor")
private List<Appointment>  appointment;

///////////////////////

	public Doctor() {
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	public long getDocId() {
		return this.docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public String getDcoName() {
		return this.dcoName;
	}

	public void setDcoName(String dcoName) {
		this.dcoName = dcoName;
	}

	public String getDocAddress() {
		return this.docAddress;
	}

	public void setDocAddress(String docAddress) {
		this.docAddress = docAddress;
	}

	public Date getDocBd() {
		return this.docBd;
	}

	public void setDocBd(Date docBd) {
		this.docBd = docBd;
	}

	public BigDecimal getDocCode() {
		return this.docCode;
	}

	public void setDocCode(BigDecimal docCode) {
		this.docCode = docCode;
	}

	public String getDocExp() {
		return this.docExp;
	}

	public void setDocExp(String docExp) {
		this.docExp = docExp;
	}

	public String getDocMajor() {
		return this.docMajor;
	}

	public void setDocMajor(String docMajor) {
		this.docMajor = docMajor;
	}

	public String getDocPhone() {
		return this.docPhone;
	}

	public void setDocPhone(String docPhone) {
		this.docPhone = docPhone;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PatientVisit> getPatientVisits() {
		return this.patientVisits;
	}

	public void setPatientVisits(List<PatientVisit> patientVisits) {
		this.patientVisits = patientVisits;
	}

	public PatientVisit addPatientVisit(PatientVisit patientVisit) {
		getPatientVisits().add(patientVisit);
		patientVisit.setDoctor(this);

		return patientVisit;
	}

	public PatientVisit removePatientVisit(PatientVisit patientVisit) {
		getPatientVisits().remove(patientVisit);
		patientVisit.setDoctor(null);

		return patientVisit;
	}

}