package io.agrest.benchmark;

import com.google.inject.Binder;
import com.google.inject.Module;
import io.bootique.Bootique;
import io.bootique.jersey.JerseyModule;

public class Application implements Module {

    public static void main(String[] args) {
        Bootique.app(args)
                .autoLoadModules()
                .exec()
                .exit();
    }

    @Override
    public void configure(Binder binder) {
        JerseyModule.extend()
    }
}
