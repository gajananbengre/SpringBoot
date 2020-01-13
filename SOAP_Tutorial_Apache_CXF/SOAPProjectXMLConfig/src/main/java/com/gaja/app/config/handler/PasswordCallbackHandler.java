package com.gaja.app.config.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class PasswordCallbackHandler implements CallbackHandler {

	Map<String, String> passwords = new HashMap<>();
	
	
	public PasswordCallbackHandler() {
		passwords.put("gaja", "password");
	}


	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		
		for(Callback callback : callbacks) {
			WSPasswordCallback pc = (WSPasswordCallback) callback;
			String password = passwords.get(pc.getIdentifier());
			pc.setPassword(password);
			return;	
		}

	}

}
