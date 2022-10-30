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
 * @author dell
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Restaurant {
    private String name;
    private String image;
    private String localisation;
    private String telephone;
    private String ouverture;
    private String description;
    private String siteweb;
    private List<Comment> comments;
}
