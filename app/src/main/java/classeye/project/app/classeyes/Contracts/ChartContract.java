package classeye.project.app.classeyes.Contracts;

import java.util.HashMap;

public interface ChartContract {

    public interface Model{
        interface onFinishedListener{
            void onFinished(HashMap<String,Integer> records);
            void onFailure(String t);
        }

        void getLessons(onFinishedListener onFinishedListener);
    }
    public interface View{
        void showRecords(HashMap<String,Integer> records);
        void showError(String error);

    }
    public interface Presenter{
        void passRecords();
    }
}
