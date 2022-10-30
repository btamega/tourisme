package dao.Impl.Neo4J;

import connections.Connection;
import dao.Interfaces.ICommentDao;
import entities.Bibliotheque;
import entities.Comment;
import lombok.NoArgsConstructor;
import mappers.ObjectGraphMapper;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;


// implémentation pour NEO4J
@NoArgsConstructor
public class CommentDaoImpl implements ICommentDao {
    private static final Driver driver= Connection.ConnectToNeo4j();

    @Override
    public Comment findById(int id)  {
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
