/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

/**
 *
 * @author dell

import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import static org.neo4j.driver.Values.parameters;

public class HelloWorldExample implements AutoCloseable {
    private final Driver driver;

    public HelloWorldExample(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    @Override
    public void close() throws RuntimeException {
        driver.close();
    }

    @SuppressWarnings("deprecation")
    public void printGreeting(final String message) {
        
        String noeud = "user";
        List<String> tab = new ArrayList<>();
        try (Session session = driver.session()) {
            tab.add(noeud);
            tab.add(message);
            Result greeting = session.run(
                        "CREATE (a:"+noeud+") " + "SET a.message = $message "
                                + "RETURN a.message + ', from node ' + id(a)",
                        parameters("message", message)
            );
                
           
            System.out.println(greeting);
        }
    }
    
    @SuppressWarnings("deprecation")
    public Result getData(String name, String noeud) {
        // MATCH (n:Restaurant) WHERE n.name="VIAVIA" RETURN n
        Result data = null;
        try (Session session = driver.session()) {
            data = session.run(
                        "MATCH (n:" +noeud+ ") WHERE n.name=$name" 
                                + "RETURN n",
                        parameters("name", name)
            );
                
           
            System.out.println(data);
        }
        return data;
    }

    public static void main(String... args) throws Exception {
        try (
            HelloWorldExample greeter = new HelloWorldExample("bolt://localhost:7687", "neo4j", "azerty")) {
            greeter.printGreeting("Irisi");
            System.out.println("------------->MAIN CREATE NODE");
        }
    }
} */
