package classeye.project.app.classeyes.root;

import android.app.Application;

import classeye.project.app.classeyes.root.components.ApplicationComponent;
import classeye.project.app.classeyes.root.components.CurrentLessonComponent;
import classeye.project.app.classeyes.root.components.DaggerApplicationComponent;
import classeye.project.app.classeyes.root.components.DaggerCurrentLessonComponent;
import classeye.project.app.classeyes.root.components.DaggerRecordsComponent;
import classeye.project.app.classeyes.root.components.RecordsComponent;
import classeye.project.app.classeyes.root.modules.CurrentLessonModule;
import classeye.project.app.classeyes.root.modules.LoginModule;
import classeye.project.app.classeyes.root.modules.RecordsModule;

public class MyApp extends Application {


    public ApplicationComponent applicationComponent;
    public static MyApp myApp;
    public CurrentLessonComponent currentLessonComponent;

    public RecordsComponent recordsComponent;

    public RecordsComponent getRecordsComponent() {
        return recordsComponent;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }



    public static MyApp getMyApp() {
        return myApp;
    }

    public CurrentLessonComponent getCurrentLessonComponent() {
        return currentLessonComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
        applicationComponent= DaggerApplicationComponent.builder().loginModule(new LoginModule(getApplicationContext())).build();
        currentLessonComponent= DaggerCurrentLessonComponent.builder().currentLessonModule(new CurrentLessonModule(getApplicationContext())).build();
        recordsComponent= DaggerRecordsComponent.builder().recordsModule(new RecordsModule(getApplicationContext())).build();
    }




}
