package classeye.project.app.classeyes;

public class AttendanceRecord {
    public String unitCode;
    public String lecturer;
    public String UnitName;
    public String attendance;

    public AttendanceRecord(String unitCode, String lecturer, String unitName, String attendance) {
        this.unitCode = unitCode;
        this.lecturer = lecturer;
        UnitName = unitName;
        this.attendance = attendance;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
