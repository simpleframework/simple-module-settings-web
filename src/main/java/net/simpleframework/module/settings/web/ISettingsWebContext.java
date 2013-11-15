package net.simpleframework.module.settings.web;

import net.simpleframework.module.settings.ISettingsContext;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.common.element.AbstractElement;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface ISettingsWebContext extends ISettingsContext {

	/**
	 * 定义我的偏好设置
	 * 
	 * @param pp
	 * @return
	 */
	AbstractElement<?> toMyPreferencesElement(PageParameter pp);

	SettingsUrlsFactory getUrlsFactory();
}
