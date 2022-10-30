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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attraction {
    private String type;
    private String name;
    private String description;
    private String localisation;
}
