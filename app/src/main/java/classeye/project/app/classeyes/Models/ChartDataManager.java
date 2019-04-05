package classeye.project.app.classeyes.Models;



import java.util.HashMap;

import classeye.project.app.classeyes.Contracts.ChartContract;
import classeye.project.app.classeyes.apiClients.ChartAPInterface;
import classeye.project.app.classeyes.apiClients.ChartApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartDataManager implements ChartContract.Model {

    public ChartAPInterface apInterface;

    @Override
    public void getLessons(final onFinishedListener onFinishedListener) {

       apInterface= ChartApiClient.getApiClient().create(ChartAPInterface.class);
        Call<HashMap<String,Integer>> chartdata=apInterface.getAttendanceRecords();

        chartdata.enqueue(new Callback<HashMap<String, Integer>>() {
            @Override
            public void onResponse(Call<HashMap<String, Integer>> call, Response<HashMap<String, Integer>> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<HashMap<String, Integer>> call, Throwable t) {
                    onFinishedListener.onFailure(t.getMessage());
            }
        });

    }
}
