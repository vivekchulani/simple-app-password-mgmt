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
import business.PassUser;

public class ForgetAction extends Action{

@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

	DynaValidatorForm dvf = (DynaValidatorForm)form;
	HttpSession session = request.getSession();
	String ssn = dvf.getString("ssn");
	
	DatabaseAccess dao = new DatabaseAccess();
	
	dao.setup();
	PassUser pu = dao.returnPassword(ssn);
	session.setAttribute("password", pu.getPassword());
	return mapping.findForward("return");
}	
	
	
}
