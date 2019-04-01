package classeye.project.app.classeyes.Models;

import classeye.project.app.classeyes.Contracts.CheckinContract;
import classeye.project.app.classeyes.Dao.Attendance;
import classeye.project.app.classeyes.apiClients.CheckInApiLessonInterface;
import classeye.project.app.classeyes.apiClients.CheckinLessonApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckinDataManager implements CheckinContract.Model {

    public CheckInApiLessonInterface checkInLessonInterface;


    @Override
    public void signIn(final onFinishedListener finishedListener, String lessonName) {
        checkInLessonInterface=CheckinLessonApiClient.getApiClient().create(CheckInApiLessonInterface.class);

        Call<Attendance> attendancedata=checkInLessonInterface.checkIn(1,lessonName);
        attendancedata.enqueue(new Callback<Attendance>() {
            @Override
            public void onResponse(Call<Attendance> call, Response<Attendance> response) {
                finishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<Attendance> call, Throwable t) {
                finishedListener.onFailure(t);
            }
        });

    }
}
