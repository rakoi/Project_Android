package classeye.project.app.classeyes.root.components;

import classeye.project.app.classeyes.Home;
import classeye.project.app.classeyes.LoginActivity;
import classeye.project.app.classeyes.root.modules.CurrentLessonModule;
import classeye.project.app.classeyes.root.modules.LoginModule;
import dagger.Component;
import dagger.Module;

@Component(modules = {LoginModule.class} )

public interface ApplicationComponent {
    void inject(LoginActivity loginActivity);
   // void inject(Home home);

}
