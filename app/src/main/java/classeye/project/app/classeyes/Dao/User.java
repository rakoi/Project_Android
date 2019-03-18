package classeye.project.app.classeyes.Dao;

public class User {

    public int id;
    public String admNo;
    public String password;
    public String firstName;
    public String lastName;
    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String admNo, String password) {
        this.admNo = admNo;
        this.password = password;
    }

    public User(int id, String admNo, String password) {
        this.id = id;
        this.admNo = admNo;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmNo() {
        return admNo;
    }

    public void setAdmNo(String admNo) {
        this.admNo = admNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
