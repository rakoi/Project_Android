package classeye.project.app.classeyes.apiClients;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChartAPInterface {

    @GET("getAttendace/1")
    Call<HashMap<String,Integer>>getAttendanceRecords();
}
