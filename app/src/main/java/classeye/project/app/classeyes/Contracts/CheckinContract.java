package classeye.project.app.classeyes.Contracts;

import classeye.project.app.classeyes.Dao.Attendance;
import classeye.project.app.classeyes.Dao.Lesson;

public interface CheckinContract {

     interface Model{

         interface onFinishedListener{
             void onFinished(Attendance attendance);
             void onFailure(Throwable t);
         }

         void signIn(onFinishedListener finishedListener,String lessonName);
    }
     interface View{

        void showError(String error);
        void showResponse(Attendance attendance);
    }
     interface Presenter{
         void passLessonName(String name);

    }
}
