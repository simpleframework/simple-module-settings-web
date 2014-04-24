package net.simpleframework.module.settings.web.page.t1;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.module.settings.ISettingsContextAware;
import net.simpleframework.module.settings.web.ISettingsWebContext;
import net.simpleframework.module.settings.web.SettingsUrlsFactory;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.common.element.TabButton;
import net.simpleframework.mvc.common.element.TabButtons;
import net.simpleframework.mvc.template.t1.T1ResizedTemplatePage;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class AbstractSettingsMgrPage extends T1ResizedTemplatePage implements
		ISettingsContextAware {

	@Override
	protected void onForward(final PageParameter pp) {
		super.onForward(pp);

		pp.addImportCSS(AbstractSettingsMgrPage.class, "/settings.css");
	}

	@Override
	public String getRole(final PageParameter pp) {
		return settingsContext.getManagerRole();
	}

	@Override
	public TabButtons getTabButtons(final PageParameter pp) {
		return TabButtons.of(new TabButton($m("SettingsWebContext.0")).setHref(getUrlsFactory()
				.getUrl(pp, ModuleContextMgrPage.class)));
	}

	protected SettingsUrlsFactory getUrlsFactory() {
		return ((ISettingsWebContext) settingsContext).getUrlsFactory();
	}
}
