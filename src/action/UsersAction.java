package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOImpl;

public class UsersAction extends SuperAction implements ModelDriven<Users>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user=new Users();
	//�û���¼����
	public String login(){
		UsersDAO udao=new UsersDAOImpl();
		if(udao.login(user))
		{
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
			
		}
		
		else
		{
			return "login_failure";
		}
	}
	
	//ע����¼
	@SkipValidation
	public String logout()
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	//��½��֤
	
	public void validate() {
		if("".equals(user.getUsername().trim())){
			this.addFieldError("userNameError", "�û�������Ϊ��");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "���볤�Ȳ�������6λ");
		}
	}

	public Users getModel() {
		return this.user;
	}
	
	

}
