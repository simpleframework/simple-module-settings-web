package net.simpleframework.module.settings.web.page.t1;

import static net.simpleframework.common.I18n.$m;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.ado.query.ListDataQuery;
import net.simpleframework.common.BeanUtils;
import net.simpleframework.ctx.IModuleContext;
import net.simpleframework.ctx.Module;
import net.simpleframework.ctx.ModuleContextFactory;
import net.simpleframework.mvc.PageMapping;
import net.simpleframework.mvc.PageParameter;
import net.simpleframework.mvc.common.element.ETextAlign;
import net.simpleframework.mvc.component.ComponentParameter;
import net.simpleframework.mvc.component.ui.pager.AbstractTablePagerHandler;
import net.simpleframework.mvc.component.ui.pager.EPagerBarLayout;
import net.simpleframework.mvc.component.ui.pager.TablePagerBean;
import net.simpleframework.mvc.component.ui.pager.TablePagerColumn;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
@PageMapping(url = "/settings/module/mgr")
public class ModuleContextMgrPage extends AbstractSettingsMgrPage {

	@Override
	protected void onForward(final PageParameter pp) {
		super.onForward(pp);

		final TablePagerBean tablePager = (TablePagerBean) addComponentBean(pp,
				"ModuleContextMgrPage_tbl", TablePagerBean.class)
				.setPagerBarLayout(EPagerBarLayout.none).setContainerId("idModuleContextMgrPage_tbl")
				.setHandlerClass(ContextModuleTable.class);
		tablePager
				.addColumn(
						new TablePagerColumn("name", "ID", 180).setTextAlign(ETextAlign.left).setSort(
								false))
				.addColumn(
						new TablePagerColumn("text", $m("ModuleContextMgrPage.0"), 180).setTextAlign(
								ETextAlign.left).setSort(false))
				.addColumn(new TablePagerColumn("version", $m("ModuleContextMgrPage.1"), 55))
				.addColumn(new TablePagerColumn("order", $m("ModuleContextMgrPage.2"), 65))
				.addColumn(
						new TablePagerColumn("context", $m("ModuleContextMgrPage.3")).setTextAlign(
								ETextAlign.left).setSort(false))
				.addColumn(TablePagerColumn.OPE().setWidth(80));
	}

	@Override
	protected String toHtml(final PageParameter pp, final Map<String, Object> variables,
			final String currentVariable) throws IOException {
		final StringBuilder sb = new StringBuilder();
		sb.append("<div align='center' class='ModuleContextMgrPage'>");
		sb.append("  <div id='idModuleContextMgrPage_tbl'></div>");
		sb.append("</div>");
		return sb.toString();
	}

	public static class ContextModuleTable extends AbstractTablePagerHandler {

		@Override
		public IDataQuery<?> createDataObjectQuery(final ComponentParameter cp) {
			final ListDataQuery<Map<String, Object>> dq = new ListDataQuery<Map<String, Object>>();
			final List<Map<String, Object>> coll = dq.list();
			for (final IModuleContext ctx : ModuleContextFactory.allModules()) {
				final Module module = ctx.getModule();
				final Map<String, Object> map = BeanUtils.toMap(module);
				map.put("context", ctx.getClass().getName());
				coll.add(map);
			}
			return dq;
		}
	}
}