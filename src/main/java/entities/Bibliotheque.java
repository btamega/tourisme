/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author KANNOUFA
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Bibliotheque {
    private String name;
    private String localisation;
    private String siteweb;
    private String telephone;
    private String email;
}