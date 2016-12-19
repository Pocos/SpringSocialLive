package org.springframework.social.live.api.impl;

import org.springframework.social.live.api.Live;
import org.springframework.social.live.api.UserOperations;
import org.springframework.social.live.api.onedrive.OneDriveOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

public class LiveTemplate extends AbstractOAuth2ApiBinding implements Live {

	private UserOperations userOperations;
	private OneDriveOperations onedriveOperations;

	public LiveTemplate() {
		initialize();
	}

	public LiveTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	@Override
	public OneDriveOperations onedriveOperations() {
		return onedriveOperations;
	}
	
	private void initialize() {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();

	}

	private void initSubApis() {
		userOperations = new UserTemplate(this, getRestTemplate(), isAuthorized());
	}

}
