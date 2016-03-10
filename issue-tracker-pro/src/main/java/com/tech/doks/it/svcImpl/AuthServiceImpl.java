package com.tech.doks.it.svcImpl;


import org.springframework.stereotype.Service;

import com.tech.doks.it.model.AuthStatus;
import com.tech.doks.it.svc.AuthService;
import com.tech.doks.it.token.CreateToken;

@Service
public class AuthServiceImpl implements AuthService {

	CreateToken createToken = null;
	String token = null;
	public AuthStatus authenticate(String username, String password) {

		System.out.println("Inside AuthServiceImpl authenticate ::");
		
		AuthStatus authStatus = new AuthStatus();
		if (username.equals("testuser") && password.equals("testpass")) {
			createToken = new CreateToken();
			token = createToken.createJWT(username, "ticketmanager", "issuetracker", 50000);
			authStatus.setAuthenticated(true);
			authStatus.setUserName(username);
			authStatus.setUserToken(token);
		} else {
			authStatus.setAuthenticated(false);
		}

		 return authStatus;
	}
}
