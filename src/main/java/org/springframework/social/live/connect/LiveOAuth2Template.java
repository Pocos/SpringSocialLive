package org.springframework.social.live.connect;

import org.springframework.social.oauth2.OAuth2Template;

public class LiveOAuth2Template extends OAuth2Template  {

	private static String AUTHORIZE_URL = "https://login.live.com/oauth20_authorize.srf";
	private static String ACCESS_TOKEN_URL = "https://login.live.com/oauth20_token.srf";
	
	/**
	 * @param clientId
	 * @param clientSecret
	 */
	public LiveOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret,AUTHORIZE_URL, ACCESS_TOKEN_URL);
		setUseParametersForClientAuthentication(true);
	}
}



