package model.bean;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

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

@Remote
public interface AdmainBusinessBeanRemote {
  
	/****User Operation**/

	public void addUser(User data);
	
	public void delUser(User data);
	 public void updateUser(User data);
	 public  List<User> selectUser();
	 public List<User> selectUserByPrimaryKey(Long id);
	 public List<User> selectUserByName(String userName);
	 public List<String> selectByUserNameAutoComplate(String userName);
	 /*****doctor Operation***/

	 public void addDoctor(Doctor data);
	 public void removeDoctor(Doctor data);
	 public void updateDoctor(Doctor data);
	 public List<Doctor> selectAllDoctor();
	 public List<Doctor> SelectDoctorById(long id);
	 public List<Doctor> selectDoctorByName(String doctorName);
	 public List<String> searchDoctorAutoName(String data);
	 /*****Clinic Operation***/
	 public List<String> searchAutoName(String data);
	 public void addClinc(ClinicCenter data);
	 public void removeClinic(ClinicCenter data);
	 public void updateClinic(ClinicCenter data);
	 public List<ClinicCenter> selectAllClinic();
	 public List<ClinicCenter> SelectClinicById(long id);
	 public List<ClinicCenter> selectClinicByName(String clinicName);
	 public List<Object[]> selectClinicNameAndID();
	 /*****Insurance Company Operation****/
	    public void addCompany(InsuranceCompany data);
	    public void updateCompany(InsuranceCompany data);
	    public void delCompany(InsuranceCompany data);
	    public List<InsuranceCompany> selectCompanyById(long id);
	    public List<InsuranceCompany> selectAllCompany();
	    public List<InsuranceCompany> selectCompanyByName(String CompName);
	    /********Card Insurance Operation*******/
	    public void addInsCard(CardInsurance data);
	    public void updateInsCard(CardInsurance data);
	    public void delInsCard(CardInsurance data);
	    public CardInsurance selectInsCardById(long id);
	    public List<CardInsurance> selectAllCardIns();
	    public List <CardInsurance> selectCardByname(String cardName);
	   /******Medicine Operation*****/
	 
	    public void addMedicine(Medicine data);
	    public void updateMedicine(Medicine data);
	    public void delMedicine(Medicine data);
	    public List<Medicine> selectMedicineById(long id);
	    public List<Medicine> selectAllMedicine();
	    public List<Medicine> selectMedicineByMedName(String medName);
	    public List<Medicine> selectMedicineByMedSName(String medSName);
	    public List<String> selectMedicineByMedNameAutoComp(String medName);
	    public List<String> selectMedicineByMedSNameAutoComp(String medSName);


	    /*************Dose Operation***************/
	    
	    public void addDose(Dose data);
	    public void updateDose(Dose data);		
	    public void delDose(Dose data);
	    public List<Dose> selectDoseById(long id);
	    public List<Dose> selectAllDose();
	    public List<Dose> selectByDoseName(String doseName);
	    public List<String> selectByDoseNameAutoComplate(String doseName);
	    
        /********Medical Check Operation**********/
	    public void addMedicalCheck(MedicalCheck data);
	    public void updateMedicalCheck(MedicalCheck data);
	    public void delMedicalCheck(MedicalCheck data);
	    public MedicalCheck selectMedicalCheckById(long id);
	    public List<MedicalCheck> selectAllMedicalCheck();
	    public List<MedicalCheck> selectByMedCheckName(String medCheckName);

        /*********Diagnosis **********/

	    public void addDiagnosis(Diagnosi data);
	    public void updateDiagnosis(Diagnosi data);
	    public void delDiagnosis(Diagnosi data);
	    public Diagnosi selectDiagnosisById(long id);
	    public List<Diagnosi> selectDiagnosis();
	    public List<Diagnosi> selectByDiagnosisName(String DaigName);
	    public void deleteDiagnosisCheckbox(List<Diagnosi> data);

	      /**************Patient Service Operation*************/

