package classeye.project.app.classeyes.apiClients;

import java.util.List;

import classeye.project.app.classeyes.Dao.Lesson;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrentLessonInterface {

    @GET("getlesson")
    Call<Lesson>getLesson();
}
