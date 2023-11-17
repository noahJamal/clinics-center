package model.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class DoctorBusinessBean
 */
@Stateless
@LocalBean
public class DoctorBusinessBean implements DoctorBusinessBeanRemote {

    /**
     * Default constructor. 
     */
    public DoctorBusinessBean() {
        // TODO Auto-generated constructor stub
    }

}
