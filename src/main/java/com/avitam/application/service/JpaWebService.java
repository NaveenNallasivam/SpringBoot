package com.avitam.application.service;

import com.avitam.application.model.Jspuser;

public interface JpaWebService {
	public boolean processlogin(int uid, String password,Jspuser jspuser);
}
