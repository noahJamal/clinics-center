package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.DiscretionSer;
import model.entity.PatSerivce;
import model.entity.Patient;
import model.entity.PatientVisit;

public class adminDiscriptionSerClass {

	private DiscretionSer addDiscSer;
	private DiscretionSer updatesDiscSer;
	private DiscretionSer deletesDiscSer;
	private DiscretionSer selectDiscSerId;
    private long  DiscSerId;
    private List<DiscretionSer> selectAllDiscSer;
    
    

	public List<DiscretionSer> getSelectAllDiscSer() {
		return selectAllDiscSer;
	}

	public void setSelectAllDiscSer(List<DiscretionSer> selectAllDiscSer) {
		this.selectAllDiscSer = selectAllDiscSer;
	}

	public DiscretionSer getSelectDiscSerId() {
		return selectDiscSerId;
	}

	public void setSelectDiscSerId(DiscretionSer selectDiscSerId) {
		this.selectDiscSerId = selectDiscSerId;
	}

	public long getDiscSerId() {
		return DiscSerId;
	}

	public void setDiscSerId(long discSerId) {
		DiscSerId = discSerId;
	}

	public DiscretionSer getUpdatesDiscSer() {
		return updatesDiscSer;
	}

	public void setUpdatesDiscSer(DiscretionSer updatesDiscSer) {
		this.updatesDiscSer = updatesDiscSer;
	}

	public DiscretionSer getDeletesDiscSer() {
		return deletesDiscSer;
	}

	public void setDeletesDiscSer(DiscretionSer deletesDiscSer) {
		this.deletesDiscSer = deletesDiscSer;
	}

	public DiscretionSer getAddDiscSer() {
		return addDiscSer;
	}

	public void setAddDiscSer(DiscretionSer addDiscSer) {
		this.addDiscSer = addDiscSer;
	}
	
	@PostConstruct
	public void init()
	{
		addDiscSer=new DiscretionSer();
		addDiscSer.setClinicCenter(new ClinicCenter());
		addDiscSer.setPatient(new Patient());
		addDiscSer.setPatientVisit(new PatientVisit());
		addDiscSer.setPatSerivce(new PatSerivce());
	}
	
	public String insertDiscriptionSer()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addDiscretionSer(addDiscSer);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String editDiscriptionSer(DiscretionSer data)
	{
		this.updatesDiscSer=data;
		return null;
	}

	
	public String updateDiscriptionSer()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateDiscretionSer(updatesDiscSer);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String removeDiscriptionSer(DiscretionSer data)
	{
		this.deletesDiscSer=data;
		return null;
	}
	
	
	public String deleteDiscriptionSer()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delDiscretionSer(deletesDiscSer);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenDiscriptionSerId()
	{
		InitialContext ic;
		try {
			selectDiscSerId=new DiscretionSer();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectDiscSerId=hp.selectDiscretionSerById(DiscSerId);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String chosenAllDiscriptionSer()
	{
		InitialContext ic;
		try {
			selectAllDiscSer=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllDiscSer=hp.selectAllDiscretionSer();
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
