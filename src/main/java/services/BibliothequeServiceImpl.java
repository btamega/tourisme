/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Bibliotheque;
import java.util.List;
import javax.inject.Inject;
import repositories.MongoDB.BibliothequeRepository;

/**
 *
 * @author dell
 */
public class BibliothequeServiceImpl implements BibliothequeService{
    @Inject
    private BibliothequeRepository bibliothequeRepository;

    @Override
    public List<Bibliotheque> getBibliotheques() {
        return bibliothequeRepository.findAll(); 
    }
    
}
