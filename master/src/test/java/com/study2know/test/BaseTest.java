package com.study2know.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study2know.fnd.server.AppConfiguration;
import com.study2know.fnd.server.Study2Know;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;

public class BaseTest {

    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("com/study2know/test/properties.yml");
    @ClassRule
    public static final DropwizardAppRule<AppConfiguration> RULE = new DropwizardAppRule<AppConfiguration>(
            Study2Know.class, CONFIG_PATH);
    public static String phone = null;
    public static String tokenId = null;
    public static String publisherToken = null;
    public static String adminToken = null;
    public static String regDeviceId = "dev" + System.nanoTime();
    protected static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSS").create();
    protected Client client;

//    @BeforeClass
//    public static void migrateDb() throws Exception {
//        RULE.getApplication().run("db", "migrate", CONFIG_PATH);
//    }

    @Before
    public void setUp() throws Exception {
        JacksonJsonProvider jackson_json_provider = new JacksonJaxbJsonProvider();
        ObjectMapper mapper = jackson_json_provider.locateMapper(Object.class, MediaType.APPLICATION_JSON_TYPE);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        client = ClientBuilder.newClient().register(jackson_json_provider);
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }
}