package model.bean;

import java.util.List;

import javax.ejb.Remote;

import model.entity.SystemLookup;

@Remote
public interface SystemLookupBeanRemote {
	public List<SystemLookup> selectLookupBasedMajorID(int majorid);
	 public List<SystemLookup> selectLookupBasedMinorID(int lookupId);
	 

}
