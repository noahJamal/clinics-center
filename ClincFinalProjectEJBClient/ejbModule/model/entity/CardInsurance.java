package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CARD_INSURANCE database table.
 * 
 */
@Entity
@Table(name="CARD_INSURANCE")
@NamedQuery(name="CardInsurance.findAll", query="SELECT c FROM CardInsurance c")
public class CardInsurance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CARD_ID")
	private long cardId;

	@Column(name="CARD_CODE")
	private BigDecimal cardCode;

	@Temporal(TemporalType.DATE)
	@Column(name="CARD_DATE")
	private Date cardDate;

	@Column(name="CARD_NAME")
	private String cardName;

	@Column(name="CARD_NOTE")
	private String cardNote;

	@Column(name="CARD_PER")
	private String cardPer;

	@Column(name="CARD_STATE")
	private String cardState;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	//bi-directional many-to-one association to InsuranceCompany
	@ManyToOne
	@JoinColumn(name="COMP_ID")
	private InsuranceCompany insuranceCompany;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="cardInsurance")
	private List<Patient> patients;

	public CardInsurance() {
	}

	public long getCardId() {
		return this.cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public BigDecimal getCardCode() {
		return this.cardCode;
	}

	public void setCardCode(BigDecimal cardCode) {
		this.cardCode = cardCode;
	}

	public Date getCardDate() {
		return this.cardDate;
	}

	public void setCardDate(Date cardDate) {
		this.cardDate = cardDate;
	}

	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNote() {
		return this.cardNote;
	}

	public void setCardNote(String cardNote) {
		this.cardNote = cardNote;
	}

	public String getCardPer() {
		return this.cardPer;
	}

	public void setCardPer(String cardPer) {
		this.cardPer = cardPer;
	}

	public String getCardState() {
		return this.cardState;
	}

	public void setCardState(String cardState) {
		this.cardState = cardState;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

	public InsuranceCompany getInsuranceCompany() {
		return this.insuranceCompany;
	}

	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient addPatient(Patient patient) {
		getPatients().add(patient);
		patient.setCardInsurance(this);

		return patient;
	}

	public Patient removePatient(Patient patient) {
		getPatients().remove(patient);
		patient.setCardInsurance(null);

		return patient;
	}

}