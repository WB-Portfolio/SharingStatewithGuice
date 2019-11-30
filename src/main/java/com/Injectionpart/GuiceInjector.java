package com.Injectionpart;

import com.google.inject.Guice;
import com.google.inject.Injector;

import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;

public class GuiceInjector implements InjectorSource {
        @Override
        public Injector getInjector() {
                return Guice.createInjector(CucumberModules.SCENARIO, new ProjectModule());
        }
}