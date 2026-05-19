package kg.db.beans;

import kg.db.db_utils.DB_Connection;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Actor {

    Integer actor_id;
    String first_name;
    String last_name;
    String last_update;

    public static List<Actor> getAllActors() throws SQLException {
        String query = "select * from actor";
        try(ResultSet resultSet = DB_Connection.makeQuery(query)){
            return new BeanProcessor().toBeanList(resultSet, Actor.class);
        }
    }

    public static Actor getBy(String column, int value) throws SQLException {
        String query = "select * from actor where " + column + "=?; ";
        ResultSet resultSet = DB_Connection.makeQuery(query, value);
        if (!resultSet.next()){
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, Actor.class);
        }
    }

    public static Actor insert(String firstName, String lastName) throws SQLException {
        String query = "INSERT INTO actor (first_name, last_name, last_update) VALUES (?, ?, NOW())";
        DB_Connection.executeUpdate(query, firstName, lastName);

        String fetchQuery = "SELECT * FROM actor WHERE first_name = ? AND last_name = ? ORDER BY actor_id DESC LIMIT 1";
        try (ResultSet resultSet = DB_Connection.makeQuery(fetchQuery, firstName, lastName)) {
            if (!resultSet.next()) return null;
            return new BeanProcessor().toBean(resultSet, Actor.class);
        }
    }

//    public static Actor update(int actorId, String firstName, String lastName) throws SQLException {
//        String query = "UPDATE actor SET first_name = ?, last_name = ?, last_update = NOW() WHERE actor_id = ?";
//        int rowsAffected = DB_Connection.executeUpdate(query, firstName, lastName, actorId);
//        if (rowsAffected == 0) return null;
//
//        String fetchQuery = "SELECT * FROM actor WHERE actor_id = ?";
//        try (ResultSet resultSet = DB_Connection.makeQuery(fetchQuery, actorId)) {
//            if (!resultSet.next()) return null;
//            return new BeanProcessor().toBean(resultSet, Actor.class);
//        }
//    }

    public static Actor update(int actorId, String firstName, String lastName) throws SQLException {
        String sql = "UPDATE actor SET first_name = ?, last_name = ?, last_update = NOW() WHERE actor_id = ?";

        PreparedStatement ps = DB_Connection.getConnection().prepareStatement(sql);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setInt(3, actorId);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected == 0) {
            return null; // <-- this is what's happening: no row found with actor_id=203
        }

        return getBy("actor_id", actorId); // fetch and return updated actor
    }

//    public static boolean delete(int actorId) throws SQLException {
//        String query = "DELETE FROM actor WHERE actor_id = ?";
//        return DB_Connection.executeUpdate(query, actorId) > 0;
//    }

    public static boolean delete(int actorId) throws SQLException {
    // First remove all film_actor references
    String deleteFilmActor = "DELETE FROM film_actor WHERE actor_id = ?";
    DB_Connection.executeUpdate(deleteFilmActor, actorId);

    // Then delete the actor
    String deleteActor = "DELETE FROM actor WHERE actor_id = ?";
    return DB_Connection.executeUpdate(deleteActor, actorId) > 0;
}
}
