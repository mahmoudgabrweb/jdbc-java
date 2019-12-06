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
        String query = "SELECT * FROM users ORDER BY id DESC LIMIT 20";
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
                usersList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }
    
    public boolean saveUser(User user) {
        
        String query = "INSERT INTO users(name,age,address,job,nationality,username,password) "
                + "VALUES('" + user.getName() + "', " + user.getAge() + ",'" + user.getAddress() + "','" + user.getJob()
                + "','" + user.getNationality() + "','" + user.getUsername() + "','" + user.getPassword() + "')";

         try {
            st = connect.prepareStatement(query);
            int result = st.executeUpdate();
            st.close();
            return (result == 1);
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
