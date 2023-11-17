package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.MedicalCheck;
import model.entity.Patient;
import model.entity.PatientVisit;
import model.entity.RequestMedChk;

public class adminRequestMedChkClass {

	private RequestMedChk addreqMedChk;
	private RequestMedChk updatesreqMedChk;
	private RequestMedChk deletesreqMedChk;
	private RequestMedChk selectreqMedChkId;
	private long reqMedCheckId;
	private List<RequestMedChk> selectAllreqMedChk;
	

	
	

	public RequestMedChk getSelectreqMedChkId() {
		return selectreqMedChkId;
	}

	public void setSelectreqMedChkId(RequestMedChk selectreqMedChkId) {
		this.selectreqMedChkId = selectreqMedChkId;
	}

	public List<RequestMedChk> getSelectAllreqMedChk() {
		return selectAllreqMedChk;
	}

	public void setSelectAllreqMedChk(List<RequestMedChk> selectAllreqMedChk) {
		this.selectAllreqMedChk = selectAllreqMedChk;
	}

	public long getReqMedCheckId() {
		return reqMedCheckId;
	}

	public void setReqMedCheckId(long reqMedCheckId) {
		this.reqMedCheckId = reqMedCheckId;
	}

	public RequestMedChk getUpdatesreqMedChk() {
		return updatesreqMedChk;
	}

	public void setUpdatesreqMedChk(RequestMedChk updatesreqMedChk) {
		this.updatesreqMedChk = updatesreqMedChk;
	}

	public RequestMedChk getDeletesreqMedChk() {
		return deletesreqMedChk;
	}

	public void setDeletesreqMedChk(RequestMedChk deletesreqMedChk) {
		this.deletesreqMedChk = deletesreqMedChk;
	}

	public RequestMedChk getAddreqMedChk() {
		return addreqMedChk;
	}

	public void setAddreqMedChk(RequestMedChk addreqMedChk) {
		this.addreqMedChk = addreqMedChk;
	}
	
	@PostConstruct
	public void init()
	{
		addreqMedChk=new RequestMedChk();
		addreqMedChk.setClinicCenter(new ClinicCenter());
		addreqMedChk.setPatient(new Patient());
		addreqMedChk.setMedicalCheck(new MedicalCheck());
		addreqMedChk.setPatientVisit(new PatientVisit());
		chosenAllRequestMedCheck();
	}
	
	public String insertRequestMedChk()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addRequestMedChk(addreqMedChk);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String editRequestMedChk(RequestMedChk data)
	{
		this.updatesreqMedChk=data;
		return null;
	}
	
	public String updateRequestMedCheck()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateRequestMedChk(updatesreqMedChk);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String removeRequestMedChk(RequestMedChk data)
	{
		this.deletesreqMedChk=data;
		return null;
	}
	
	public String deleteRequestMedCheck()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delRequestMedChk(deletesreqMedChk);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String chosenRequestMedCheckId()
	{
		InitialContext ic;
		try {
			selectreqMedChkId=new RequestMedChk();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectreqMedChkId=hp.selectRequestMedChkById(reqMedCheckId);
		
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenAllRequestMedCheck()
	{
		InitialContext ic;
		try {
			selectAllreqMedChk=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllreqMedChk=hp.selectAllRequestMedChk();
		
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
