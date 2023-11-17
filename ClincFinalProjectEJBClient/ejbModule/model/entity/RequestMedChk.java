package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the REQUEST_MED_CHK database table.
 * 
 */
@Entity
@Table(name="REQUEST_MED_CHK")
@NamedQuery(name="RequestMedChk.findAll", query="SELECT r FROM RequestMedChk r")
public class RequestMedChk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REQ_ID")
	private long reqId;

	@Column(name="REQ_CODE")
	private BigDecimal reqCode;

	@Temporal(TemporalType.DATE)
	@Column(name="REQ_DATE")
	private Date reqDate;

	@Column(name="REQ_NAME")
	private String reqName;

	@Column(name="REQ_NOTE")
	private String reqNote;

	@Column(name="REQ_RESULT")
	private String reqResult;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to MedicalCheck
	@ManyToOne
	@JoinColumn(name="MEDCHK_ID")
	private MedicalCheck medicalCheck;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PAT_ID")
	private Patient patient;

	//bi-directional many-to-one association to PatientVisit
	@ManyToOne
	@JoinColumn(name="VIS_ID")
	private PatientVisit patientVisit;

	public RequestMedChk() {
	}

	public long getReqId() {
		return this.reqId;
	}

	public void setReqId(long reqId) {
		this.reqId = reqId;
	}

	public BigDecimal getReqCode() {
		return this.reqCode;
	}

	public void setReqCode(BigDecimal reqCode) {
		this.reqCode = reqCode;
	}

	public Date getReqDate() {
		return this.reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getReqName() {
		return this.reqName;
	}

	public void setReqName(String reqName) {
		this.reqName = reqName;
	}

	public String getReqNote() {
		return this.reqNote;
	}

	public void setReqNote(String reqNote) {
		this.reqNote = reqNote;
	}

	public String getReqResult() {
		return this.reqResult;
	}

	public void setReqResult(String reqResult) {
		this.reqResult = reqResult;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public MedicalCheck getMedicalCheck() {
		return this.medicalCheck;
	}

	public void setMedicalCheck(MedicalCheck medicalCheck) {
		this.medicalCheck = medicalCheck;
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