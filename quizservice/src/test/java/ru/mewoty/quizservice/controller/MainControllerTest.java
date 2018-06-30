package ru.mewoty.quizservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import ru.mewoty.quizservice.quiz.Quiz;
import ru.mewoty.quizservice.quiz.question.Question;
import ru.mewoty.quizservice.quiz.question.Variant;
import ru.mewoty.quizservice.quiz.question.VariantQuestion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateQuiz(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>("{\"id\":null,\"description\":\"test quiz\",\"questions\":[{\"type\":\"variant_question\",\"variants\":[{\"id\":null,\"question\":null,\"description\":\"variant description\"}]}]}\n",headers);

        String url = "http://localhost:" + port + "/create";
        Map exchange = this.restTemplate.postForObject(url,requestEntity,Map.class);
        String id = (String) exchange.get("id");

        assertNotNull(id);

        url = "http://localhost:" + port + "/getDescription?id=" + id;
        String forObject = this.restTemplate.getForObject(url, String.class);

        assertEquals(forObject,"test quiz");
    }

    @Test
    public void printExampleQUIZ() throws IOException {
        Quiz quiz = new Quiz();
        quiz.setDescription("test quiz");
        ArrayList<Question> questions = new ArrayList<>();
        VariantQuestion one = new VariantQuestion();
        ArrayList<Variant> variants = new ArrayList<>();
        Variant variant = new Variant();
        variant.setDescription("variant description");

        variants.add(variant);
        one.setVariants(variants);
        questions.add(one);
        quiz.setQuestions(questions);

        System.out.println(quiz.toString());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new BufferedWriter(new StringWriter()),quiz);
        System.out.println("------------------ \n" + mapper.writeValueAsString(quiz));
    }

}