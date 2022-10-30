/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services.Interfaces;

import entities.Comment;
import java.util.List;

/**
 *
 * @author dell
 */
public interface ICommentService {
    public Comment findById(int id);
    public Comment save(Comment comment);
    public void delete(Comment comment);
}
