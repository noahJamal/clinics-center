package model.bean;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import model.entity.Appointment;
import model.entity.CardInsurance;
import model.entity.ClinicCenter;
import model.entity.DiagnList;
import model.entity.Diagnosi;
import model.entity.DiscretionSer;
import model.entity.Doctor;
import model.entity.Dose;
import model.entity.InsuranceCompany;
import model.entity.MedicalCheck;
import model.entity.Medicine;
import model.entity.PatSerivce;
import model.entity.Patient;
import model.entity.PatientVisit;
import model.entity.Prescription;
import model.entity.RequestMedChk;
import model.entity.User;

/**
 * Session Bean implementation class AdmainBusinessBean
 */
@Stateless
@LocalBean
public class AdmainBusinessBean implements AdmainBusinessBeanRemote {

    /**
     * Default constructor. 
     */
    public AdmainBusinessBean() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(name="ClincFinalProjectEJB")
    private EntityManager entityManager;//=EntityManagerUtil.getEntityMamager();


    public void addUser(User data)
    {
    	try{
    		
        	entityManager.persist(data);


    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    public void delUser(User data)
    {
    	try{
    	//entityManager.getTransaction().begin();
    		
    		User remUser=entityManager.merge(data);
    		
    	entityManager.remove(remUser);
    	//entityManager.getTransaction().commit();
    	//entityManager.close();
    	}
    	catch (Exception e) {
    		e.printStackTrace();

    	}
    }
    public void updateUser(User data)
    {
    	try {
    		//entityManager.getTransaction().begin();
    		entityManager.merge(data);
    		//entityManager.getTransaction().commit();
    		//entityManager.clear();
			
		} catch (Exception e) {
         e.printStackTrace();
		}
    }
    public  List<User> selectUser()
    {
    	try{
    //	entityManager.getTransaction().begin();
    	List<User> allUsers=new ArrayList<>();
    	allUsers=entityManager.createNamedQuery("User.findAll").getResultList(); 	
    	 User data=new User();
//    	entityManager.getTransaction().commit();
//    	entityManager.close();
    	return allUsers;
    	}
    	catch (Exception e) {
    		e.printStackTrace();

    	}
    	return null;
    }
    
    public  List<User> selectUserByPrimaryKey(Long id)
    {
    	try{
    	//entityManager.getTransaction().begin();
        User data=new User();
        
        	data=entityManager.find(User.class, id);
        	List<User> convertDataList=new ArrayList<>();
        	convertDataList.add(data);
        	
        	
//    	entityManager.getTransaction().commit();
//    	entityManager.close();
    	return convertDataList;
    	}
    	catch (Exception e) {
    		e.printStackTrace();

    	}
    	return null;
    }
    
    public List<User> selectUserByName(String userName)
    {
    	try {
    		//entityManager.getTransaction().begin();
    		List<User> useInfo =new ArrayList<>();
    		Query query=entityManager.createNamedQuery("User.findByName");
    		query.setParameter("userName", userName);
    		useInfo=query.getResultList();
        	return useInfo;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
        return null;
    }
    
    public List<String> selectByUserNameAutoComplate(String userName)
    {
    	try {
			List<String> userNameAutoComp=new ArrayList<>();
			Query query=entityManager.createNamedQuery("User.findByAutoComplateName").setParameter("userName", userName+"%");
			userNameAutoComp=query.getResultList();
			return userNameAutoComp;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return null;
    	
    }
    
    
    /////// DoctorControl/////////////////////////////////////
    
    public void addDoctor(Doctor data)
    {
    	try {
    		//entityManager.getTransaction().begin();
        	
        	entityManager.persist(data);
//        	entityManager.getTransaction().commit();
//        	entityManager.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	}
    
    public void removeDoctor(Doctor data)
    {
    	try {
    		//entityManager.getTransaction().begin();
    		Doctor delDoc=entityManager.merge(data); 
        	entityManager.remove(delDoc);
//        	entityManager.getTransaction().commit();
//        	entityManager.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
    	}
    
    public void updateDoctor(Doctor data)
    {
    	try {
    		//entityManager.getTransaction().begin();
    		Doctor editDoc=entityManager.merge(data);
    		
        	entityManager.merge(editDoc);
//        	entityManager.getTransaction().commit();
//        	entityManager.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
    	}
    public List<Doctor> selectAllDoctor()
    { 
    	try {
    		List<Doctor> allDoctor=new ArrayList<>();
    		
    		//entityManager.getTransaction().begin();
    		allDoctor=entityManager.createNamedQuery("Doctor.findAll").getResultList();
       
        	return allDoctor;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
        return null;

    	}
    public List<Doctor> SelectDoctorById(long id)
    {
    	try {
    		
    		Doctor doctor=new Doctor();
    		//entityManager.getTransaction().begin();
    		doctor=entityManager.find(Doctor.class, id);
    		List<Doctor> convertDocToList=new ArrayList<>();
    		convertDocToList.add(doctor);
        	
        	return convertDocToList ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
        return null;
    	
    }
    public List<Doctor> selectDoctorByName(String doctorName)
    {
    	try {
    		//entityManager.getTransaction().begin();
    		List<Doctor> DoctorInfo =new ArrayList<>();
    		Query query=entityManager.createNamedQuery("Doctor.findAllByName");
    		query.setParameter("doctorName", doctorName);
    		DoctorInfo=query.getResultList();
        	return DoctorInfo;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
        return null;
    }
    
    public List<String> searchDoctorAutoName(String data)
    {
    	       List<String> doctorNameList;
    	       
    	try {
    		Query query=entityManager.createQuery("select d.dcoName from Doctor d where d.dcoName LIKE :data ");
    		query.setParameter("data", data+"%");
    		doctorNameList=new ArrayList<>();
    		doctorNameList=query.getResultList();
    		
    		return doctorNameList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return null;
    	
    }
    
  
                       
                                 /****ClinicOperationAdmin******/
    
    
    public void addClinc(ClinicCenter data)
    {
    	try {
    		//entityManager.getTransaction().begin();
        	entityManager.persist(data);
//        	entityManager.getTransaction().commit();
//        	entityManager.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	}
    
    public void removeClinic(ClinicCenter data)
    {
    	try {
    		ClinicCenter clincDeath=entityManager.merge(data);
    		//entityManager.getTransaction().begin();
        	entityManager.remove(clincDeath);
//        	entityManager.getTransaction().commit();
//        	entityManager.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
    	}
    
    public void updateClinic(ClinicCenter data)
    {
    	try {
    		//entityManager.getTransaction().begin();
        	entityManager.merge(data);
        	//entityManager.getTransaction().commit();
        	//entityManager.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
    	}
    public List<ClinicCenter> selectAllClinic()
    { 
    	try {
    		List<ClinicCenter> allClinic=new ArrayList<>();
    		
    		//entityManager.getTransaction().begin();
    		allClinic=entityManager.createNamedQuery("ClinicCenter.findAll").getResultList();
        	return allClinic;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
        return null;

    	}
    public List<ClinicCenter> SelectClinicById(long id)
    {
    	try {
    		ClinicCenter clinics=new ClinicCenter();
    		//entityManager.getTransaction().begin();
    		clinics=entityManager.find(ClinicCenter.class, id);;
        	List<ClinicCenter> convertClinicList=new ArrayList<>();
        	convertClinicList.add(clinics);
        	return convertClinicList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
        return null;
    	
    }
    public List<ClinicCenter> selectClinicByName(String clinicName)
    {
    	try {
    		//entityManager.getTransaction().begin();
    		List<ClinicCenter> clinicInfo =new ArrayList<>();
    		Query query=entityManager.createNamedQuery("ClinicCenterByName.findAll");
    		query.setParameter("clinicName", clinicName);
    		clinicInfo=query.getResultList();
        	return clinicInfo;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();}
        return null;
    }
    
	 public List<String> searchAutoName(String data)
    {
    	try {
			
    		
    	List<String> clinicName=new ArrayList<>();                       
    	Query query = entityManager.createQuery("select c.cliName from ClinicCenter c where c.cliName LIKE :data"  );
    	
    	query.setParameter("data",data+"%");
    	clinicName=  query.getResultList(); 
    	return clinicName;
    	} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return null;
    }
	 
	 public List<Object[]> selectClinicNameAndID()
	 {      
		 List<Object[]> selectCliNameAndId=new ArrayList<>();
		 
		 
		 try {
			 Query query=entityManager.createNamedQuery("ClinicCenter.findNameAndID");
			 selectCliNameAndId=query.getResultList();
			 return selectCliNameAndId;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		 return null;
	 }
    
    /******InsuranceCompanyOperaton*******/
    
    public void addCompany(InsuranceCompany data)
    {
    	try {
			entityManager.persist(data);
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    
    public void updateCompany(InsuranceCompany data)
    {
    	try {
    		entityManager.merge(data);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    public void delCompany(InsuranceCompany data)
    {
    	try {
    		InsuranceCompany delCom=entityManager.merge(data);
    		entityManager.remove(delCom);
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
    	
    }
    public List<InsuranceCompany> selectCompanyById(long id)
    {
    	try {
    		InsuranceCompany selectId=new InsuranceCompany();
    		selectId=entityManager.find(InsuranceCompany.class, id);
    		List<InsuranceCompany> convertToList=new ArrayList<>();
    		convertToList.add(selectId);
    		return convertToList;
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return null;
    	
    }
    
    public List<InsuranceCompany> selectAllCompany()
    {
    	try {
    		List<InsuranceCompany> allCompany=new ArrayList<>();
    		Query query=entityManager.createNamedQuery("InsuranceCompany.findAll");
    		allCompany=query.getResultList();
    		return allCompany;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return null;
    }

    public List<InsuranceCompany> selectCompanyByName(String CompName)
    {
    	try {
    		List<InsuranceCompany> compByName=new ArrayList<>();
    		Query query=entityManager.createNamedQuery("InsuranceCompany.findAllByName");
    		query.setParameter("compName", CompName);
    		compByName=query.getResultList();
    		return compByName;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return null;
    	
    	
    }
  
    
    /********CardInsuranceOperation*******/
    
    public void addInsCard(CardInsurance data)
    {
    	try {
    		entityManager.persist(data);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }

    public void updateInsCard(CardInsurance data)
    {
    	try {
    		entityManager.merge(data);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
public void delInsCard(CardInsurance data)
{
	try {
		CardInsurance delCard=entityManager.merge(data);
		entityManager.remove(delCard);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
public CardInsurance selectInsCardById(long id)
{
	try {
		CardInsurance cardId=new CardInsurance();
		cardId=entityManager.find(CardInsurance.class, id);
		return cardId;
		
	} catch (Exception e) {
		// TODO: handle exception
	}
return null;}
public List<CardInsurance> selectAllCardIns()
{
	try {
		List<CardInsurance> allCardIns=new ArrayList<>();
		Query query=entityManager.createNamedQuery("CardInsurance.findAll");
		allCardIns=query.getResultList();
		return allCardIns;
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
return null;	
}
public List <CardInsurance> selectCardByname(String cardName)
{
	try {
		List<CardInsurance> cardByName=new ArrayList<>();
		Query query=entityManager.createNamedQuery("CardInsurance.findAllByName");
		query.setParameter("cardName", cardName);
		cardByName=query.getResultList();
		return cardByName;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}


      /******Medicine Operation****/

public void addMedicine(Medicine data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
public void updateMedicine(Medicine data){
	try {
		entityManager.merge(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delMedicine(Medicine data)
{
	try {
		Medicine delMed=entityManager.merge(data);
		entityManager.remove(delMed);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
public List<Medicine> selectMedicineById(long id)
{
	try {
		Medicine medicId=new Medicine();
		medicId=entityManager.find(Medicine.class, id);
		List<Medicine> convertObjectToList=new ArrayList<>();
		convertObjectToList.add(medicId);
		return convertObjectToList;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}


public List<Medicine> selectAllMedicine()
{
	try {
		List<Medicine> AllMed=new ArrayList<>();
		AllMed=entityManager.createNamedQuery("Medicine.findAll").getResultList();
		return AllMed;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	
	}
public List<String> selectMedicineByMedNameAutoComp(String medName)
{   try {
	List<String> medicName=new ArrayList<>();
	Query query=entityManager.createNamedQuery("Medicine.findByNameAutoComplete");
	query.setParameter("medName", medName+"%");
	medicName=query.getResultList();
	return medicName;

	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
	return null;}

public List<Medicine> selectMedicineByMedName(String medName)
{   try {
	List<Medicine> medicName=new ArrayList<>();
	Query query=entityManager.createNamedQuery("Medicine.findByName");
	query.setParameter("medName", medName);
	medicName=query.getResultList();
	return medicName;

	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
	return null;}


public List<String> selectMedicineByMedSNameAutoComp(String medSName)
{   try {
	List<String> medicSName=new ArrayList<>();
	Query query=entityManager.createNamedQuery("Medicine.findByMedSNameAutoComplete");
	query.setParameter("medSName", medSName+"%");
	medicSName=query.getResultList();
	return medicSName;

	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
	return null;}

public List<Medicine> selectMedicineByMedSName(String medSName)
{   try {
	List<Medicine> medicSName=new ArrayList<>();
	Query query=entityManager.createNamedQuery("Medicine.findByMedSName");
	query.setParameter("medSName", medSName);
	medicSName=query.getResultList();
	return medicSName;

	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
	return null;}

/**************Dose Operation*****************/
public void addDose(Dose data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void updateDose(Dose data)
{
	try {
		entityManager.merge(data);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delDose(Dose data)
{
	try {
		Dose delDo=entityManager.merge(data);
		entityManager.remove(delDo);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public List<Dose> selectDoseById(long id)
{
	try {
		List<Dose> convertToList=new ArrayList<>();
		Dose doseId=new Dose();
		doseId=entityManager.find(Dose.class, id);
		convertToList.add(doseId);
		return convertToList;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}

public List<Dose> selectAllDose()
{
	try {
		List<Dose> allDose=new ArrayList<>();
		allDose=entityManager.createNamedQuery("Dose.findAll").getResultList();
		return allDose;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}

public List<String> selectByDoseNameAutoComplate(String doseName)
{
	try {
		List<String> doNameComplete=new ArrayList<>();
        Query query=entityManager.createNamedQuery("Dose.findDoesNameAutoComplete");
        query.setParameter("doesName", doseName+"%");
        doNameComplete=query.getResultList();
      return  doNameComplete;    
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}

///////////




/////////////

public List<Dose> selectByDoseName(String doseName)
{
	try {
		List<Dose> doName=new ArrayList<>();
        Query query=entityManager.createNamedQuery("Dose.findDoesByName");
        query.setParameter("doesName", doseName);
        doName=query.getResultList();
      return  doName;    
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}
                
          /********Medical Check Operation**********/

public void addMedicalCheck(MedicalCheck data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void updateMedicalCheck(MedicalCheck data)
{
	try {
		entityManager.merge(data);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delMedicalCheck(MedicalCheck data)
{
	try {
		MedicalCheck delMedCheck=entityManager.merge(data);
		entityManager.remove(delMedCheck);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public MedicalCheck selectMedicalCheckById(long id)
{
	try {
		MedicalCheck MedCheckId=new MedicalCheck();
		MedCheckId=entityManager.find(MedicalCheck.class, id);
		return MedCheckId;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	}
public List<MedicalCheck> selectAllMedicalCheck()
{
	try {
		List<MedicalCheck> allMedCheck=new ArrayList<>();
		allMedCheck=entityManager.createNamedQuery("MedicalCheck.findAll").getResultList();
		return allMedCheck;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}

public List<MedicalCheck> selectByMedCheckName(String medCheckName)
{
	try {
		List<MedicalCheck> medicalCheckName=new ArrayList<>();
        Query query=entityManager.createNamedQuery("MedicalCheck.findByName");
        query.setParameter("medCheckName", medCheckName);
        medicalCheckName=query.getResultList();
      return  medicalCheckName;    
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}

          /*********Diagnosis **********/


public void addDiagnosis(Diagnosi data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void updateDiagnosis(Diagnosi data)
{
	try {
		entityManager.merge(data);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delDiagnosis(Diagnosi data)
{
	try {
		Diagnosi delDiagnosis=entityManager.merge(data);
		entityManager.remove(delDiagnosis);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public void deleteDiagnosisCheckbox(List<Diagnosi> data)
{   
	try{
		Diagnosi dd=new Diagnosi();
		List<Diagnosi> delDiagnosis=new ArrayList<>();
		delDiagnosis=data;
		
		for (Diagnosi diagnosi : delDiagnosis) {
			dd=entityManager.merge(diagnosi);
			entityManager.remove(dd);}
	
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public Diagnosi selectDiagnosisById(long id)
{
	try {
		Diagnosi diagId=new Diagnosi();
		diagId=entityManager.find(Diagnosi.class, id);
		return diagId;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	}
public List<Diagnosi> selectDiagnosis()
{
	try {
		List<Diagnosi> allDiag=new ArrayList<>();
		allDiag=entityManager.createNamedQuery("Diagnosi.findAll").getResultList();
		return allDiag;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}

public List<Diagnosi> selectByDiagnosisName(String DaigName)
{
	try {
		List<Diagnosi> diagnosisName=new ArrayList<>();
        Query query=entityManager.createNamedQuery("Diagnosi.findByDaigName");
        query.setParameter("daigName", DaigName);
        diagnosisName=query.getResultList();
      return  diagnosisName;    
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}



      /**************Patient Service Operation*************/

public void addPatSerivce(PatSerivce data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void updatePatSerivce(PatSerivce data)
{
	try {
		entityManager.merge(data);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delPatSerivce(PatSerivce data)
{
	try {
		PatSerivce delPatSer=entityManager.merge(data);
		entityManager.remove(delPatSer);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public PatSerivce selectPatSerivceById(long id)
{
	try {
		PatSerivce patServId=new PatSerivce();
		patServId=entityManager.find(PatSerivce.class, id);
		return patServId;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	}
public List<PatSerivce> selectAllPatSerivce()
{
	try {
		List<PatSerivce> allPatSerivce=new ArrayList<>();
		allPatSerivce=entityManager.createNamedQuery("PatSerivce.findAll").getResultList();
		return allPatSerivce;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}

public List<PatSerivce> selectByPatSerivceName(String patServName)
{
	try {
		List<PatSerivce> sevName=new ArrayList<>();
        Query query=entityManager.createNamedQuery("PatSerivce.findByName");
        query.setParameter("serName", patServName);
        sevName=query.getResultList();
      return  sevName;    
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}


         /***********Patient Operation*************/
public void addPatient(Patient data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void updatePatient(Patient data)
{
	try {
		entityManager.merge(data);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delPatient(Patient data)
{
	try {
		Patient delPat=entityManager.merge(data);
		entityManager.remove(delPat);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public Patient selectPatientById(long id)
{
	try {
		Patient patId=new Patient();
		patId=entityManager.find(Patient.class, id);
		return patId;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;
	}
public List<Patient> selectAllPatient()
{
	try {
		List<Patient> allPat=new ArrayList<>();
		allPat=entityManager.createNamedQuery("Patient.findAll").getResultList();
		return allPat;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}

public List<Patient> selectByPatFirstName(String firstName,String middelName, String lastName)
{
	try {
		List<Patient> patFullName=new ArrayList<>();
        Query query=entityManager.createNamedQuery("Patient.findPatByName");
        query.setParameter("patFName", firstName);
        query.setParameter("patMName", middelName);
        query.setParameter("patLName", lastName);
        patFullName=query.getResultList();
      return  patFullName;    
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}
public List<Patient> selectPatientPhoneNumber(String phoneNo)
{
	try {
	List<Patient> patPhone=new ArrayList<>();
	Query query =entityManager.createNamedQuery("Patient.findByPhone");
	query.setParameter("patPhone1", phoneNo);
	patPhone=query.getResultList();
	return patPhone;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
return null;

}
public List<Patient> selectPatientByEmail(String patEmail)
{
	try {
	List<Patient> userEmail=new ArrayList<>();
	Query query =entityManager.createNamedQuery("Patient.findByEmail");
	query.setParameter("patEmail", patEmail);
	userEmail=query.getResultList();
	return userEmail;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
return null;

}

               /***************Appointment****************/
public void addAppointment(Appointment data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}

public void updateAppointment(Appointment data)
{
	try {
		entityManager.merge(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delAppointment(Appointment data)
{
try {
	Appointment delApp=entityManager.merge(data);
	entityManager.remove(delApp);
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
}
public Appointment selectAppointmentById(long id)
{
try {
	Appointment appId=new Appointment();
	appId=entityManager.find(Appointment.class, id);
	return appId;
	
} catch (Exception e) {
	// TODO: handle exception
}
return null;}

public List<Appointment> selectAllAppointment()
{
try {
	List<Appointment> allApp=new ArrayList<>();
	Query query=entityManager.createNamedQuery("Appointment.findAll");
	allApp=query.getResultList();
	return allApp;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;	
}

public List<Appointment> selectAppointmentByName(String apptName)
{
	try {
List<Appointment> apptointName=new ArrayList<>();
Query query=entityManager.createNamedQuery("Appointment.findByName");
query.setParameter("apoName", apptName);
apptointName =query.getResultList();
return apptointName;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}
public List<Appointment> selectAppointmentByDate(Date appDate)
{
	try {
List<Appointment> apptointDate=new ArrayList<>();
Query query=entityManager.createNamedQuery("Appointment.findByDate");
query.setParameter("apoDate",appDate );
apptointDate =query.getResultList();
return apptointDate;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}
public List<Appointment> selectAppointmentByPatientName(String patiFName ,String patiMName ,String patiLName)
{
	try {
		List<Appointment> patientName=new ArrayList<>();
		Query query=entityManager.createNamedQuery("Appointment.findByPatient");
		query.setParameter("patFname", patiFName);
		query.setParameter("patMname", patiMName);
		query.setParameter("patLname", patiLName);
		patientName=query.getResultList();
		return patientName;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;
	}

public List<Appointment> selectAppointmentByClinicName(String cliName)
{
	try {
		List<Appointment> appClinic=new ArrayList<>();
		Query query =entityManager.createNamedQuery("Appointment.findByClinic");
		query.setParameter("clinicName", cliName);
		appClinic=query.getResultList();
		return appClinic;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}


public List<Appointment> selectAppointmentByDoctor(String doctorName)
{
	try {
		List<Appointment> appDoc=new ArrayList<>();
		Query query =entityManager.createNamedQuery("Appointment.findByDoctor");
		query.setParameter("docName", doctorName);
		appDoc=query.getResultList();
		return appDoc;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}


     /*************PatientVisit*************/

public void addPatientVisit(PatientVisit data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}

public void updatePatientVisit(PatientVisit data)
{
	try {
		entityManager.merge(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delPatientVisit(PatientVisit data)
{
try {
	PatientVisit delVisit=entityManager.merge(data);
	entityManager.remove(delVisit);
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();}
}

public PatientVisit selectPatientVisitById(long id)
{
try {
	PatientVisit visitId=new PatientVisit();
	visitId=entityManager.find(PatientVisit.class, id);
	return visitId;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;}

public List<PatientVisit> selectAllPatientVisit()
{
try {
	List<PatientVisit> allVisit=new ArrayList<>();
	Query query=entityManager.createNamedQuery("PatientVisit.findAll");
	allVisit=query.getResultList();
	return allVisit;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;	
}

public List<PatientVisit>  selectPatientVisitByName(String patVisitName)
{   
	try {
		List<PatientVisit> visitName=new ArrayList<>();
		Query query =entityManager.createNamedQuery("PatientVisit.findByVisitName");
		query.setParameter("visName",patVisitName );
		visitName=query.getResultList();
		return visitName;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return null;}

public List<PatientVisit> selectPatientVisitByDate(Date visitDate)
{
	try {
		List<PatientVisit> patVisit=new ArrayList<>();
		Query query =entityManager.createNamedQuery("PatientVisit.findByDate");
		query.setParameter("visDate",visitDate );
		patVisit=query.getResultList();
		return patVisit;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	}
	
	return null;}
public List<PatientVisit> selectPatientVisitByDoctor(String DoctorName)
{
	try {
		List<PatientVisit> doctName=new ArrayList<>();
		Query query =entityManager.createNamedQuery("PatientVisit.findDoctorByName");
		query.setParameter("docName",DoctorName );
		doctName=query.getResultList();
		return doctName;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	}
	
	return null;}
public List<PatientVisit> selectPatientVisitByClinic(String clinicName)

{
	try {
		List<PatientVisit> cliName=new ArrayList<>();
		Query query =entityManager.createNamedQuery("PatientVisit.findAllClinicName");
		query.setParameter("clinName",clinicName );
		cliName=query.getResultList();
		return cliName;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	}
	
	return null;}

public List<PatientVisit> selectPatientVisitByPatientName(String PatFirstName,String PatMiddelName,String PatLasttName)

{
	try {
		List<PatientVisit> patientName=new ArrayList<>();
		Query query =entityManager.createNamedQuery("PatientVisit.findByPatientName");
		query.setParameter("patFName",PatFirstName);
		query.setParameter("patMName",PatMiddelName);
		query.setParameter("patLName",PatLasttName );

		patientName=query.getResultList();
		return patientName;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	}
	
	return null;}

/**************************Prescription Operation*********/

public void addPrescription(Prescription data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void updatePrescription(Prescription data)
{
	try {
		entityManager.merge(data);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delPrescription(Prescription data)
{
	try {
		Prescription delPres=entityManager.merge(data);
		entityManager.remove(delPres);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public Prescription selectPrescriptionById(long id)
{
try {
	Prescription presId=new Prescription();
	presId=entityManager.find(Prescription.class, id);
	return presId;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;}

public List<Prescription> selectAllPrescription()
{
try {
	List<Prescription> allPres=new ArrayList<>();
	Query query=entityManager.createNamedQuery("Prescription.findAll");
	allPres=query.getResultList();
	return allPres;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;	
}
public List<Prescription> selectPrescriptionByName(String presName)
{
try {
	List<Prescription> PrescName=new ArrayList<>();
	Query query=entityManager.createNamedQuery("Prescription.findByPresName");
	query.setParameter("preName",presName );
	PrescName=query.getResultList();
	return PrescName;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;	
}

public List<Prescription> selectPrescriptionByPatientName(String PatFirstName,String PatMiddelName,String PatLasttName)

{
	try {
		List<Prescription> patientName=new ArrayList<>();
		Query query =entityManager.createNamedQuery("PrescriptionByPatientName.findAll");
		query.setParameter("patFName",PatFirstName);
		query.setParameter("patMName",PatMiddelName);
		query.setParameter("patLName",PatLasttName );

		patientName=query.getResultList();
		return patientName;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	}
	
	return null;}

public List<Prescription> selectPrescriptionByVisitDate(Date visitDate)
{
try {
	List<Prescription> prescVisitDate=new ArrayList<>();
	Query query=entityManager.createNamedQuery("PrescriptionByVisitDate.findAll");
	query.setParameter("visDate",visitDate);
	prescVisitDate=query.getResultList();
	return prescVisitDate;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;	
}


                /**********DiagnList Operation************/

public void addDiagnList(DiagnList data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}

public void updateDiagnList(DiagnList data)
{
	try {
		entityManager.merge(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delDiagnList(DiagnList data)
{
try {
	DiagnList delDgnList=entityManager.merge(data);
	entityManager.remove(delDgnList);
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
}
public DiagnList selectDiagnListById(long id)
{
try {
	DiagnList dgnListId=new DiagnList();
	dgnListId=entityManager.find(DiagnList.class, id);
	return dgnListId;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;}

public List<DiagnList> selectAllDiagnList()
{
	try {
		List<DiagnList> allDiagnList=new ArrayList<>();
		Query query=entityManager.createNamedQuery("DiagnList.findAll");
		allDiagnList=query.getResultList();
		return allDiagnList;
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return null;}
public List<DiagnList> selectDiagnListByPatientName(String PatFirstName,String PatMiddelName,String PatLasttName)

{
	try {
		List<DiagnList> patientName=new ArrayList<>();
		Query query =entityManager.createNamedQuery("DiagnListByVisitPainetName.findAll");
		query.setParameter("patFName",PatFirstName);
		query.setParameter("patMName",PatMiddelName);
		query.setParameter("patLName",PatLasttName );

		patientName=query.getResultList();
		return patientName;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	}
	
	return null;}

public List<DiagnList> selectDiagnListByClinic(String clinicName)

{
	try {
		List<DiagnList> cliName=new ArrayList<>();
		Query query =entityManager.createNamedQuery("DiagnList.findByClinicName");
		query.setParameter("clinName",clinicName );
		cliName=query.getResultList();
		return cliName;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	}
	
	return null;}


public List<DiagnList> selectDiagnListByPatientVisit(long fVisId)

{
	try {
		List<DiagnList> visitPatId=new ArrayList<>();
		Query query =entityManager.createNamedQuery("DiagnList.findVisitId");
		query.setParameter("visId",fVisId );
		visitPatId=query.getResultList();
		return visitPatId;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();	}
	
	return null;}


/********************DiscretionSer Operation *****************/

public void addDiscretionSer(DiscretionSer data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void updateDiscretionSer(DiscretionSer data)
{
	try {
		entityManager.merge(data);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delDiscretionSer(DiscretionSer data)
{
	try {
		DiscretionSer discSer=entityManager.merge(data);
		entityManager.remove(discSer);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public DiscretionSer selectDiscretionSerById(long id)
{
try {
	DiscretionSer discSerId=new DiscretionSer();
	discSerId=entityManager.find(DiscretionSer.class, id);
	return discSerId;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;}

public List<DiscretionSer> selectAllDiscretionSer()
{
try {
	List<DiscretionSer> allDiscSer=new ArrayList<>();
	Query query=entityManager.createNamedQuery("DiscretionSer.findAll");
	allDiscSer=query.getResultList();
	return allDiscSer;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;	
}

   /*************RequestMedChk Operation*******************/

public void addRequestMedChk(RequestMedChk data)
{
	try {
		entityManager.persist(data);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void updateRequestMedChk(RequestMedChk data)
{
	try {
		entityManager.merge(data);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
public void delRequestMedChk(RequestMedChk data)
{
	try {
		RequestMedChk reqMed=entityManager.merge(data);
		entityManager.remove(reqMed);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public RequestMedChk selectRequestMedChkById(long id)
{
try {
	RequestMedChk reqMedId=new RequestMedChk();
	reqMedId=entityManager.find(RequestMedChk.class, id);
	return reqMedId;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;}

public List<RequestMedChk> selectAllRequestMedChk()
{
try {
	List<RequestMedChk> allReqMed=new ArrayList<>();
	Query query=entityManager.createNamedQuery("RequestMedChk.findAll");
	allReqMed=query.getResultList();
	return allReqMed;
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
return null;	
}

}