	    public void addPatSerivce(PatSerivce data);
	    public void updatePatSerivce(PatSerivce data);
	    public void delPatSerivce(PatSerivce data);
	    public PatSerivce selectPatSerivceById(long id);
	    public List<PatSerivce> selectAllPatSerivce();
	    public List<PatSerivce> selectByPatSerivceName(String patServName);
	    
        /***********Patient Operation*************/

	    public void addPatient(Patient data);
	    public void updatePatient(Patient data);
	    public void delPatient(Patient data);
	    public Patient selectPatientById(long id);
	    public List<Patient> selectAllPatient();
	    public List<Patient> selectByPatFirstName(String firstName,String middelName, String lastName);
	    public List<Patient> selectPatientPhoneNumber(String phoneNo);
	    public List<Patient> selectPatientByEmail(String patEmail);

        /***************Appointment****************/


	    public void addAppointment(Appointment data);
	    public void updateAppointment(Appointment data);
	    public void delAppointment(Appointment data);
	    public Appointment selectAppointmentById(long id);
	    public List<Appointment> selectAllAppointment();
	    public List<Appointment> selectAppointmentByName(String apptName);
	    public List<Appointment> selectAppointmentByDate(Date appDate);
	    public List<Appointment> selectAppointmentByPatientName(String patiFName ,String patiMName ,String patiLName);
	    public List<Appointment> selectAppointmentByClinicName(String cliName);
	    public List<Appointment> selectAppointmentByDoctor(String doctorName);
	    
	     /*************PatientVisit*************/

	    
	    public void addPatientVisit(PatientVisit data);
	    public void updatePatientVisit(PatientVisit data);
	    public void delPatientVisit(PatientVisit data);
	    public PatientVisit selectPatientVisitById(long id);
	    public List<PatientVisit> selectAllPatientVisit();
	    public List<PatientVisit>  selectPatientVisitByName(String patVisitName);
	    public List<PatientVisit> selectPatientVisitByDate(Date visitDate);
	    public List<PatientVisit> selectPatientVisitByDoctor(String DoctorName);
	    public List<PatientVisit> selectPatientVisitByClinic(String clinicName);
	    public List<PatientVisit> selectPatientVisitByPatientName(String PatFirstName,String PatMiddelName,String PatLasttName);

	    
	    /**************************Prescription Operation*********/

	    
	    public void addPrescription(Prescription data);
	    public void updatePrescription(Prescription data);
	    public void delPrescription(Prescription data);
	    public Prescription selectPrescriptionById(long id);
	    public List<Prescription> selectAllPrescription();
	    public List<Prescription> selectPrescriptionByName(String presName);
	    public List<Prescription> selectPrescriptionByPatientName(String PatFirstName,String PatMiddelName,String PatLasttName);
	    public List<Prescription> selectPrescriptionByVisitDate(Date visitDate);

	    
        /**********DiagnList Operation************/

	    public void addDiagnList(DiagnList data);
	    public void updateDiagnList(DiagnList data);
	    public void delDiagnList(DiagnList data);
	    public DiagnList selectDiagnListById(long id);
	    public List<DiagnList> selectAllDiagnList();
	    public List<DiagnList> selectDiagnListByPatientName(String PatFirstName,String PatMiddelName,String PatLasttName);
	    public List<DiagnList> selectDiagnListByClinic(String clinicName);
	    public List<DiagnList> selectDiagnListByPatientVisit(long fVisId);

	    /********************DiscretionSer Operation *****************/

	    public void addDiscretionSer(DiscretionSer data);
	    public void updateDiscretionSer(DiscretionSer data);
	    public void delDiscretionSer(DiscretionSer data);
	    public DiscretionSer selectDiscretionSerById(long id);
	    public List<DiscretionSer> selectAllDiscretionSer();

	    
	    /*************RequestMedChk Operation*******************/

	    
	    public void addRequestMedChk(RequestMedChk data);
	    public void updateRequestMedChk(RequestMedChk data);
	    public void delRequestMedChk(RequestMedChk data);
	    public RequestMedChk selectRequestMedChkById(long id);
	    public List<RequestMedChk> selectAllRequestMedChk();

	    
	
}



