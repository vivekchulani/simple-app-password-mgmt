package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import business.DatabaseAccess;
import business.PassInfo;

public class AddAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynaValidatorForm dvf = (DynaValidatorForm)form;
		HttpSession session = request.getSession();
		
		String title = dvf.getString("title");
		String url = dvf.getString("url");
		String username = dvf.getString("username");
		String password = dvf.getString("password");
		String category = dvf.getString("Category");
		int id = (int) session.getAttribute("user_id");

		DatabaseAccess dao = new DatabaseAccess();
		dao.setup();
		PassInfo pi = dao.selectPassInfo();
		int info_id = pi.getTotalRows();
		info_id++;
		dao.insertPassInfo(info_id, title, url, username, password, category,id);
	return mapping.findForward("confirm");
	}
	
	
}
