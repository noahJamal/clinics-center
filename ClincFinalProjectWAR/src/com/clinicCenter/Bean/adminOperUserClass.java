package com.clinicCenter.Bean;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import model.bean.AdmainBusinessBeanRemote;
import model.entity.ClinicCenter;
import model.entity.User;
public class adminOperUserClass {
	

	
		private User addUserNew;
	    private User chooesUserId;
	    private Long userId;
	    private User updatesUser;
	    private User removesUser=new User();;
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

		

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public User getChooesUserId() {
			return chooesUserId;
		}

		public void setChooesUserId(User chooesUserId) {
			this.chooesUserId = chooesUserId;
		}

		
		

//		public userAdminBusClass()
//		{
//			addUserNew=new User();
//		}

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
				chosenAllUser();
				displyMessage("Added New User :"+addUserNew.getUserName());

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
				
				
					
			
						if(!hp.selectUserByPrimaryKey(userId).contains(null))
						{
							selectAllUser=hp.selectUserByPrimaryKey(userId);

							displyMessage("User ID "+userId +": is exists");

						}
						else
						{
							errorDisaplyMessage("User ID "+userId +": doesn't exists");
							
						}
						
				return null;
				
			} catch (NamingException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
			
		}
//		
//		public String updateUser()
//		{
//			InitialContext ic;
//			try {
////				
//				ic=new InitialContext();
//				AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
//				hp.updateUser(updatesUser);
//			} catch (NamingException e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//			return null;
//		}
//		public String getRemove(User data)
//		{   
//			this.removesUser=data;
//			return "adminDelUser.xhtml";
//		}
		public String removeUser()
		{
			InitialContext ic;
			try {
				ic=new InitialContext();
				AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
				hp.delUser(removesUser);
				chosenAllUser();
				displyMessage("User ID: "+removesUser.getUserId()+" "+" removed");
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
				ic=new InitialContext();
				AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
				if(!hp.selectUserByName(usersName).isEmpty())
				  {
					selectAllUser=hp.selectUserByName(usersName);
					displyMessage("User Name"+usersName +": is exists");
				  }
				else
				  {
					errorDisaplyMessage("User Name "+usersName +": doesn't exists");
				  }
				return null;
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
		

		public String updateUser(CellEditEvent event) {
			DataTable dataTable=(DataTable) event.getSource();
			updatesUser=new User();
			updatesUser=(User) dataTable.getRowData();
			InitialContext ic;
			try{
			ic=new InitialContext();
			AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
			hp.updateUser(updatesUser);
			chosenAllUser();
			displyMessage("The Value has been adjusted");
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
			return null;
		}
		
		public List<String> completeTextName(String userNameComplete)
		
		{
			
			InitialContext ic;
			try {
				ic=new InitialContext();
				AdmainBusinessBeanRemote hp=(AdmainBusinessBeanRemote) ic.lookup("model.bean.AdmainBusinessBeanRemote");
				List<String> selectUserNameAuto=new ArrayList<>();
				selectUserNameAuto=hp.selectByUserNameAutoComplate(userNameComplete);
				return selectUserNameAuto;
			} catch (NamingException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
		
		public void displyMessage(String message)
		{
			FacesContext fct=FacesContext.getCurrentInstance();
			fct.addMessage(null, new FacesMessage(message));
		}
		
		public void errorDisaplyMessage(String errorMessage)
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERORR", errorMessage));
		}

		public String goToPageUserCenter() {
		    // ...
		    return "usersClinic.xhtml?faces-redirect=true";
		}
}
