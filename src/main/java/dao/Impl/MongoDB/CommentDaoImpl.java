package dao.Impl.MongoDB;

import dao.Interfaces.ICommentDao;
import entities.Comment;
import lombok.NoArgsConstructor;

// implementation pour MongoDB
@NoArgsConstructor
public class CommentDaoImpl implements ICommentDao {
    private String COLLECTION_NAME = "attractions";

    @Override
    public Comment findById(int id) {
        return null;
    }

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public void delete(Comment comment) {

    }
}
