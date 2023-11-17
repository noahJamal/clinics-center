package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.Appointment;
import model.entity.ClinicCenter;
import model.entity.Doctor;
import model.entity.Patient;

public class adminAppointmentClass {
	private Appointment addAppoin;
    private Appointment updateAppoin;
    private Appointment deletesAppoin;
    private long appoinId;
    private Appointment selectAppoinId;
    private List<Appointment> selectAllAppoin;
    private List<Appointment> selectAppoinName;
    private String appoinName;
    private String appoinDocName;
    private List<Appointment> selectappoinDocName;
    private Date appoinDate;
    private List<Appointment> selectappoinDate;
    private String patFFName;
    private String patMMName;
    private String patLLName;
    private List<Appointment> selectappoinPatName;
    private String appoinCliName;
    private List<Appointment> selectappoinClinicName;


    
	
	
	public String getAppoinCliName() {
		return appoinCliName;
	}

	public void setAppoinCliName(String appoinCliName) {
		this.appoinCliName = appoinCliName;
	}

	public List<Appointment> getSelectappoinClinicName() {
		return selectappoinClinicName;
	}

	public void setSelectappoinClinicName(List<Appointment> selectappoinClinicName) {
		this.selectappoinClinicName = selectappoinClinicName;
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

	public List<Appointment> getSelectappoinPatName() {
		return selectappoinPatName;
	}

	public void setSelectappoinPatName(List<Appointment> selectappoinPatName) {
		this.selectappoinPatName = selectappoinPatName;
	}

	public String getAppoinDocName() {
		return appoinDocName;
	}

	public void setAppoinDocName(String appoinDocName) {
		this.appoinDocName = appoinDocName;
	}

	public List<Appointment> getSelectappoinDocName() {
		return selectappoinDocName;
	}

	public void setSelectappoinDocName(List<Appointment> selectappoinDocName) {
		this.selectappoinDocName = selectappoinDocName;
	}

	public Date getAppoinDate() {
		return appoinDate;
	}

	public void setAppoinDate(Date appoinDate) {
		this.appoinDate = appoinDate;
	}

	public List<Appointment> getSelectappoinDate() {
		return selectappoinDate;
	}

	public void setSelectappoinDate(List<Appointment> selectappoinDate) {
		this.selectappoinDate = selectappoinDate;
	}

	public String getAppoinName() {
		return appoinName;
	}

	public void setAppoinName(String appoinName) {
		this.appoinName = appoinName;
	}

	public List<Appointment> getSelectAppoinName() {
		return selectAppoinName;
	}

	public void setSelectAppoinName(List<Appointment> selectAppoinName) {
		this.selectAppoinName = selectAppoinName;
	}

	public List<Appointment> getSelectAllAppoin() {
		return selectAllAppoin;
	}

	public void setSelectAllAppoin(List<Appointment> selectAllAppoin) {
		this.selectAllAppoin = selectAllAppoin;
	}

	public long getAppoinId() {
		return appoinId;
	}

	public void setAppoinId(long appoinId) {
		this.appoinId = appoinId;
	}

	public Appointment getSelectAppoinId() {
		return selectAppoinId;
	}

	public void setSelectAppoinId(Appointment selectAppoinId) {
		this.selectAppoinId = selectAppoinId;
	}

	public Appointment getDeletesAppoin() {
		return deletesAppoin;
	}

	public void setDeletesAppoin(Appointment deletesAppoin) {
		this.deletesAppoin = deletesAppoin;
	}

	public Appointment getUpdateAppoin() {
		return updateAppoin;
	}

	public void setUpdateAppoin(Appointment updateAppoin) {
		this.updateAppoin = updateAppoin;
	}

	public Appointment getAddAppoin() {
		return addAppoin;
	}

	public void setAddAppoin(Appointment addAppoin) {
		this.addAppoin = addAppoin;
	}
	
	@PostConstruct
	public void init()
	{
		addAppoin=new Appointment();
		addAppoin.setClinicCenter(new ClinicCenter());
		addAppoin.setDoctor(new Doctor());
		addAppoin.setPatient(new Patient());
		chosenAllAppointment();
	}
	
	public String insertAppointment()
	{
		InitialContext ic;
		
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addAppointment(addAppoin);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	public String editAppointment(Appointment data)
	{
		this.updateAppoin=data;
		return null;
	}
	
	public String updateAppointment()
	{
         InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateAppointment(updateAppoin);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String removeAppointment(Appointment data)
	{
		this.deletesAppoin=data;
		return null;
	}
	

	public String deleteAppointment()
	{
         InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delAppointment(deletesAppoin);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String chosenAppointmentId()
	{
	    InitialContext ic;
			try {
				selectAppoinId=new Appointment();
				ic=new InitialContext();
				AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
				selectAppoinId=hp.selectAppointmentById(appoinId);
			} catch (NamingException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		
	}
	
	public String chosenAllAppointment()
	{
		InitialContext ic;
		try {
			selectAllAppoin=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllAppoin=hp.selectAllAppointment();
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	
	}
	
	public String chosenAppointmentName()
	{
		InitialContext ic;
		try {
			selectAppoinName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAppoinName=hp.selectAppointmentByName(appoinName);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	
	}
	
	public String chosenAppointmentDocName()
	{
		InitialContext ic;
		try {
			selectappoinDocName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectappoinDocName=hp.selectAppointmentByDoctor(appoinDocName);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	
	}
	
	public String chosenAppointmentDate()
	{
		InitialContext ic;
		try {
			selectappoinDate=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectappoinDate=hp.selectAppointmentByDate(appoinDate);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	
	}	
	
	public String chosenAppointmentPatientName()
	{
		InitialContext ic;
		try {
			selectappoinPatName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectappoinPatName=hp.selectAppointmentByPatientName(patFFName, patMMName, patLLName);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	
	}
	
	

	public String chosenAppointmentClinicName()
	{
		InitialContext ic;
		try {
			selectappoinClinicName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectappoinClinicName=hp.selectAppointmentByClinicName(appoinCliName);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	
	}
	
}
