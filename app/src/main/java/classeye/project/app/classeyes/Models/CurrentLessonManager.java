package classeye.project.app.classeyes.Models;

import android.content.Context;
import android.widget.Toast;
import classeye.project.app.classeyes.Contracts.CurrentLessonContract;
import classeye.project.app.classeyes.Dao.Lesson;
import classeye.project.app.classeyes.MySingleton;
import classeye.project.app.classeyes.apiClients.CurrentLessonApiClient;
import classeye.project.app.classeyes.apiClients.CurrentLessonInterface;
import retrofit2.Call;
import retrofit2.Callback;

public class CurrentLessonManager implements CurrentLessonContract.Model {

    //public String url="http://192.168.43.168:8080/api/student/getlesson";
    public Lesson lesson;
    public CurrentLessonInterface currentLessonInterface;
    public Context context;



    public CurrentLessonManager(Context context) {
        this.context = context;
    }


    @Override
    public void getCurrentLesson(final OnFinishedListener onFinishedListener) {
        currentLessonInterface= CurrentLessonApiClient.getApiClient().create(CurrentLessonInterface.class);

        Call<Lesson> lessonCall=currentLessonInterface.getLesson();

        lessonCall.enqueue(new Callback<Lesson>() {
            @Override
            public void onResponse(Call<Lesson> call, retrofit2.Response<Lesson> response) {

                    onFinishedListener.onFinished(response.body());

            }

            @Override
            public void onFailure(Call<Lesson> call, Throwable t) {
                    onFinishedListener.onFailure(t);

            }

        });


    }
}
