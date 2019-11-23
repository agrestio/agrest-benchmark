package io.agrest.benchmark;

import com.google.inject.Binder;
import com.google.inject.Module;
import io.agrest.benchmark.api.cayenne.ArtistApi;
import io.bootique.BQCoreModule;
import io.bootique.Bootique;
import io.bootique.cayenne.CayenneModule;
import io.bootique.jersey.JerseyModule;
import io.bootique.meta.application.OptionMetadata;

public class Application implements Module {

    public static void main(String[] args) {
        Bootique.app(args)
                .autoLoadModules()
                .exec()
                .exit();
    }

    @Override
    public void configure(Binder binder) {
        BQCoreModule.extend(binder)
                .addOption(OptionMetadata.builder("verbose").build())
                .addConfig("classpath:io/agrest/benchmark/default.yml")
                .mapConfigResource("verbose", "classpath:io/agrest/benchmark/verbose.yml");

        CayenneModule.extend(binder).addProject("io/agrest/benchmark/cayenne-project.xml");
        JerseyModule.extend(binder).addResource(ArtistApi.class);
    }
}
