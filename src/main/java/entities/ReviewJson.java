/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import lombok.Data;

/**
 *
 * @author BOUGARYTAMEGA
 */
@Data
public class ReviewJson {
    private long reviewId;
    private String review;
    private Rating rating;
    private Critic critic;
    private Long id;
    private String title;
    private String posterUrl;
}
