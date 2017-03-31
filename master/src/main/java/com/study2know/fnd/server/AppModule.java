package com.study2know.fnd.server;

import com.codahale.metrics.MetricRegistry;
import com.google.inject.AbstractModule;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by Naval on 31/3/17.
 */
public class AppModule extends AbstractModule {
    private final AppConfiguration configuration;
    private final Environment environment;
    private final DBI dbi;

    public AppModule(AppConfiguration configuration, Environment environment, DBI dbi) {
        this.configuration = configuration;
        this.environment = environment;
        this.dbi = dbi;
    }
    @Override
    protected void configure() {
        bind(AppConfiguration.class).toInstance(configuration);
        bind(DBI.class).toInstance(dbi);
        bind(MetricRegistry.class).toInstance(new MetricRegistry());
        //bind(TestDAO.class).toInstance(dbi.onDemand(TestDAO.class));
    }
}
