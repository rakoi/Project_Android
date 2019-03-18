package classeye.project.app.classeyes.root;

import android.app.Application;

import classeye.project.app.classeyes.root.components.ApplicationComponent;
import classeye.project.app.classeyes.root.components.DaggerApplicationComponent;
import classeye.project.app.classeyes.root.modules.LoginModule;

public class MyApp extends Application {


    public ApplicationComponent applicationComponent;
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent= DaggerApplicationComponent.builder().loginModule(new LoginModule(getApplicationContext())).build();
    }




}
