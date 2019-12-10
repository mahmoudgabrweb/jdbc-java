package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tables.User;

/**
 *
 * @author mahmoudgabr
 */
public class UserService extends AppService {

    public UserService(Connection connect) {
        super(connect);
    }

    public ArrayList<User> fetchUsers() {
        ArrayList<User> usersList = new ArrayList<>();
        String query = "SELECT * FROM users ORDER BY id ASC LIMIT 20";
        try {
            st = connect.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            User user;
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String job = resultSet.getString("job");
                String username = resultSet.getString("username");
                String nationality = resultSet.getString("nationality");
                user = new User(age, name, address, job, nationality, username);
                user.setId(id);
                user.setPassword(resultSet.getString("password"));
                usersList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }

    public User showUser(int id) {
        String query = "SELECT username FROM users WHERE id = " + id;
        User user = null;
        try {
            st = connect.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.first()) {
                user = new User(resultSet.getString("username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public boolean saveUser(User user) {

        String query = "INSERT INTO users(name,age,address,job,nationality,username,password) "
                + "VALUES('" + user.getName() + "', " + user.getAge() + ",'" + user.getAddress() + "','" + user.getJob()
                + "','" + user.getNationality() + "','" + user.getUsername() + "','" + user.getPassword() + "')";

        return applyQuery(query);
    }

    public boolean updateUser(User user) {

        String query = "Update users SET name='" + user.getName() + "', age='" + user.getAge() + "', address='" + user.getAddress() + "', "
                + "job='" + user.getJob() + "', nationality='" + user.getNationality() + "', username='" + user.getUsername() + "'";

        if (!user.getPassword().equals("")) {
            query += ", password='" + user.getPassword() + "'";
        }

        query += " WHERE id=" + user.getId();

        return applyQuery(query);
    }

    public boolean deleteUser(int id) {

        String query = "DELETE FROM users WHERE id = " + id;

        return applyQuery(query);
    }

    private boolean applyQuery(String query) {
        try {
            st = connect.prepareStatement(query);
            int result = st.executeUpdate();
            st.close();
            return (result == 1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
