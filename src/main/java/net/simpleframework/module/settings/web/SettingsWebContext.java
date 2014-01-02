package net.simpleframework.module.settings.web;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ctx.Module;
import net.simpleframework.ctx.ModuleFunctions;
import net.simpleframework.module.settings.impl.SettingsContext;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.common.element.AbstractElement;
import net.simpleframework.mvc.common.element.LinkElement;
import net.simpleframework.mvc.ctx.WebModuleFunction;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class SettingsWebContext extends SettingsContext implements ISettingsWebContext {

	@Override
	protected Module createModule() {
		return super.createModule().setDefaultFunction(null);
	}

	@Override
	protected ModuleFunctions getFunctions() {
		return ModuleFunctions.of(FUNC_MY_SETTINGS);
	}

	@Override
	public AbstractElement<?> toMyPreferencesElement(final PageParameter pp) {
		return new LinkElement(FUNC_MY_SETTINGS.getText()).setHref(FUNC_MY_SETTINGS.getUrl());
	}

	@Override
	public SettingsUrlsFactory getUrlsFactory() {
		return singleton(SettingsUrlsFactory.class);
	}

	public final WebModuleFunction FUNC_MY_SETTINGS = (WebModuleFunction) new WebModuleFunction()
			.setUrl(getUrlsFactory().getMyPreferencesUrl()).setName(MODULE_NAME + "-MySettingsTPage")
			.setText($m("SettingsContext.1")).setDisabled(true);
}
