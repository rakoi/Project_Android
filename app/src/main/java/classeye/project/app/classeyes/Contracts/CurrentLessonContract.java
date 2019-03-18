package classeye.project.app.classeyes.Contracts;

import android.view.LayoutInflater;

import classeye.project.app.classeyes.Dao.Lesson;

public interface CurrentLessonContract {

    interface View{
        void ShowLesson(Lesson lesson);
        void failure(Throwable t);
    }
    interface Presenter{
        void getLesson();
    }
    interface Model{
        interface OnFinishedListener{
            void onFinished(Lesson lesson);
            void onFailure(Throwable t);
        }
        void getCurrentLesson(OnFinishedListener onFinishedListener);
    }

}
