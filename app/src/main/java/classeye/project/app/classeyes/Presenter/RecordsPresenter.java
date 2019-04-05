package classeye.project.app.classeyes.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

import classeye.project.app.classeyes.Contracts.CurrentLessonContract;
import classeye.project.app.classeyes.Contracts.RecordsContract;
import classeye.project.app.classeyes.Models.RecordsDataManager;

public class RecordsPresenter implements RecordsContract.Presenter,RecordsContract.Model.onFinishedListener {

    public RecordsContract.View view;
    public RecordsContract.Model model;

    public RecordsPresenter(SharedPreferences sharedPreferences) {

        this.model=new RecordsDataManager(sharedPreferences);
    }


    @Override
    public void setView(RecordsContract.View view) {
        this.view=view;
    }

    @Override
    public void passRecords() {
      model.getRecords(this);
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
