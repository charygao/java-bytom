package io.bytom.api;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class BasisModel {
	private static final String UTF_8 = "UTF-8";
	
	private String url;

	private String username;
	private String password;

	private String authorization;
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public void setAuthorization(String username, String password) {
		String encoding = "";
		try {
			encoding = new String(Base64.encodeBase64((username + ":" + password).getBytes(UTF_8)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.authorization = "Basic " + encoding;
	}

}