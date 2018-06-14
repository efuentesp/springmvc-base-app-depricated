
package com.softtek.acceleo.demo.repository;

import java.util.List;
import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.exception.GenericException;

public interface AuthorityRepository {

	
	 public void addAuthority(Authority authority);   
	 
	 public void editAuthority(Authority authority);
	   
	 public List<Authority> listAuthorityss(Authority authority);   
	    
	 public Authority getAuthority(int empid);   
	    
	 public void deleteAuthority(Authority authority) throws GenericException; 

	 public List<Authority> listAuthorityssQuery(Authority authority, String query, int page, int size);

	 public List<Authority> listAuthoritysPagination(Authority authority, int page, int size);	

     public long getTotalRows();

     public long getTotalRows(String query);

     public long getTotalRowsSearch(String query);

     public List<Authority> getAuthorityByRol(String rol);
 			

	
}

