package com.study2know.fnd.server;

import com.bendb.dropwizard.redis.JedisBundle;
import com.codahale.metrics.MetricRegistry;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Naval on 31/3/17.
 */
public class Study2Know extends Application<AppConfiguration> {

    private static Logger log = LoggerFactory.getLogger(Study2Know.class);
    private static int port;
    private static boolean isProduction;
    private final MetricRegistry metricRegistry = new MetricRegistry();
    private JedisBundle jedis;

    public static void main(String[] args) throws Exception {
        new Study2Know().run(args);
    }

    public static int getPort() {
        return port;
    }



    public static boolean isProduction() {
        return isProduction;
    }

    @Override
    public String getName() {
        return "study2know";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<AppConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(AppConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
//        bootstrap.addBundle(new SwaggerBundle<AppConfiguration>() {
//            @Override
//            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(AppConfiguration configuration) {
//                return configuration.getSwaggerBundleConfiguration();
//            }
//        });
//        bootstrap.setConfigurationSourceProvider(
//                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
//                        new EnvironmentVariableSubstitutor()
//                )
//        );
//        jedis = new JedisBundle<AppConfiguration>() {
//            @Override
//            public JedisFactory getJedisFactory(AppConfiguration configuration) {
//                return configuration.getJedisFactory();
//            }
//        };
//        bootstrap.addBundle(jedis);
//        bootstrap.getObjectMapper().configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false).setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
//        bootstrap.setMetricRegistry(metricRegistry);
//        bootstrap.registerMetrics();
    }
    @Override
    public void run(AppConfiguration configuration, Environment environment) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        DBI dbi = new DBIFactory().build(environment, configuration.getDataSourceFactory(), "mysql");
        Injector injector = createInjector(configuration, environment, dbi);

//        NewRelicReporter reporter = NewRelicReporter.forRegistry(metricRegistry)
//                .name("new relic reporter")
//                .filter(MetricFilter.ALL)
//                .attributeFilter(new MetricAttributeFilter())
//                .rateUnit(TimeUnit.SECONDS)
//                .durationUnit(TimeUnit.MILLISECONDS)
//                .metricNamePrefix("xeno/")
//                .build();
//
//        reporter.start(1, TimeUnit.MINUTES);
       // environment.jersey().register(injector.getInstance(Testing.class));

//        //Business Resources
//        environment.jersey().register(injector.getInstance(RegisterBusinessResource.class));
//        environment.jersey().register(injector.getInstance(DBLoaderResource.class));
//
//        environment.jersey().register(new AccessDeniedExceptionMapper());
//        environment.lifecycle().manage(new JedisWorker(jedis.getPool()));
//        if (configuration.schedulers != null)
//            for (ScheduleManager.SchedulerConfig config : configuration.schedulers.values()) {
//                ScheduleManager sm = (ScheduleManager) Class.forName(config.scheduler).newInstance();
//                sm.configure(dbi, config);
//                environment.lifecycle().manage(sm);
//            }

//        environment.lifecycle().manage(injector.getInstance(UserActivityChecker.class));
//        // environment.jersey().register(new GsonMessageBodyHandler());
//        environment.healthChecks().register("template", injector.getInstance(AppHealthCheck.class));
//        Authenticator oauthAuthenticator = new OAuthAuthenticator(injector.getInstance(TokenDAO.class));
//        Authenticator basicAuthenticator = new BasicAuthenticator(injector.getInstance(UserAuthDAO.class));
//        Authenticator cachingAuthenticator = new CachingAuthenticator<>(metricRegistry, oauthAuthenticator,
//                configuration.getAuthenticationCachePolicy());
//        Authorizer authorizer = new XenoAuthorizer();
//        AuthFilter cacheAuthFilter = new OAuthCredentialAuthFilter.Builder<>()
//                .setAuthenticator(cachingAuthenticator)
//                .setAuthorizer(authorizer)
//                .setPrefix("Bearer")
//                .buildAuthFilter();
//
//        AuthFilter basicCredentialAuthFilter = new BasicCredentialAuthFilter.Builder<>()
//                .setAuthenticator(basicAuthenticator)
//                .setAuthorizer(authorizer)
//                .setPrefix("Basic")
//                .buildAuthFilter();
//
//        AuthFilter oauthCredentialAuthFilter = new OAuthCredentialAuthFilter.Builder<>()
//                .setAuthenticator(oauthAuthenticator)
//                .setAuthorizer(authorizer)
//                .setPrefix("Bearer")
//                .buildAuthFilter();
//
//        List<AuthFilter> filters = Lists.newArrayList(cacheAuthFilter, basicCredentialAuthFilter, oauthCredentialAuthFilter);
//        environment.jersey().register(new AuthDynamicFeature(new ChainedAuthFilter(filters)));
//        environment.jersey().register(RolesAllowedDynamicFeature.class);
//        //If you want to use @Auth to inject a custom Principal type into your resource
//        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Principal.class));
//        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("crossOriginRequests", CrossOriginFilter.class);
//        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
//        try {
//            new Configuration(injector.getInstance(ConfigDAO.class));
//        } catch (InvalidTypeException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Invalid Configuration found. Cant continue with bootstrap", e);
//        }
//        port = configuration.port;
        isProduction = configuration.isProduction();
    }

    private Injector createInjector(AppConfiguration configuration, Environment environment, DBI dbi) {
        return Guice.createInjector(new AppModule(configuration, environment, dbi));
    }
}

