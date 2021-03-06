 /**
 * 文件名称：
 * 版权所有：Copyright gesoft
 * 创建时间：2017-06-28 11:50:08
 * 创 建 人：WCL (ln_admin@yeah.net)
 * 功能描述：
 **/
package com.gesoft.model;

import java.util.*;


public class UserModel extends BaseModel
{
	private static final long serialVersionUID = 5454155825314635342L;

	
	private java.lang.Long id;
	private java.lang.String userName;
	private java.lang.String userPwd;
	private java.lang.String realName;
	private java.lang.Integer roleId;
	private java.lang.String position;
	private java.lang.String tel;
	private java.lang.String memo;
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public UserModel setRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public void setId(java.lang.Long value)
	{
		this.id = value;
	}
	
	public java.lang.Long getId() 
	{
		return this.id;
	}
	public void setUserName(java.lang.String value) 
	{
		this.userName = value;
	}
	
	public java.lang.String getUserName() 
	{
		return this.userName;
	}
	public void setUserPwd(java.lang.String value) 
	{
		this.userPwd = value;
	}
	
	public java.lang.String getUserPwd() 
	{
		return this.userPwd;
	}
	public void setRealName(java.lang.String value) 
	{
		this.realName = value;
	}
	
	public java.lang.String getRealName() 
	{
		return this.realName;
	}
	public void setRoleId(java.lang.Integer value) 
	{
		this.roleId = value;
	}
	
	public java.lang.Integer getRoleId() 
	{
		return this.roleId;
	}
	public void setPosition(java.lang.String value) 
	{
		this.position = value;
	}
	
	public java.lang.String getPosition() 
	{
		return this.position;
	}
	public void setTel(java.lang.String value) 
	{
		this.tel = value;
	}
	
	public java.lang.String getTel() 
	{
		return this.tel;
	}
	public void setMemo(java.lang.String value) 
	{
		this.memo = value;
	}
	
	public java.lang.String getMemo() 
	{
		return this.memo;
	}

}

