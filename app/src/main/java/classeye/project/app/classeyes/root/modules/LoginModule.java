package classeye.project.app.classeyes.root.modules;

import android.content.Context;
import android.content.SharedPreferences;

import classeye.project.app.classeyes.Contracts.LoginContract;
import classeye.project.app.classeyes.Models.UserDataManager;
import classeye.project.app.classeyes.Presenter.UserPresenter;
import dagger.Module;
import dagger.Provides;


@Module
public class LoginModule {

    public Context context;
    public LoginModule(Context context) {
        this.context=context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    public SharedPreferences sharedPreferences(){
        return context.getSharedPreferences("classeye",Context.MODE_PRIVATE);

    }

    @Provides
    public LoginContract.Model provideLoginContractModel(SharedPreferences sharedPreferences,Context context){
        return new UserDataManager(sharedPreferences,context);
    }

    @Provides
    public LoginContract.Presenter provideLoginContractPresenter(LoginContract.Model model){
        return new UserPresenter(model);
    }



}
