package com.softtek.acceleo.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_authority")
public class UserAuthority {
    @Id
    @Column(name = "ID_USER_AUTH")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUserAuthority;
		
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER")
	private User idUser;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AUTHORITY")
	private Authority idAuthority;
	
	public User getIdUser() {
		return idUser;
	}
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	public Authority getIdAuthority() {
		return idAuthority;
	}
	public void setIdAuthority(Authority idAuthority) {
		this.idAuthority = idAuthority;
	}
	
    public long getIdUserAuthority() {
		return idUserAuthority;
	}
	public void setIdUserAuthority(long idUserAuthority) {
		this.idUserAuthority = idUserAuthority;
	}

	
	
}
