package actions;

import java.util.List;

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

public class RetrieveAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynaValidatorForm dvf = (DynaValidatorForm) form;

		HttpSession session = request.getSession();
		String category = dvf.getString("Category");
		int id = (int) session.getAttribute("user_id");
		
		DatabaseAccess dao = new DatabaseAccess();
		dao.setup();
		List<PassInfo> info = dao.selectPassInfo(id, category);
		for(int count = 0; count<info.size();count++){
			info.get(count).getTitle();
			info.get(count).getUrl();
			info.get(count).getUsername();
			info.get(count).getPassword();
		}
		session.setAttribute("List", info);
		dao.close();
		
		
		return mapping.findForward("retrieve");
	}

}
