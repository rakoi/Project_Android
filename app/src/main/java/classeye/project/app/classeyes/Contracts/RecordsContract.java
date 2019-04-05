package classeye.project.app.classeyes.Contracts;

import java.security.Key;
import java.util.HashMap;

public interface RecordsContract {


    interface View{
        void showRecords(HashMap<String,Integer> hashMap);
        void showError(String t);
    }
    interface Presenter{
        void setView(RecordsContract.View view);
        void passRecords();
    }
    interface Model{
        interface onFinishedListener{
            void onFinished(HashMap<String,Integer> records);
            void onFailure(String t);
        }
        void getRecords(onFinishedListener listener);
    }
}
