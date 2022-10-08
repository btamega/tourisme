/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Site {
    private String name;
    private List<Images> images;
    private String description;
    private String localisation;
//    private Affluence affluence;
//    private String hauteur;
//    private String billet;
//    private String superficie;
}