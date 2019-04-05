package classeye.project.app.classeyes.root.modules;

import android.content.Context;
import android.content.SharedPreferences;

import classeye.project.app.classeyes.Contracts.RecordsContract;
import classeye.project.app.classeyes.Models.RecordsDataManager;
import classeye.project.app.classeyes.Presenter.RecordsPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class RecordsModule {

    public Context context;

    public RecordsModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return this.context;
    }
    @Provides
    public SharedPreferences providesharedPreference(){
        return context.getSharedPreferences("classeye",Context.MODE_PRIVATE);

    }
    @Provides
    public RecordsContract.Model provideRecordsDataManager(SharedPreferences sharedPreferences){
        return new RecordsDataManager(sharedPreferences);
    }
    @Provides
    public RecordsContract.Presenter provideRecordsPresenter(SharedPreferences sharedPreferences){
        return new RecordsPresenter(sharedPreferences);
    }
}
