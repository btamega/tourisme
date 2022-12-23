/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.NotificationEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Stateless
public class NotificationEntityFacade extends AbstractFacade<NotificationEntity> {

    @PersistenceContext(unitName = "recommandationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificationEntityFacade() {
        super(NotificationEntity.class);
    }
    
}
