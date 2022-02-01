package com.amdocs.learning.controller;

import java.util.List;

import com.amdocs.learning.TemplateBasicApplicationTest;
import com.amdocs.learning.model.ParticipantVO;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

@Sql(value = "/sqls/clear.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sqls/participants.sql")
public class ParticipantsControllerTest extends TemplateBasicApplicationTest {


    @Test
    public void testGetAllParticipantList(){
        ResponseEntity<List<ParticipantVO>> response = restTemplate.exchange("/participants",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ParticipantVO>>() {});

        Assert.assertNotNull(response);

        List<ParticipantVO> data = response.getBody();

        MatcherAssert.assertThat(data, Matchers.hasSize(1));

        Assert.assertNotNull(data.get(0));
        Assert.assertEquals("DEFAULT", data.get(0).getName());

    }


}
