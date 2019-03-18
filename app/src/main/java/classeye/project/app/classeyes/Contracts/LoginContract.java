package classeye.project.app.classeyes.Contracts;

import java.util.HashMap;

public interface LoginContract  {

    interface View{
        void checkSavedCredentials(HashMap hashMap);
    }
    interface Presenter{
        void setView(LoginContract.View view);
        void getInput(String username,String password);
        void loginUser();
        void getSavedCredentials();

    }

    interface Model{
        void saveCredentials(String admNo,String password);
        HashMap<String, String> SavedCredentials();
        void login();


    }
}
