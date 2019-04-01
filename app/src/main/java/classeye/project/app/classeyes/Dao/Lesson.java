package classeye.project.app.classeyes.Dao;

public class Lesson {
    int id;
    String name;
    String ltime;
    String day;
    String unitcode;




    public Lesson(int id, String name, String ltime, String day, String unitcode) {
        this.id = id;
        this.name = name;
        this.ltime = ltime;
        this.day = day;
        this.unitcode = unitcode;
    }

    public Lesson(String name, String ltime, String day, String unitcode) {
        this.name = name;
        this.ltime = ltime;
        this.day = day;
        this.unitcode = unitcode;
    }

    public Lesson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLtime() {
        return ltime;
    }

    public void setLtime(String ltime) {
        this.ltime = ltime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }
}
