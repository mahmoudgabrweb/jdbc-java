package tables;

/**
 *
 * @author mahmoudgabr
 */
public class User {

    private final int age;
    private final String name;
    private final String address;
    private final String job;
    private final String nationality;
    private final String username;
    private String password;

    public User(int age, String name, String address, String job, String nationality, String username) {        
        this.age = age;
        this.name = name;
        this.address = address;
        this.job = job;
        this.nationality = nationality;
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    public String getNationality() {
        return nationality;
    }

    public String getUsername() {
        return username;
    }


}
