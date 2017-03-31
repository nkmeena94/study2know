package com.study2know.fnd.server;

import com.codahale.metrics.MetricRegistry;
import com.google.inject.AbstractModule;
import com.study2know.db.dao.LoginDAO;
import com.study2know.db.dao.UsersDAO;
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
        bind(UsersDAO.class).toInstance(dbi.onDemand(UsersDAO.class));
        bind(LoginDAO.class).toInstance(dbi.onDemand(LoginDAO.class));
    }
}
