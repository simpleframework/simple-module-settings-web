package net.simpleframework.module.settings.web;

import net.simpleframework.module.settings.web.page.MySettingsTPage;
import net.simpleframework.module.settings.web.page.t2.MySettingsPage;
import net.simpleframework.mvc.AbstractMVCPage;
import net.simpleframework.mvc.common.UrlsCache;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class SettingsUrlsFactory extends UrlsCache {

	public String getMyPreferencesUrl() {
		return AbstractMVCPage.url(MySettingsPage.class);
	}

	public Class<? extends MySettingsTPage> getMyPreferences_IncludePage() {
		return MySettingsTPage.class;
	}
}
