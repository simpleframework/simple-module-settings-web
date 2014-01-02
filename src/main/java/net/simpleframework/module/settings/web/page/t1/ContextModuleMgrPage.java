package net.simpleframework.module.settings.web.page.t1;

import java.io.IOException;
import java.util.Map;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.mvc.PageMapping;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ui.pager.AbstractTablePagerHandler;
import net.simpleframework.mvc.component.ui.pager.TablePagerBean;
import net.simpleframework.mvc.component.ui.pager.TablePagerColumn;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@PageMapping(url = "/settings/module/mgr")
public class ContextModuleMgrPage extends AbstractSettingsMgrPage {

	@Override
	protected void onForward(final PageParameter pp) {
		super.onForward(pp);

		final TablePagerBean tablePager = (TablePagerBean) addComponentBean(pp,
				"ContextModuleMgrPage_tbl", TablePagerBean.class).setContainerId(
				"idContextModuleMgrPage_tbl").setHandleClass(ContextModuleTable.class);

		tablePager.addColumn(new TablePagerColumn("ID").setWidth(80));
	}

	@Override
	protected String toHtml(final PageParameter pp, final Map<String, Object> variables,
			final String currentVariable) throws IOException {
		final StringBuilder sb = new StringBuilder();
		sb.append("<div align='center' class='ContextModuleMgrPage'>");
		sb.append("  <div id='idContextModuleMgrPage_tbl'></div>");
		sb.append("</div>");
		return sb.toString();
	}

	public static class ContextModuleTable extends AbstractTablePagerHandler {

		@Override
		public IDataQuery<?> createDataObjectQuery(final ComponentParameter cp) {
			return super.createDataObjectQuery(cp);
		}
	}
}