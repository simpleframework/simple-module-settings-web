package net.simpleframework.module.settings.web.page.t2;

import java.io.IOException;
import java.util.Map;

import net.simpleframework.module.settings.ISettingsContextAware;
import net.simpleframework.module.settings.web.ISettingsWebContext;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.template.t2.T2TemplatePage;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class MySettingsPage extends T2TemplatePage implements ISettingsContextAware {

	@Override
	protected String toHtml(final PageParameter pp, final Map<String, Object> variables,
			final String currentVariable) throws IOException {
		return pp.includeUrl(((ISettingsWebContext) context).getUrlsFactory()
				.getMyPreferences_IncludePage());
	}
}
