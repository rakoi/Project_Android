package classeye.project.app.classeyes.Presenter;

import java.util.HashMap;

import classeye.project.app.classeyes.Contracts.LoginContract;
import classeye.project.app.classeyes.Dao.User;
import classeye.project.app.classeyes.Models.UserDataManager;

public class UserPresenter implements LoginContract.Presenter {

    LoginContract.View view;
    LoginContract.Model model;




    public UserPresenter(LoginContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginContract.View view) {
        this.view=view;
    }

    @Override
    public void getInput(String username, String password) {
        model.saveCredentials(username,password);

    }

    @Override
    public void loginUser() {
        model.login();
    }

    @Override
    public void getSavedCredentials() {
        view.checkSavedCredentials(model.SavedCredentials());
    }
}
