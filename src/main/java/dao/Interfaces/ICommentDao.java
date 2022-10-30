package dao.Interfaces;

import entities.Comment;

public interface ICommentDao {
    public Comment findById(int id);
    public Comment save(Comment comment);
    public void delete(Comment comment);
}
