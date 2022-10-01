/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tamega.attractions;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BOUGARYTAMEGA
 */
@XmlRootElement
public class Attractions {
    @XmlElement(name="site") // Name must thus match <fruit>. We could also make the property name "fruit" so that we can omit @XmlElement, but a getFruit() method returning a list of fruits isn't self-documenting.
    private List<Site> list;

    public Attractions() {
        // Keep default c'tor alive.
    }

    public Attractions(List<Site> list) {
        this.list = list;
    }

    public List<Site> getList() { 
        return list;
    }

}
