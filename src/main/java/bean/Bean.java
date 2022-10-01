/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import tamega.attractions.Attractions;
import tamega.attractions.Site;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Named
@RequestScoped
public class Bean {
    private final File file = new File("/WEB-INF/ressources.xml");
    private JAXBContext jaxb; // Can be application scoped. It's thread safe.
    private List<Site> sites;
    
   
    @PostConstruct
    public void init()  {
         try {
             jaxb = JAXBContext.newInstance(Site.class);
             sites = ((Attractions) jaxb.createUnmarshaller().unmarshal(file)).getList();
             System.out.println(" File size : "+sites.size());
         } catch (JAXBException ex) {
             Logger.getLogger(Bean.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    public void save() throws JAXBException {
        jaxb.createMarshaller().marshal(new Attractions(sites), file);
    }

    public List<Site> getSites() { 
        return sites;
    }
}
