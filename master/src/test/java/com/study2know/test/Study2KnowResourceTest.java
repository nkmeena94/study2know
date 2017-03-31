package com.study2know.test;

import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by Naval on 31/3/17.
 */
public class Study2KnowResourceTest extends BaseTest {
    @Test
    public void getuserdetail() throws Exception {

        Response resp = client.target("http://localhost:" + RULE.getLocalPort() + "/api/study2know/users/getuserdetail/2")
                .request().get();
        String strResp = resp.readEntity(String.class);
        System.out.println(strResp);

    }
}
