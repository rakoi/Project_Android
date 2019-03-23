package classeye.project.app.classeyes.root.modules;

import android.content.Context;

import classeye.project.app.classeyes.Contracts.CurrentLessonContract;
import classeye.project.app.classeyes.Models.CurrentLessonManager;
import classeye.project.app.classeyes.Presenter.CurrentLessonPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class CurrentLessonModule {

    public Context context;

    public CurrentLessonModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    public CurrentLessonContract.Model currentLessonModel(Context context){
        return new CurrentLessonManager(context);
    }

    @Provides
    public CurrentLessonContract.Presenter currentLessonPresenter(CurrentLessonContract.Model model){
        return new CurrentLessonPresenter(model);
    }
}
