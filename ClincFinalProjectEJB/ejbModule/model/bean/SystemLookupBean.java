package model.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.entity.SystemLookup;

/**
 * Session Bean implementation class SystemLookupBean
 */
@Stateless
@LocalBean
public class SystemLookupBean implements SystemLookupBeanRemote {
    
	
	@PersistenceContext(name="ClincFinalProjectEJB")
	private EntityManager entityManger;
    /**
     * Default constructor. 
     */
    public SystemLookupBean() {
        // TODO Auto-generated constructor stub
    }
    public List<SystemLookup> selectLookupBasedMajorID(int majorid)
    {
    	try {
    		
        	List<SystemLookup> allSystemLookUps=new ArrayList<>();
        	allSystemLookUps=entityManger.createNamedQuery("SystemLookup.findAll").setParameter("majorid", majorid).getResultList();
            return allSystemLookUps;
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	
    	return null;
    }

    public List<SystemLookup> selectLookupBasedMinorID(int lookupId)
    {
    	
    	try {
    		List<SystemLookup> allSystemLookUpsMinor=new ArrayList<>();
        	allSystemLookUpsMinor=entityManger.createNamedQuery("SystemLookup.findAll2").setParameter("SystemLookup.findAll2", lookupId).getResultList();
    		return allSystemLookUpsMinor;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return null;
    }    
}
