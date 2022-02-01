package com.amdocs.learning.controller;

import com.amdocs.learning.TemplateBasicApplicationTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class CabalatControllerTest extends TemplateBasicApplicationTest {

    @Test
    public void testGetHello(){
        ResponseEntity<String> response = restTemplate.exchange("/cabalat",
                HttpMethod.GET,
                null,
                String.class);

        Assert.assertNotNull(response);

        String data = response.getBody();

        Assert.assertEquals("Hello Cabalat", data);

    }


}
