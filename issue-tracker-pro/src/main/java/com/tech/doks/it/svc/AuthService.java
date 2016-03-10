package com.tech.doks.it.svc;

import com.tech.doks.it.model.AuthStatus;


public interface AuthService {

	public AuthStatus authenticate(String username, String password);

}
