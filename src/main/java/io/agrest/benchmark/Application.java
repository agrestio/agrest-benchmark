package io.agrest.benchmark;

import com.google.inject.Binder;
import com.google.inject.Module;
import io.agrest.benchmark.api.ArtistApi;
import io.bootique.BQCoreModule;
import io.bootique.Bootique;
import io.bootique.cayenne.CayenneModule;
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
        BQCoreModule.extend(binder).addConfig("classpath:io/bootique/benchmark/default.yml");
        CayenneModule.extend(binder).addProject("io/agrest/benchmark/cayenne-project.xml");
        JerseyModule.extend(binder).addResource(ArtistApi.class);
    }
}
