package actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import business.*;
public class RegisterAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

	DynaActionForm daf = (DynaActionForm)form;
		
	String fname = daf.getString("fname");
	String lname = daf.getString("lname");
	String username = daf.getString("username");
	String password = daf.getString("password");
	String mail = daf.getString("mail");
	String ssn = daf.getString("ssn");
		
	DatabaseAccess dao = new DatabaseAccess();
	dao.setup();
	PassUser pu = dao.selectPassUser();
	int user_id = pu.getTotalRows();
	++user_id;
	dao.insertPassUser(user_id, fname, lname, username, password, mail, ssn);
	return mapping.findForward("login");
	} 
	
}
