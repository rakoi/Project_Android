package classeye.project.app.classeyes.root.components;

import classeye.project.app.classeyes.Records;
import classeye.project.app.classeyes.root.modules.RecordsModule;
import dagger.Component;

@Component(modules = {RecordsModule.class})
public interface RecordsComponent {
    void inject(Records records);
}
