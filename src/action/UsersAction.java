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
	//用户登录动作
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
	
	//注销登录
	@SkipValidation
	public String logout()
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	//登陆验证
	
	public void validate() {
		if("".equals(user.getUsername().trim())){
			this.addFieldError("userNameError", "用户名不能为空");
		}
		if(user.getPassword().length()<6){
			this.addFieldError("passwordError", "密码长度不能少于6位");
		}
	}

	public Users getModel() {
		return this.user;
	}
	
	

}
