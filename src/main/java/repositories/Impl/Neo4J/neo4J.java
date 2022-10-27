/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories.Impl.Neo4J;

//import Connection.DbNeo4J;

/**
 *
 * @author dell

public class neo4J implements AutoCloseable {
    private final Driver driver;

    public neo4J(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    @Override
    public void close() throws RuntimeException {
        driver.close();
    }
    
    // return all categories
    @SuppressWarnings("deprecation")
    public List<String> getCategories() {
        List<String> data = new ArrayList<>();
        try (Session session = driver.session()) {
            Result res = session.run(
                        "MATCH (n:Category) RETURN n.name"
            );
            
            while(res.hasNext()){
                data.add(res.next().get(0).asString());
            }
                
        }
        return data;
        
    }

    // retourner un noeud à partir de son nom
    @SuppressWarnings("deprecation")
    public List<String> getData(String name, String noeud) {
        // MATCH (n:Restaurant) WHERE n.name="VIAVIA" RETURN n
        List<String> data = new ArrayList<>();
        try (Session session = driver.session()) {
            Result res = session.run(
                        "MATCH (n:" +noeud+ ") WHERE n.name=$name RETURN n",
                        parameters("name", name)
            );
            
            while(res.hasNext()){
                data.add(res.next().get(0).asString());
            }
                
        }
        return data;
    }
    

    public static void main(String... args) throws Exception {
        try (
            neo4J db = new neo4J("bolt://localhost:7687", "neo4j", "azerty")) {
            System.out.println("-------------> MAIN");
            List<String> res = db.getCategories();
            for(String item : res){
                System.out.println("-------------> " + item);
            }
            
            
        }
    }
} */