package classeye.project.app.classeyes.Models;



import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;

import classeye.project.app.classeyes.Contracts.RecordsContract;
import classeye.project.app.classeyes.apiClients.AttendanceRecordsInterface;
import classeye.project.app.classeyes.apiClients.AttendancerecordsApiClient;
import classeye.project.app.classeyes.apiClients.CurrentLessonInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecordsDataManager implements RecordsContract.Model {

    public AttendanceRecordsInterface attendanceRecordsInterface;
    public Context context;
    SharedPreferences sharedPreferences;

    public RecordsDataManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public int getId(){
        return sharedPreferences.getInt("id",0);
    }

    @Override
    public void getRecords(final onFinishedListener finishedListener) {
        attendanceRecordsInterface= AttendancerecordsApiClient.getApiClient().create(AttendanceRecordsInterface.class);
        Call<HashMap<String,Integer>> recordsCall=attendanceRecordsInterface.getAttendanceRecord(getId());

        recordsCall.enqueue(new Callback<HashMap<String, Integer>>() {
            @Override
            public void onResponse(Call<HashMap<String, Integer>> call, Response<HashMap<String, Integer>> response) {
                finishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<HashMap<String, Integer>> call, Throwable t) {
                finishedListener.onFailure(t.getMessage());
            }
        });

    }
}
