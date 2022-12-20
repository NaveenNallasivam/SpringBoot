package com.avitam.application.service;

import com.avitam.application.model.Jspuser;
import com.avitam.application.model.UserData;

public interface JpaWebService {
	public boolean processlogin(String enteredPassword, String passwordinDB);

	public UserData modelDataConverter(Jspuser jspuser);

	Jspuser DatamodelConverter(UserData userData);
}
