package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.validator.DynaValidatorForm;

import business.DatabaseAccess;
import business.PassUser;

public class LoginAction extends DispatchAction {

	public ActionForward Login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DynaValidatorForm dvf = (DynaValidatorForm) form;

		String username = dvf.getString("username");
		String password = dvf.getString("password");
		
		DatabaseAccess dao = new DatabaseAccess();
		HttpSession session = request.getSession();
		dao.setup();
		PassUser pu = dao.selectPassUser(username, password);
		dao.close();
		
		if(username.equals(pu.getUsername())) {
			
			if (password.equals(pu.getPassword())) {
				session.setAttribute("username", pu.getUsername());
				session.setAttribute("password", pu.getPassword());
				session.setAttribute("user_id", pu.getUser_id());
				return mapping.findForward("success");
			} else {
				return mapping.getInputForward();
			}

		} else {
			return mapping.getInputForward();
		}
	}
}