package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the INSURANCE_COMPANY database table.
 * 
 */
@Entity
@Table(name="INSURANCE_COMPANY")
@NamedQuery(name="InsuranceCompany.findAll", query="SELECT i FROM InsuranceCompany i")
public class InsuranceCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMP_ID")
	private long compId;

	@Column(name="COMP_ADDRESS")
	private String compAddress;

	@Column(name="COMP_CODE")
	private BigDecimal compCode;

	@Column(name="COMP_NAME")
	private String compName;

	@Column(name="COMP_PHONE")
	private String compPhone;

	@Column(name="COMP_STATE")
	private String compState;

	//bi-directional many-to-one association to CardInsurance
	@OneToMany(mappedBy="insuranceCompany")
	private List<CardInsurance> cardInsurances;

	//bi-directional many-to-one association to ClinicCenter
	@ManyToOne
	@JoinColumn(name="CLI_ID")
	private ClinicCenter clinicCenter;

	public InsuranceCompany() {
	}

	public long getCompId() {
		return this.compId;
	}

	public void setCompId(long compId) {
		this.compId = compId;
	}

	public String getCompAddress() {
		return this.compAddress;
	}

	public void setCompAddress(String compAddress) {
		this.compAddress = compAddress;
	}

	public BigDecimal getCompCode() {
		return this.compCode;
	}

	public void setCompCode(BigDecimal compCode) {
		this.compCode = compCode;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompPhone() {
		return this.compPhone;
	}

	public void setCompPhone(String compPhone) {
		this.compPhone = compPhone;
	}

	public String getCompState() {
		return this.compState;
	}

	public void setCompState(String compState) {
		this.compState = compState;
	}

	public List<CardInsurance> getCardInsurances() {
		return this.cardInsurances;
	}

	public void setCardInsurances(List<CardInsurance> cardInsurances) {
		this.cardInsurances = cardInsurances;
	}

	public CardInsurance addCardInsurance(CardInsurance cardInsurance) {
		getCardInsurances().add(cardInsurance);
		cardInsurance.setInsuranceCompany(this);

		return cardInsurance;
	}

	public CardInsurance removeCardInsurance(CardInsurance cardInsurance) {
		getCardInsurances().remove(cardInsurance);
		cardInsurance.setInsuranceCompany(null);

		return cardInsurance;
	}

	public ClinicCenter getClinicCenter() {
		return this.clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}

}