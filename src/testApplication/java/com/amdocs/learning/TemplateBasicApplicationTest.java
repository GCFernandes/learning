package com.amdocs.learning;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@ActiveProfiles("testApplication")
@SpringBootTest(classes = {Learning.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TemplateBasicApplicationTest {

        @Autowired
        protected TestRestTemplate restTemplate;

        @Test
        public void selfTest(){
                MatcherAssert.assertThat(true, is(true));
        }

}
