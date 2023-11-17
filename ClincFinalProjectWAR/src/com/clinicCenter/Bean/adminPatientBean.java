package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.CardInsurance;
import model.entity.ClinicCenter;
import model.entity.Patient;

public class adminPatientBean {
	private Patient addPatients;
	private Patient updatesPatients;
	private Patient deletsPatients;
	private long patientsId;
	private Patient selectPatientsId;
	private String patFFName;
	private String patMMName;
	private String patLLName;
	private List<Patient> selectPatName;
	private List<Patient> selectAllPat;
	private List<Patient> selectPatEmail;
	private String patientsEmail;
	private String patientsPhoneNo;
	private List<Patient> selectPatPhoneNo;
	

	
	
	

	

	

	public String getPatientsPhoneNo() {
		return patientsPhoneNo;
	}

	public void setPatientsPhoneNo(String patientsPhoneNo) {
		this.patientsPhoneNo = patientsPhoneNo;
	}

	public List<Patient> getSelectPatPhoneNo() {
		return selectPatPhoneNo;
	}

	public void setSelectPatPhoneNo(List<Patient> selectPatPhoneNo) {
		this.selectPatPhoneNo = selectPatPhoneNo;
	}

	public String getPatientsEmail() {
		return patientsEmail;
	}

	public void setPatientsEmail(String patientsEmail) {
		this.patientsEmail = patientsEmail;
	}

	public List<Patient> getSelectPatEmail() {
		return selectPatEmail;
	}

	public void setSelectPatEmail(List<Patient> selectPatEmail) {
		this.selectPatEmail = selectPatEmail;
	}

	public List<Patient> getSelectAllPat() {
		return selectAllPat;
	}

	public void setSelectAllPat(List<Patient> selectAllPat) {
		this.selectAllPat = selectAllPat;
	}

	public String getPatFFName() {
		return patFFName;
	}

	public void setPatFFName(String patFFName) {
		this.patFFName = patFFName;
	}

	public String getPatMMName() {
		return patMMName;
	}

	public void setPatMMName(String patMMName) {
		this.patMMName = patMMName;
	}

	public String getPatLLName() {
		return patLLName;
	}

	public void setPatLLName(String patLLName) {
		this.patLLName = patLLName;
	}

	public List<Patient> getSelectPatName() {
		return selectPatName;
	}

	public void setSelectPatName(List<Patient> selectPatName) {
		this.selectPatName = selectPatName;
	}

	public long getPatientsId() {
		return patientsId;
	}

	public void setPatientsId(long patientsId) {
		this.patientsId = patientsId;
	}

	public Patient getSelectPatientsId() {
		return selectPatientsId;
	}

	public void setSelectPatientsId(Patient selectPatientsId) {
		this.selectPatientsId = selectPatientsId;
	}

	public Patient getDeletsPatients() {
		return deletsPatients;
	}

	public void setDeletsPatients(Patient deletsPatients) {
		this.deletsPatients = deletsPatients;
	}

	public Patient getUpdatesPatients() {
		return updatesPatients;
	}

	public void setUpdatesPatients(Patient updatesPatients) {
		this.updatesPatients = updatesPatients;
	}

	public Patient getAddPatients() {
		return addPatients;
	}

	public void setAddPatients(Patient addPatients) {
		this.addPatients = addPatients;
	}
	@PostConstruct
	public void init()
	{
		addPatients=new Patient();
		addPatients.setClinicCenter(new ClinicCenter());
		addPatients.setCardInsurance(new CardInsurance());
		chosenAllPatients();
	}
	
	public String insertPatient()
	{
		InitialContext ic;
		try {
			
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		hp.addPatient(addPatients);
		
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String editPatients(Patient data)
	{
		this.updatesPatients=data;
		return null;
	}
	public String updatePatients()
	{
		InitialContext ic;
		try {
			
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		hp.updatePatient(updatesPatients);
		
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String removePatients(Patient data)
	{
		this.updatesPatients=data;
		return null;
	}
	public String deletePatients()
	{
		InitialContext ic;
		try {
			
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
		hp.delPatient(deletsPatients);
		
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String chosenPatientId()
	{
		InitialContext ic;
		try {
			selectPatientsId=new Patient();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectPatientsId=hp.selectPatientById(patientsId);
		
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public String chosenPatientName()
	{
		InitialContext ic;
		try {
			selectPatName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectPatName=hp.selectByPatFirstName(patFFName, patMMName, patLLName);
		
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}


	public String chosenAllPatients()
	{
		InitialContext ic;
		try {
			selectAllPat=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllPat=hp.selectAllPatient();
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatientsEmail()
	{
		InitialContext ic;
		try {
			selectPatEmail=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectPatEmail=hp.selectPatientByEmail(patientsEmail);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatientsPhoneNo()
	{
		InitialContext ic;
		try {
			selectPatPhoneNo=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectPatPhoneNo=hp.selectPatientPhoneNumber(patientsPhoneNo);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	


}
