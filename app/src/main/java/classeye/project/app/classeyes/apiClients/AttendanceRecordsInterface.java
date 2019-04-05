package classeye.project.app.classeyes.apiClients;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AttendanceRecordsInterface {


    @GET("getAttendace/{id}")
    Call<HashMap<String,Integer>> getAttendanceRecord(@Path("id")int id);
}
