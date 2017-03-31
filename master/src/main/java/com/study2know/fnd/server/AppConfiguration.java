package com.study2know.fnd.server;

import com.bendb.dropwizard.redis.JedisFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.cache.CacheBuilderSpec;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by Naval on 31/3/17.
 */
public class AppConfiguration extends Configuration {
    private static Logger log = LoggerFactory.getLogger(AppConfiguration.class);
    @NotBlank
    private final String defaultName;
    @NotBlank
    private final String baseUrl;
//    @JsonProperty("swagger")
//    public SwaggerBundleConfiguration swaggerBundleConfiguration = new SwaggerBundleConfiguration();
    @NotNull
    @Valid
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();
    @JsonProperty("authenticationCachePolicy")
    private CacheBuilderSpec authenticationCachePolicy;
    @JsonProperty("redis")
    private JedisFactory jedisFactory = new JedisFactory();
    @JsonProperty("isProduction")
    private boolean isProduction;
//    @JsonProperty("schedulers")
//    public Map<String, ScheduleManager.SchedulerConfig> schedulers;
    @JsonProperty("selfPort")
    public int port;



    public AppConfiguration(@JsonProperty("defaultName") String defaultName,
                            @JsonProperty("baseUrl") String baseUrl) {
        this.defaultName = defaultName;
        this.baseUrl = baseUrl;
    }

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

//    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
//        return swaggerBundleConfiguration;
//    }

    public CacheBuilderSpec getAuthenticationCachePolicy() {
        return authenticationCachePolicy;
    }

    public void setAuthenticationCachePolicy(CacheBuilderSpec authenticationCachePolicy) {
        this.authenticationCachePolicy = authenticationCachePolicy;
    }

    public JedisFactory getJedisFactory() {
        return jedisFactory;
    }

    public void setJedisFactory(JedisFactory jedisFactory) {
        this.jedisFactory = jedisFactory;
    }

    public boolean isProduction() {
        return isProduction;
    }
}
