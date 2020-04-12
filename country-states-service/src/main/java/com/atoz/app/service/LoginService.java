package com.atoz.app.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginService {
	public boolean validateUser(String name, String pwd) {
		if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(pwd)) {
			return true;

		} else {
			return false;
		}
	}

}
