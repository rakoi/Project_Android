package classeye.project.app.classeyes.apiClients;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ChartAPInterface {

    @GET("getAttendace/{id}")
    Call<HashMap<String,Integer>>getAttendanceRecords(@Path("id")int id);
}
