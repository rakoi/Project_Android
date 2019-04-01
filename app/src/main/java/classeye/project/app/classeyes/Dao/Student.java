package classeye.project.app.classeyes.Dao;

public class Student {

    int id;
    String admnumber;
    String firstname;
    String lastname;
    String password;

    public Student() {
    }

    public Student(String admnumber, String firstname, String lastname, String password) {
        this.admnumber = admnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public Student(int id, String admnumber, String firstname, String lastname, String password) {
        this.id = id;
        this.admnumber = admnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmnumber() {
        return admnumber;
    }

    public void setAdmnumber(String admnumber) {
        this.admnumber = admnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
