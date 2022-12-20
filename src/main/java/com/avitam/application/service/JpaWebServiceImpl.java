package com.avitam.application.service;

import com.avitam.application.model.Jspuser;
import com.avitam.application.model.UserData;

public class JpaWebServiceImpl implements JpaWebService {

	@Override
	public boolean processlogin(String enteredPassword, String passwordinDB) {
		// TODO Auto-generated method stub
		if (enteredPassword.trim().equals(passwordinDB.trim())) {
			return true;
		}
		return false;
	}

	@Override
	public UserData modelDataConverter(Jspuser jspuser) {
		// TODO Auto-generated method stub
		UserData userData = new UserData();
		userData.setUserId(jspuser.getUserId());
		userData.setFirstName(jspuser.getFirstName());
		userData.setLastName(jspuser.getLastName());
		userData.setEmail(jspuser.getEmail());
		userData.setPassword(jspuser.getPassword());
		return userData;
	}

	@Override
	public Jspuser DatamodelConverter(UserData userData) {
		Jspuser jspUser = new Jspuser();
		jspUser.setUserId(userData.getUserId());
		jspUser.setFirstName(userData.getFirstName());
		jspUser.setLastName(userData.getLastName());
		jspUser.setEmail(userData.getEmail());
		jspUser.setPassword(userData.getPassword());
		return jspUser;
	}

}
