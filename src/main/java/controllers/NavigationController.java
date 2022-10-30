package controllers;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@Data
@ManagedBean
public class NavigationController implements Serializable {

    public String goTo(String CategoryName){
        String pageName;

        switch(CategoryName){
            case "attraction":
                pageName="attractions";
                break;
            case "bibliotheque":
                pageName="bibliotheques";
                break;
            case "hopital":
                pageName="hopitaux";
                break;
            case "hotel":
                pageName="hotels";
                break;
            case "pharmacie":
                pageName="pharmacies";
                break;
            case "restaurant":
                pageName="restaurants";
                break;
            default:
                pageName=CategoryName;
                break;
        }
        return pageName;
    }

}
