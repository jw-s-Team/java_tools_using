package com.jw.pojo;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class User {
    private Long userId;
    private String userName;
    private String password;
    private String salt;
    private Date createTime;
    private Date lastModifyTime;
    private String remark;
    



	public Long getUserId() {
		return userId;
	}




	public void setUserId(Long userId) {
		this.userId = userId;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
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



	@Temporal(TemporalType.TIMESTAMP)  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}




	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	@Temporal(TemporalType.TIMESTAMP)  
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getLastModifyTime() {
		return lastModifyTime;
	}




	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}




	public String getRemark() {
		return remark;
	}




	public void setRemark(String remark) {
		this.remark = remark;
	}




	public String toString(){
    	return "【User】:userId="+userId+",userName="+userName
    			+",password="+password+",salt="+salt+",createTime="
    			+createTime+",lastModifyTime="+lastModifyTime
    			+",remark="+remark;
    }
}