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
 * @author dell
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Hopital {
    private String name;
    private String localisation;
    private String siteweb;
    private String telephone;
    private String type;
    private String image; 
}
