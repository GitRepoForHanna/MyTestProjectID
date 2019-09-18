package utils.dependency_injection;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import steps.CarPageSteps;
import steps.CarRentSearchResultSteps;
import steps.FlightsPageSteps;
import steps.HomePageSteps;

public class ConfigurationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CarPageSteps.class).in(Singleton.class);
        bind(HomePageSteps.class).in(Singleton.class);
        bind(FlightsPageSteps.class).in(Singleton.class);
        bind(CarRentSearchResultSteps.class).in(Singleton.class);
    }
}
