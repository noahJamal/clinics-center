package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.PatSerivce;

public class adminPatSerivceClass {
	private PatSerivce addSerivces;
	private PatSerivce updatesSerivces;
	private PatSerivce deletesSerivces;
	private long patSerivceId;
	private PatSerivce selectSerivceId;
	private String seriveName;
	private List<PatSerivce> selectSerName;
	private List<PatSerivce> selectAllSerivces;

	
	

	
	public List<PatSerivce> getSelectAllSerivces() {
		return selectAllSerivces;
	}

	public void setSelectAllSerivces(List<PatSerivce> selectAllSerivces) {
		this.selectAllSerivces = selectAllSerivces;
	}

	public String getSeriveName() {
		return seriveName;
	}

	public void setSeriveName(String seriveName) {
		this.seriveName = seriveName;
	}

	public List<PatSerivce> getSelectSerName() {
		return selectSerName;
	}

	public void setSelectSerName(List<PatSerivce> selectSerName) {
		this.selectSerName = selectSerName;
	}

	public long getPatSerivceId() {
		return patSerivceId;
	}

	public void setPatSerivceId(long patSerivceId) {
		this.patSerivceId = patSerivceId;
	}

	

	public PatSerivce getSelectSerivceId() {
		return selectSerivceId;
	}

	public void setSelectSerivceId(PatSerivce selectSerivceId) {
		this.selectSerivceId = selectSerivceId;
	}

	public PatSerivce getUpdatesSerivces() {
		return updatesSerivces;
	}

	public void setUpdatesSerivces(PatSerivce updatesSerivces) {
		this.updatesSerivces = updatesSerivces;
	}

	public PatSerivce getDeletesSerivces() {
		return deletesSerivces;
	}

	public void setDeletesSerivces(PatSerivce deletesSerivces) {
		this.deletesSerivces = deletesSerivces;
	}

	public PatSerivce getAddSerivces() {
		return addSerivces;
	}

	public void setAddSerivces(PatSerivce addSerivces) {
		this.addSerivces = addSerivces;
	}
	
	@PostConstruct
	public void init()
	{
		addSerivces=new PatSerivce();
		addSerivces.setClinicCenter(new ClinicCenter());
	}
	
	public String insertPatSerivces()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addPatSerivce(addSerivces);
			
		} catch (NamingException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
	
	public String editPatSerivce(PatSerivce data)
	{  
		this.updatesSerivces=data;
		return null;}
	
	public String updatePatSerivces()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updatePatSerivce(updatesSerivces);
			
		} catch (NamingException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
	
	public String removePatSerivce(PatSerivce data)
	{  
		this.deletesSerivces=data;
		return null;}
	
	public String deletePatSerivces()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delPatSerivce(deletesSerivces);
			
		} catch (NamingException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatSerivcesId()
	{
		InitialContext ic;
		try {
			selectSerivceId=new PatSerivce();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectSerivceId=hp.selectPatSerivceById(patSerivceId);
		} catch (NamingException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
	
	public String chosenPatSerivcesName()
	{
		InitialContext ic;
		try {
			selectSerName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectSerName=hp.selectByPatSerivceName(seriveName);
		} catch (NamingException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
	
	public String chosenAllPatSerivces()
	{
		InitialContext ic;
		try {
			selectAllSerivces=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllSerivces=hp.selectAllPatSerivce();
		} catch (NamingException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return null;
	}
	
	
	
	

}
