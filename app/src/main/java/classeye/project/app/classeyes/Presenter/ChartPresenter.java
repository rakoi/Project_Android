package classeye.project.app.classeyes.Presenter;

import android.content.SharedPreferences;

import java.util.HashMap;

import classeye.project.app.classeyes.Contracts.ChartContract;
import classeye.project.app.classeyes.Models.ChartDataManager;

public class ChartPresenter implements ChartContract.Presenter,ChartContract.Model.onFinishedListener{

    public ChartContract.View view;
    public ChartContract.Model model;

    public ChartPresenter(ChartContract.View view, SharedPreferences sharedPreferences) {
        this.view = view;
        this.model=new ChartDataManager(sharedPreferences);
    }

    @Override
    public void passRecords() {
        model.getLessons(this);
    }

    @Override
    public void onFinished(HashMap<String, Integer> records) {
        view.showRecords(records);
    }

    @Override
    public void onFailure(String t) {
        view.showError(t);
    }
}
