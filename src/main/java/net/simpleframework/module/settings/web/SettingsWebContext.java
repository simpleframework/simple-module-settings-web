package net.simpleframework.module.settings.web;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.module.settings.impl.SettingsContext;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.common.element.AbstractElement;
import net.simpleframework.mvc.common.element.LinkElement;
import net.simpleframework.mvc.ctx.WebModuleFunction;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class SettingsWebContext extends SettingsContext implements ISettingsWebContext {

	public WebModuleFunction MY_PREFERENCES_FUNCTION = (WebModuleFunction) new WebModuleFunction()
			.setUrl(getUrlsFactory().getMyPreferencesUrl())
			.setName(MODULE_NAME + "-MySettingsTPage.java").setText($m("SettingsContext.1"))
			.setDisabled(true);

	@Override
	public AbstractElement<?> toMyPreferencesElement(final PageParameter pp) {
		return new LinkElement(MY_PREFERENCES_FUNCTION.getText()).setHref(MY_PREFERENCES_FUNCTION
				.getUrl());
	}

	@Override
	public SettingsUrlsFactory getUrlsFactory() {
		return singleton(SettingsUrlsFactory.class);
	}
}
