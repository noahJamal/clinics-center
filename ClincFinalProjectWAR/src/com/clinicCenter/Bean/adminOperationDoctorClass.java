package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.constraints.Future;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.Doctor;
import model.entity.User;

public class adminOperationDoctorClass {
	
	private Doctor addNewDoctor;
	private Doctor updatesDoctors;
	private Doctor deletesDoctor;
	private Doctor selectDoctorId;
	private Long doctorId ;
	private String DoctorsName;
	private List<Doctor> docNameInfo;
	private List<Doctor> allDocInfo;
	@Future
	private Date minDate;
	
	
	
	
	
	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public List<Doctor> getDocNameInfo() {
		return docNameInfo;
	}

	public void setDocNameInfo(List<Doctor> docNameInfo) {
		this.docNameInfo = docNameInfo;
	}

	public List<Doctor> getAllDocInfo() {
		return allDocInfo;
	}

	public void setAllDocInfo(List<Doctor> allDocInfo) {
		this.allDocInfo = allDocInfo;
	}

	public String getDoctorsName() {
		return DoctorsName;
	}

	public void setDoctorsName(String doctorsName) {
		DoctorsName = doctorsName;
	}

	
	public Doctor getSelectDoctorId() {
		return selectDoctorId;
	}

	public void setSelectDoctorId(Doctor selectDoctorId) {
		this.selectDoctorId = selectDoctorId;
	}

	public Doctor getDeletesDoctor() {
		return deletesDoctor;
	}

	public void setDeletesDoctor(Doctor deletesDoctor) {
		this.deletesDoctor = deletesDoctor;
	}

	public Doctor getUpdatesDoctors() {
		return updatesDoctors;
	}

	public void setUpdatesDoctors(Doctor updatesDoctors) {
		this.updatesDoctors = updatesDoctors;
	}

	public Doctor getAddNewDoctor() {
		return addNewDoctor;
	}

	public void setAddNewDoctor(Doctor addNewDoctor) {
		this.addNewDoctor = addNewDoctor;
	}
	
	@PostConstruct
	public void init()
	{
		addNewDoctor=new Doctor();
		addNewDoctor.setClinicCenter(new ClinicCenter());
		addNewDoctor.setUser(new User());
		chosenAllDoctor();
		

	}
	public String insertDoctor()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp;
			hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addDoctor(addNewDoctor);
			chosenAllDoctor();
			return null;
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String editDocInfo(Doctor data)
	{  
		this.updatesDoctors=data;
		return null;
	}
	
	public String updateDocotr()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateDoctor(updatesDoctors);
			diplayMessage("Doctor "+deletesDoctor.getDcoName()+" has been adjustment.");
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	public String removeDoctor(Doctor data)
	{
		this.deletesDoctor=data;
		return "adminDeleteDoc.xhtml";
		
	}
	public String deleteDocotr()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.removeDoctor(deletesDoctor);
			chosenAllDoctor();
			diplayMessage(deletesDoctor.getDcoName()+" has been deleted.");
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String chosenDoctorID()
	{
		InitialContext ic;
		try {
			//selectDoctorId=new Doctor();
			allDocInfo=new ArrayList<> ();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			if(!hp.SelectDoctorById(doctorId).contains(null))
			{
				allDocInfo=hp.SelectDoctorById(doctorId);
				diplayMessage("Doctor Name : " + doctorId+"  is exists");

			}
			else
			{
				errorDisplayMessage("Doctor Name : "+doctorId +"  doesn't exists");

			}
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String chosenDoctorName()
	{
		InitialContext ic;
		try {
			allDocInfo=new ArrayList<> ();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			if(!hp.selectDoctorByName(DoctorsName).isEmpty())
			{
				allDocInfo=hp.selectDoctorByName(DoctorsName);
				diplayMessage("Doctor Name : " + DoctorsName+"  is exists");
			}
			else
			{
				errorDisplayMessage("Doctor Name : "+DoctorsName +"  doesn't exists");
			}
			;
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String chosenAllDoctor()
	{
		InitialContext ic;
		try {
			allDocInfo=new ArrayList<> ();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			allDocInfo=hp.selectAllDoctor();
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public List<String> chosenDoctorNamebyAutocompleate(String doctorNmaes)
	{
		InitialContext ic;
		List<String> names; 
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			names=new ArrayList<>();
			names=hp.searchDoctorAutoName(doctorNmaes);
			return names;
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	public void diplayMessage(String message)
	{
		FacesContext fct=FacesContext.getCurrentInstance();
		fct.addMessage(null, new FacesMessage(message));
				
	}
	public void errorDisplayMessage(String erroMessage)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error:" ,erroMessage));
	}
	
	public String goToDoctorPage() {
	    // ...
	    return "doctorClinic.xhtml?faces-redirect=true";
	}


}
