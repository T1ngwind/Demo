package com.example.demo;

import java.io.Serializable;

/**User类，用于定义注册人的用户名和密码
 * @author Ting听
 * @version 1.0
 * @date 2020-08-16 19:06
 */
public class User  implements Serializable {
	String username;
	String password;

	public User(String username,String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
