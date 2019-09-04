package utils;

import cucumber.api.junit.Cucumber;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class CustomerRunner extends Cucumber {

    public CustomerRunner(Class clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new ScreenShotListener());
        super.run(notifier);
    }
}
