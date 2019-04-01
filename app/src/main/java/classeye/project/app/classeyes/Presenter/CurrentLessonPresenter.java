package classeye.project.app.classeyes.Presenter;

import android.content.Context;

import classeye.project.app.classeyes.Contracts.CurrentLessonContract;
import classeye.project.app.classeyes.Dao.Lesson;
import classeye.project.app.classeyes.Models.CurrentLessonManager;

public class CurrentLessonPresenter  implements CurrentLessonContract.Presenter,CurrentLessonContract.Model.OnFinishedListener{

    public CurrentLessonContract.Model model;
    public CurrentLessonContract.View view;

//    public CurrentLessonPresenter(CurrentLessonContract.View view Context context) {
//        this.model =model
//        this.view = view;
//    }

        public CurrentLessonPresenter(CurrentLessonContract.Model model) {
        this.model =model;
    }

    @Override
    public void setView(CurrentLessonContract.View view) {
        this.view = view;
    }

    @Override
    public void getLesson() {

        model.getCurrentLesson(this);
    }

    @Override
    public void onFinished(Lesson lesson) {
        view.ShowLesson(lesson);

    }

    @Override
    public void onFailure(Throwable t) {
        view.failure(t);
        Lesson lesson=new Lesson("","--","--","--");
        view.ShowLesson(lesson);

    }
}
