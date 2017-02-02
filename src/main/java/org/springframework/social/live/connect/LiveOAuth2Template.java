package org.springframework.social.live.connect;

import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
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
	
	/* (non-Javadoc)
	 * @see org.springframework.social.oauth2.OAuth2Template#buildAuthorizeUrl(org.springframework.social.oauth2.GrantType, org.springframework.social.oauth2.OAuth2Parameters)
	 */
	@Override
	public String buildAuthorizeUrl(GrantType grantType, OAuth2Parameters parameters) {
		parameters.setScope("wl.skydrive_update,wl.skydrive,wl.offline_access,onedrive.readwrite");
		return super.buildAuthorizeUrl(grantType, parameters);
	}
	
	
}



