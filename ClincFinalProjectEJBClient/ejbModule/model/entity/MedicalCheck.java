package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the MEDICAL_CHECKS database table.
 * 
 */
@Entity
@Table(name="MEDICAL_CHECKS")
@NamedQuery(name="MedicalCheck.findAll", query="SELECT m FROM MedicalCheck m")
public class MedicalCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MEDCHK_ID")
	private long medchkId;

	@Column(name="MEDCHK_CODE")
	private BigDecimal medchkCode;

	@Column(name="MEDCHK_NAME")
	private String medchkName;

	@Column(name="MEDCHK_NOTE")
	private String medchkNote;

	@Column(name="MEDCHK_PRICE")
	private BigDecimal medchkPrice;

	@Column(name="MEDCHK_TYPE")
	private String medchkType;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to RequestMedChk
	@OneToMany(mappedBy="medicalCheck")
	private List<RequestMedChk> requestMedChks;

	public MedicalCheck() {
	}

	public long getMedchkId() {
		return this.medchkId;
	}

	public void setMedchkId(long medchkId) {
		this.medchkId = medchkId;
	}

	public BigDecimal getMedchkCode() {
		return this.medchkCode;
	}

	public void setMedchkCode(BigDecimal medchkCode) {
		this.medchkCode = medchkCode;
	}

	public String getMedchkName() {
		return this.medchkName;
	}

	public void setMedchkName(String medchkName) {
		this.medchkName = medchkName;
	}

	public String getMedchkNote() {
		return this.medchkNote;
	}

	public void setMedchkNote(String medchkNote) {
		this.medchkNote = medchkNote;
	}

	public BigDecimal getMedchkPrice() {
		return this.medchkPrice;
	}

	public void setMedchkPrice(BigDecimal medchkPrice) {
		this.medchkPrice = medchkPrice;
	}

	public String getMedchkType() {
		return this.medchkType;
	}

	public void setMedchkType(String medchkType) {
		this.medchkType = medchkType;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public List<RequestMedChk> getRequestMedChks() {
		return this.requestMedChks;
	}

	public void setRequestMedChks(List<RequestMedChk> requestMedChks) {
		this.requestMedChks = requestMedChks;
	}

	public RequestMedChk addRequestMedChk(RequestMedChk requestMedChk) {
		getRequestMedChks().add(requestMedChk);
		requestMedChk.setMedicalCheck(this);

		return requestMedChk;
	}

	public RequestMedChk removeRequestMedChk(RequestMedChk requestMedChk) {
		getRequestMedChks().remove(requestMedChk);
		requestMedChk.setMedicalCheck(null);

		return requestMedChk;
	}

}