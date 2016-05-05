package fr.ipst.cnam.managedBeansDialog;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import fr.ipst.cnam.controllers.ControlPrivilege;
import fr.ipst.cnam.entities.User;

@ManagedBean(name="loginService")
@RequestScoped
public class Login {
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean; 
	
	private String login = "";
	
	private String passwd = "";
	
	private boolean loginState = false;

	public String checkLoginState()
	{
		if(isLoginState() == false)
		{
			return "ko";
		}
		return "OK";
	}
	
	 public String login()
	{
		
		ControlPrivilege control = new ControlPrivilege();
		User user = control.login(this.login, this.passwd);
		
		if(user == null)
		{
			FacesMessage msg = new FacesMessage("Échec de l'authentification, réessayez.");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
			return "KO";
		}
		else
		{
			userBean.setUser(user);
			
			return "OK";
		}
	}
	 
	 
	
	public String logout()
	{
		userBean.setUser(null);
		return "OK";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean isLoginState() {
		return loginState;
	}

	public void setLoginState(boolean loginState) {
		this.loginState = loginState;
	}
	public void save() {
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
		if(this.login.equals("Yassine") && this.passwd.equals("Yadine"))
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Succès"));
		}
		else
		{
			 FacesMessage msg = new FacesMessage("Échec de l'authentification, réessayez.");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
    }
     
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }
     
    public void resetFail() {
        this.login = null;
        this.passwd = null;
         
        FacesMessage msg = new FacesMessage("Model reset, but it won't work properly.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	
	
	
}
