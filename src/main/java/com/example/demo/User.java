package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int id_user;
	private String email_user;
	private String token_user;
	private String password_user;
	
	public int getIdUser()
	{
		return id_user;
	}
	
	public String getEmailUser()
	{
		return email_user;
	}
	
	public String getTokenUser()
	{
		return token_user;
	}
	
	public String getPasswordUser()
	{
		return password_user;
	}
	
	public void setIdUser(int id_user)
	{
		this.id_user = id_user;
	}
	
	public void setEmailUser(String email_user)
	{
		this.email_user = email_user;
	}
	
	public void setTokenUser(String token_user)
	{
		this.token_user = token_user;
	}
	
	public void setPasswordUser(String password_user)
	{
		this.password_user = password_user;
	}
}
