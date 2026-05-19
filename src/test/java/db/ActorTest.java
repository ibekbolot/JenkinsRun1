package db;

import kg.db.beans.Actor;
import kg.db.db_utils.DB_Connection;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("UI")
//public class ActorTest {

//    @Test
//    void actorTest() throws SQLException {
//        DB_Connection.openConnection("dvdRental");
//        Actor.getAllActors().forEach(System.out::println);
//        Actor actor = Actor.getBy("actor_id", 1);
//        System.out.println(actor);
//    }
//
//    @Test
//    public void testInsert() throws SQLException {
//        DB_Connection.openConnection("dvdRental");
//        Actor newActor = Actor.insert("John", "Doe");
//        assertNotNull(newActor);
//        assertEquals("John", newActor.getFirst_name());
//        assertEquals("Doe", newActor.getLast_name());
//    }
//
//    @Test
//    public void testUpdate() throws SQLException {
//        DB_Connection.openConnection("dvdRental");
//        Actor updated = Actor.update(203, "Jane", "Smith");
//        assertNotNull(updated);
//        assertEquals("Jane", updated.getFirst_name());
//    }
//
//    @Test
//    public void testDelete() throws SQLException {
//        DB_Connection.openConnection("dvdRental");
//        boolean deleted = Actor.delete(203);
//        assertTrue(deleted);
//    }
// }

@Tag("UI")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActorTest {

    static int insertedActorId; // shared between tests

    @Test
    @Order(1)
    void actorTest() throws SQLException {
        DB_Connection.openConnection("dvdRental");
        Actor.getAllActors().forEach(System.out::println);
        Actor actor = Actor.getBy("actor_id", 1);
        System.out.println(actor);
    }

    @Test
    @Order(2)
    public void testInsert() throws SQLException {
        DB_Connection.openConnection("dvdRental");
        Actor newActor = Actor.insert("John", "Doe");
        assertNotNull(newActor);
        assertEquals("John", newActor.getFirst_name());
        assertEquals("Doe", newActor.getLast_name());

        insertedActorId = newActor.getActor_id(); // save ID for next tests
        System.out.println("Inserted actor_id: " + insertedActorId);
    }

    @Test
    @Order(3)
    public void testUpdate() throws SQLException {
        DB_Connection.openConnection("dvdRental");
        Actor updated = Actor.update(insertedActorId, "Jane", "Smith"); // use real ID
        assertNotNull(updated);
        assertEquals("Jane", updated.getFirst_name());
        assertEquals("Smith", updated.getLast_name());
    }

    @Test
    @Order(4)
    public void testDelete() throws SQLException {
        DB_Connection.openConnection("dvdRental");
        boolean deleted = Actor.delete(insertedActorId); // use real ID
        assertTrue(deleted);
    }
}
