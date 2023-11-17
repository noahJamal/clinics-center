package com.clinicCenter.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.weld.context.RequestContext;
import org.primefaces.event.SelectEvent;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;


public class addClinicClass {
	private Long clinicId;
	private List<ClinicCenter> clinicIdInfo;
	private String clinicName;
	private ClinicCenter deleteClinic;
	private ClinicCenter updateUser;
	private List<ClinicCenter> selectAllClinic;
	private List<ClinicCenter> selectAllClinic2;
	private ClinicCenter clinicCenter;
	private List<String> autoComName;
	
	/////two variables are select one menu to fetch the value to select.////
	private List<Object[]> selectOneClincName;
	private Map<String,Long> mapSelectClinicNameID=new HashMap<>();;
	
	


	


	

	public List<Object[]> getSelectOneClincName() {
		return selectOneClincName;
	}

	public void setSelectOneClincName(List<Object[]> selectOneClincName) {
		this.selectOneClincName = selectOneClincName;
	}

	public Map<String, Long> getMapSelectClinicNameID() {
		return mapSelectClinicNameID;
	}

	public void setMapSelectClinicNameID(Map<String, Long> mapSelectClinicNameID) {
		this.mapSelectClinicNameID = mapSelectClinicNameID;
	}

	public List<String> getAutoComName() {
		return autoComName;
	}

	public void setAutoComName(List<String> autoComName) {
		this.autoComName = autoComName;
	}

	public List<ClinicCenter> getSelectAllClinic2() {
		
		return selectAllClinic2;
	}

	public void setSelectAllClinic2(List<ClinicCenter> selectAllClinic2) {
	
		this.selectAllClinic2 = selectAllClinic2;
	}

	public List<ClinicCenter> getSelectAllClinic() {
		
		return selectAllClinic;
	}

	public void setSelectAllClinic(List<ClinicCenter> selectAllClinic) {
		this.selectAllClinic = selectAllClinic;
	}

	public ClinicCenter getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(ClinicCenter updateUser) {
		this.updateUser = updateUser;
	}

	

	public ClinicCenter getDeleteClinic() {
		return deleteClinic;
	}

	public void setDeleteClinic(ClinicCenter deleteClinic) {
		this.deleteClinic = deleteClinic;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public List<ClinicCenter> getClinicIdInfo() {
		return clinicIdInfo;
	}

	public void setClinicIdInfo(List<ClinicCenter> clinicIdInfo) {
		this.clinicIdInfo = clinicIdInfo;
	}

	
	
	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public ClinicCenter getClinicCenter() {
		return clinicCenter;
	}

	public void setClinicCenter(ClinicCenter clinicCenter) {
		this.clinicCenter = clinicCenter;
	}
	
	
    
	
	@PostConstruct
	public void init()
	{     
		showAllClinic();
		
		deleteClinic=new ClinicCenter();
		clinicCenter =new ClinicCenter();
		selectAllClinic2=new ArrayList<ClinicCenter>();
		 selectAllClinic2=showAllClinic2();
		 chosenClinicNameAndID();
		 
	}
	
	public String addClinic()
	{     
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hb=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hb.addClinc(clinicCenter);
			showAllClinic();
			dispalyMessage(clinicCenter.getCliName()+"added");
			
			return null;
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 finally{
		        
		        clear();
		        
		    }
			return null;
		}//End Save Method
		

		public void clear(){
			clinicCenter.setCliCode(null);
			clinicCenter.setCliName(null);
			clinicCenter.setCliPhoneNo(null);
			clinicCenter.setCliLoc(null);
			clinicCenter.setCliNote(null);
		    
		}
		
	
	public String selectClincById()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			selectAllClinic=new ArrayList<>();
			AdmainBusinessBeanRemote hb=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllClinic=hb.SelectClinicById(clinicId);
		
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String selectClinicName()
	{  
		InitialContext ic;
		try {
			selectAllClinic=new ArrayList<>();

			ic =new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllClinic= hp.selectClinicByName(clinicName);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
//	
//	public String removeInfo(ClinicCenter data)
//	{   this.deleteClinic=data;
//		return null;
//	}
	public String deleteClinics( )
	{   
		InitialContext ic ;
		try {
			
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp= (AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.removeClinic(deleteClinic);
			showAllClinic();
			dispalyMessage(deleteClinic.getCliName()+"   "+": Deleted");

			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String updateInfo(ClinicCenter data)
	{   this.updateUser=data;
		return null;
	}
	public String editeClinic ()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp = (AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateClinic(updateUser);
			showAllClinic();
			dispalyMessage(updateUser.getCliName()+"   "+": Updated");

		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public String showAllClinic()
	{
		InitialContext ic;
		try {
			selectAllClinic=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllClinic=hp.selectAllClinic();
			
			 
			
			return null;
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ClinicCenter> showAllClinic2()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			return hp.selectAllClinic();
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<String> completeText(String clinicName)
	{
		InitialContext ic;
		try {
			autoComName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			autoComName= hp.searchAutoName(clinicName);
			
            
			return autoComName;
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	///// select one menu to other clinic /////
	
	public void chosenClinicNameAndID()
	{
		
		InitialContext ic;
		try {
			selectOneClincName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectOneClincName=hp.selectClinicNameAndID();
			mapSelectClinicNameID=new HashMap<>();
			
			for(Object[] o : selectOneClincName)
			{
				mapSelectClinicNameID.put(o[1].toString(),Long.parseLong(o[0].toString()) );
			}
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void dispalyMessage(String messages)
	{
		FacesContext fc=FacesContext.getCurrentInstance();
		fc.addMessage(null, new FacesMessage(messages));
		
	}
	

	public String goToPageClincCenter() {
	    // ...
	    return "clinics.xhtml?faces-redirect=true";
	}

	 public void onRowSelect(SelectEvent event) {
	       updateUser=   (ClinicCenter) event.getObject();
	    }
	 
}
