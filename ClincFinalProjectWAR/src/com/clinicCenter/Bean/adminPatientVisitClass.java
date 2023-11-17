package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.Doctor;
import model.entity.Patient;
import model.entity.PatientVisit;

public class adminPatientVisitClass {
	private PatientVisit addVisit;
	private PatientVisit updatesVisit;
	private PatientVisit deletesVisit;
	private long patVisitsId;
	private PatientVisit selectPatVisitsId;
	private List<PatientVisit> selectAllPatVisit;
	private String patVisitName;
	private List<PatientVisit> selectVisitName;
	private String VisitDocName;
	private List<PatientVisit> selectVisitDocName;
	private String VisitCliName;
	private List<PatientVisit> selectVisitCliName;
	private String VisitPatFFName;
	private String VisitPatMMName;
	private String VisitPatLLName;
	private List<PatientVisit> selectVisitPatName;
	private Date visitPatDate;
	private List<PatientVisit> selectVisitPatDate;
	
	
	
	
	
	
	
	


	
	public Date getVisitPatDate() {
		return visitPatDate;
	}

	public void setVisitPatDate(Date visitPatDate) {
		this.visitPatDate = visitPatDate;
	}

	public List<PatientVisit> getSelectVisitPatDate() {
		return selectVisitPatDate;
	}

	public void setSelectVisitPatDate(List<PatientVisit> selectVisitPatDate) {
		this.selectVisitPatDate = selectVisitPatDate;
	}

	public String getVisitPatFFName() {
		return VisitPatFFName;
	}

	public void setVisitPatFFName(String visitPatFFName) {
		VisitPatFFName = visitPatFFName;
	}

	public String getVisitPatMMName() {
		return VisitPatMMName;
	}

	public void setVisitPatMMName(String visitPatMMName) {
		VisitPatMMName = visitPatMMName;
	}

	public String getVisitPatLLName() {
		return VisitPatLLName;
	}

	public void setVisitPatLLName(String visitPatLLName) {
		VisitPatLLName = visitPatLLName;
	}

	public List<PatientVisit> getSelectVisitPatName() {
		return selectVisitPatName;
	}

	public void setSelectVisitPatName(List<PatientVisit> selectVisitPatName) {
		this.selectVisitPatName = selectVisitPatName;
	}

	public String getVisitCliName() {
		return VisitCliName;
	}

	public void setVisitCliName(String visitCliName) {
		VisitCliName = visitCliName;
	}

	public List<PatientVisit> getSelectVisitCliName() {
		return selectVisitCliName;
	}

	public void setSelectVisitCliName(List<PatientVisit> selectVisitCliName) {
		this.selectVisitCliName = selectVisitCliName;
	}

	public String getVisitDocName() {
		return VisitDocName;
	}

	public void setVisitDocName(String visitDocName) {
		VisitDocName = visitDocName;
	}

	public List<PatientVisit> getSelectVisitDocName() {
		return selectVisitDocName;
	}

	public void setSelectVisitDocName(List<PatientVisit> selectVisitDocName) {
		this.selectVisitDocName = selectVisitDocName;
	}

	public String getPatVisitName() {
		return patVisitName;
	}

	public void setPatVisitName(String patVisitName) {
		this.patVisitName = patVisitName;
	}

	public List<PatientVisit> getSelectVisitName() {
		return selectVisitName;
	}

	public void setSelectVisitName(List<PatientVisit> selectVisitName) {
		this.selectVisitName = selectVisitName;
	}

	public List<PatientVisit> getSelectAllPatVisit() {
		return selectAllPatVisit;
	}

	public void setSelectAllPatVisit(List<PatientVisit> selectAllPatVisit) {
		this.selectAllPatVisit = selectAllPatVisit;
	}

	public long getPatVisitsId() {
		return patVisitsId;
	}

	public void setPatVisitsId(long patVisitsId) {
		this.patVisitsId = patVisitsId;
	}

	public PatientVisit getSelectPatVisitsId() {
		return selectPatVisitsId;
	}

	public void setSelectPatVisitsId(PatientVisit selectPatVisitsId) {
		this.selectPatVisitsId = selectPatVisitsId;
	}

	public PatientVisit getUpdatesVisit() {
		return updatesVisit;
	}

	public void setUpdatesVisit(PatientVisit updatesVisit) {
		this.updatesVisit = updatesVisit;
	}

	public PatientVisit getDeletesVisit() {
		return deletesVisit;
	}

	public void setDeletesVisit(PatientVisit deletesVisit) {
		this.deletesVisit = deletesVisit;
	}

	public PatientVisit getAddVisit() {
		return addVisit;
	}

	public void setAddVisit(PatientVisit addVisit) {
		this.addVisit = addVisit;
	}
	
	@PostConstruct
	public void init()
	{
		addVisit=new PatientVisit();
		addVisit.setClinicCenter(new ClinicCenter());
		addVisit.setDoctor(new Doctor());
		addVisit.setPatient(new Patient());
		chosenAllPatientVisit();
	}
	
	public String insertPatientVisit()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addPatientVisit(addVisit);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String editPatientVisit(PatientVisit data)
	{
		this.updatesVisit=data;
		return null;
	}

	public String updatePatientVisit()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updatePatientVisit(updatesVisit);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String removePatientVisit(PatientVisit data)
	{
		this.deletesVisit=data;
		return null;
	}
	
	public String deletePatientVisit()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delPatientVisit(deletesVisit);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatientVisitId()
	{
		InitialContext ic;
		try {
			selectPatVisitsId=new PatientVisit();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectPatVisitsId=hp.selectPatientVisitById(patVisitsId);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenAllPatientVisit()
	{
		InitialContext ic;
		try {
			selectAllPatVisit=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllPatVisit=hp.selectAllPatientVisit();
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatientVisitName()
	{
		InitialContext ic;
		try {
			selectVisitName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectVisitName=hp.selectPatientVisitByName(patVisitName);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	

	public String chosenPatientVisitDoctorName()
	{
		InitialContext ic;
		try {
			selectVisitDocName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectVisitDocName=hp.selectPatientVisitByDoctor(VisitDocName);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatientVisitClinicName()
	{
		InitialContext ic;
		try {
			selectVisitCliName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectVisitCliName=hp.selectPatientVisitByClinic(VisitCliName);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatientVisitPatientName()
	{
		InitialContext ic;
		try {
			selectVisitPatName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectVisitPatName=hp.selectPatientVisitByPatientName(VisitPatFFName, VisitPatMMName, VisitPatLLName);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatientVisitPatientDate()
	{
		InitialContext ic;
		try {
			selectVisitPatDate=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectVisitPatDate=hp.selectPatientVisitByDate(visitPatDate);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
