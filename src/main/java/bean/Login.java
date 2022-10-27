///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package bean;
//
//import java.io.Serializable;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author dell
// */
//@ManagedBean
//public class Login implements Serializable{
//    private static final long serialVersionUID = 1094801825228386363L;
//    private String pwd;
//	private String msg;
//	private String user;
//
//	public String getPwd() {
//		return pwd;
//	}
//
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//
//	public String getMsg() {
//		return msg;
//	}
//
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
//
//	public String getUser() {
//		return user;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}
//
//	//validate login
//	public String validateUsernamePassword() {
//		boolean valid = LoginDAO.validate(user, pwd);
//		if (valid) {
//			HttpSession session = SessionUtils.getSession();
//			session.setAttribute("username", user);
//			return "admin";
//		} else {
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_WARN,
//							"Incorrect Username and Passowrd",
//							"Please enter correct username and Password"));
//			return "login";
//		}
//	}
//
//	//logout event, invalidate session
//	public String logout() {
//		HttpSession session = SessionUtils.getSession();
//		session.invalidate();
//		return "login";
//	}
//}
