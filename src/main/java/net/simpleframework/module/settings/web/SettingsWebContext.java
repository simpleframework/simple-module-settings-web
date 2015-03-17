package net.simpleframework.module.settings.web;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ctx.ModuleFunctions;
import net.simpleframework.module.settings.impl.SettingsContext;
import net.simpleframework.module.settings.web.page.MySettingsTPage;
import net.simpleframework.module.settings.web.page.t1.ModuleContextMgrPage;
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
	protected ModuleFunctions getFunctions() {
		return ModuleFunctions.of(
				new WebModuleFunction(this)
						.setUrl(getUrlsFactory().getUrl(null, ModuleContextMgrPage.class))
						.setName(MODULE_NAME + "-ModuleContextMgrPage")
						.setText($m("SettingsWebContext.0")),
				new WebModuleFunction(this)
						.setUrl(getUrlsFactory().getUrl(null, MySettingsTPage.class))
						.setName(MODULE_NAME + "-MySettingsTPage").setText($m("SettingsWebContext.1"))
						.setDisabled(true));
	}

	@Override
	public AbstractElement<?> toMyPreferencesElement(final PageParameter pp) {
		final WebModuleFunction f = (WebModuleFunction) getFunctionByName(MODULE_NAME
				+ "-MySettingsTPage");
		return new LinkElement(f.getText()).setHref(f.getUrl());
	}

	@Override
	public SettingsUrlsFactory getUrlsFactory() {
		return singleton(SettingsUrlsFactory.class);
	}
}
