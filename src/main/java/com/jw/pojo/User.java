package com.jw.pojo;

import java.io.Serializable;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String password;
	private String salt;
	private Boolean locked = Boolean.FALSE;
	
	public User(){		
		
	}
	public User(String userName,String password){
		this.userName=userName;
		this.password=password;
	}
	
	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", locked=" + locked +
                '}';
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	
	

}
