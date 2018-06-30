package com.softtek.acceleo.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.acceleo.demo.domain.AdminPermiso;
import com.softtek.acceleo.demo.domain.Authority;
import com.softtek.acceleo.demo.domain.AuthorityPrivilege;
import com.softtek.acceleo.demo.domain.Privilege;
import com.softtek.acceleo.demo.security.repository.AdminPermisosRepository;
import com.softtek.acceleo.demo.security.repository.AuthorityPrivilegeRepository;
import com.softtek.acceleo.demo.security.repository.AuthorityRepository;
import com.softtek.acceleo.demo.security.repository.PrivilegeRepository;
import com.softtek.acceleo.demo.service.AdminPermisoService;

/**
 * Clase AdminPermisoServiceImpl.
 * @author PSG.
 *
 */
@Service("adminPermisoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminPermisoServiceImpl implements AdminPermisoService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private AdminPermisosRepository adminPermisoRepository;
	
	@Autowired
	AuthorityPrivilegeRepository authorityPrivilegeRepository; 
	
	@Autowired
	AuthorityRepository authorityRepository;
	
	@Autowired
	PrivilegeRepository privilegeRepository;
	

	/**
	 * Consulta informacion de adminPermiso.
	 */
	public List<AdminPermiso> listAdminPermiso() {
		return adminPermisoRepository.getPermisos();
	}

	@Override
	public void updateAuthorityPrivilege(AdminPermiso adminPermiso) {
		AuthorityPrivilege authorityPrivilege = new AuthorityPrivilege();
		Long authorityID = null;
		Long privilegeID = null;
		Boolean flag = Boolean.FALSE;
		
		List<Authority> lstAuthority = authorityRepository.getAuthority();
		if( lstAuthority == null || lstAuthority.isEmpty() ) {
			logger.info("No se encontro informacion en el catalogo authority.");
		}else {
			for(Authority authority : lstAuthority) {
				if( authority.getIdAuthority().longValue() == adminPermiso.getActiveUser() && "ROLE_ADMIN".equals(authority.getName().name()) ) {
					authorityID = adminPermiso.getIdAuthorityAdmin();
					privilegeID = adminPermiso.getIdPrivilegeAdmin();
					flag = adminPermiso.isAdmin();
					break;
				}else if( authority.getIdAuthority().longValue() == adminPermiso.getActiveUser() && "ROLE_USER".equals(authority.getName().name()) ) {
					authorityID = adminPermiso.getIdAuthorityUser();
					privilegeID = adminPermiso.getIdPrivilegeUser();
					flag = adminPermiso.isUser();
					break;
				}else if( authority.getIdAuthority().longValue() == adminPermiso.getActiveUser() && "ROLE_ANONYMOUS".equals(authority.getName().name()) ) {
					authorityID = adminPermiso.getIdAuthorityAnonymous();
					privilegeID = adminPermiso.getIdPrivilegeAnonymous();
					flag = adminPermiso.isAnonymous();
					break;
				}
			}
		}
		
		AuthorityPrivilege autPriv = null;
		if( authorityID != null && privilegeID != null ) {
			Authority authority = authorityRepository.getAuthority(authorityID);
			Privilege privilege = privilegeRepository.getPrivilege(privilegeID);

			authorityPrivilege.setIdAuthority(authority);		
			authorityPrivilege.setIdPrivilege(privilege);
			authorityPrivilege.setEnabled(flag);
			
			autPriv = authorityPrivilegeRepository.getAuthorityPrivilege(authorityPrivilege);			
		}
		
		if( autPriv == null) {			
			authorityPrivilegeRepository.insertAuthorityPrivilege(authorityPrivilege);
			logger.info("El registro no existia, por lo cual se inserto exitosamente...");
		}else {
			authorityPrivilegeRepository.updateAuthorityPrivilege(authorityPrivilege);
			logger.info("El registro se actualizo exitosamente...");
		}		
	}
	
}
