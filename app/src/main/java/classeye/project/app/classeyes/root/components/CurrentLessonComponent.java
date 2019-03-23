package classeye.project.app.classeyes.root.components;


import classeye.project.app.classeyes.Home;
import classeye.project.app.classeyes.root.modules.CurrentLessonModule;
import dagger.Component;
import dagger.Module;

@Component(modules = {CurrentLessonModule.class} )
public interface CurrentLessonComponent {
    void inject(Home home);
}
