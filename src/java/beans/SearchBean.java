/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Named("SearchBean")
@SessionScoped
public class SearchBean implements Serializable{

    public void search() {
        System.out.println("beans.SearchBean.search()");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
