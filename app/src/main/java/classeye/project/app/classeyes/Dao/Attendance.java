package classeye.project.app.classeyes.Dao;


public class Attendance  {

    int id;
    String time;
    Student student;
    Lesson lesson;

    public Attendance() {
    }

    public Attendance(int id, String time, Student student, Lesson lesson) {
        this.id = id;
        this.time = time;
        this.student = student;
        this.lesson = lesson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

}
