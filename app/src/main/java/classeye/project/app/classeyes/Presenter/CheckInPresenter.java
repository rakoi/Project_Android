package classeye.project.app.classeyes.Presenter;

import classeye.project.app.classeyes.Contracts.CheckinContract;
import classeye.project.app.classeyes.Dao.Attendance;
import classeye.project.app.classeyes.Models.CheckinDataManager;

public class CheckInPresenter implements CheckinContract.Presenter,CheckinContract.Model.onFinishedListener {


    public CheckinContract.View view;
    public CheckinContract.Model model;

    public CheckInPresenter(CheckinContract.View view) {
        this.view = view;
        model=new CheckinDataManager();
    }

    @Override
    public void passLessonName(String lessonName) {

        model.signIn(this,lessonName);

    }


    @Override
    public void onFinished(Attendance attendance) {

        view.showResponse(attendance);
    }

    @Override
    public void onFailure(Throwable t) {
        view.showError(t.toString());

    }
}
