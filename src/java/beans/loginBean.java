/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.util.PaginationHelper;
import entities.Address;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Named;
import lombok.Data;
import entities.UserEntity;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author BOUGARYTAMEGA
 */
@ManagedBean
public class loginBean implements Serializable{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
//     HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//     String txtProperty = request.getParameter("loginForm:username");
//    private UserEntity current = new UserEntity();
    Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    private final String email = params.get("email");
    private final String password = params.get("password");
    public void login(){
        System.out.println("Username: "+email+" && password is "+password);
    }
}
