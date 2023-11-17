package com.clinicCenter.Bean;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.User;

public class userAdminBusClass {
	private User addUserNew;
    private User chooesUserId;
    private long userId;
    private User updatesUser;
    private User removesUser;
    private String usersName;
    private List<User> selectUserName;
    private List<User> selectAllUser;
    
    
    
    
	public List<User> getSelectAllUser() {
		return selectAllUser;
	}

	public void setSelectAllUser(List<User> selectAllUser) {
		this.selectAllUser = selectAllUser;
	}

	public List<User> getSelectUserName() {
		return selectUserName;
	}

	public void setSelectUserName(List<User> selectUserName) {
		this.selectUserName = selectUserName;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public User getRemovesUser() {
		return removesUser;
	}

	public void setRemovesUser(User removesUser) {
		this.removesUser = removesUser;
	}

	public User getUpdatesUser() {
		return updatesUser;
	}

	public void setUpdatesUser(User updatesUser) {
		this.updatesUser = updatesUser;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public User getChooesUserId() {
		return chooesUserId;
	}

	public void setChooesUserId(User chooesUserId) {
		this.chooesUserId = chooesUserId;
	}

	
	

//	public userAdminBusClass()
//	{
//		addUserNew=new User();
//	}

	public User getAddUserNew() {
		return addUserNew;
	}

	public void setAddUserNew(User addUserNew) {
		this.addUserNew = addUserNew;
	}

	@PostConstruct
	public void init(){
		addUserNew=new User();
		addUserNew.setClinicCenter(new ClinicCenter());
		chosenAllUser();
		
	}
	

	
	

	public String getEditsUsers(User data)
	{
		 this.updatesUser=data;
		 return "editeUsers.xhtml";
	}
	
	public String addNewUser1()
	{
		InitialContext ic;
		
		try {
			

			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addUser(addUserNew);
			return "showNewUser.xhtml";
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String userInsert()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp;
			hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.addUser(addUserNew);

		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return null;
	}
	public String selectUserbyIdNo()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.selectUserByPrimaryKey(userId);
			return "showNewUser.xhtml";
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String updateUser()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateUser(updatesUser);
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String getRemove(User data)
	{   
		this.removesUser=data;
		return "adminDelUser.xhtml";
	}
	public String removeUser()
	{
		InitialContext ic;
		try {
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.delUser(removesUser);
			
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String  ChosenUser()
	{
		InitialContext ic;
		try {
			selectUserName=new ArrayList<>();
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectUserName=hp.selectUserByName(usersName);
			return "adminSelectUserName.xhtml";
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public String chosenAllUser()
	{
		InitialContext ic;
		try {
			selectAllUser=new ArrayList<>();

			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			selectAllUser=hp.selectUser();
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
