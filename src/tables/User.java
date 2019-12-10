package tables;

/**
 *
 * @author mahmoudgabr
 */
public class User {

    private int id;
    private int age;
    private String name;
    private String address;
    private String job;
    private String nationality;
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

    public User(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
