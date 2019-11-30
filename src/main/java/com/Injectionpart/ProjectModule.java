package com.Injectionpart;

import com.Injectionpart.provider.WebDriverProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;

public final class ProjectModule extends AbstractModule {
        @Override
        public void configure() {
                bind(WebDriver.class).toProvider(WebDriverProvider.class).in(Singleton.class);
        }
}
