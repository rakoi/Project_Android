package classeye.project.app.classeyes.apiClients;

import classeye.project.app.classeyes.Dao.Attendance;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CheckInApiLessonInterface {

    @GET("{id}/{lessonName}")
    Call<Attendance> checkIn(@Path("id")int id,@Path("lessonName")String lessonName);
}
