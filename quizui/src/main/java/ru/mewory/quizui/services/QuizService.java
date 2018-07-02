package ru.mewory.quizui.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.mewory.quizui.model.Quiz;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

@Service
public class QuizService extends RestTemplate {
    private static final String SERVICE_ID = "quizservice";

    @Autowired
    private DiscoveryClient discoveryClient;

    RestTemplate restTemplate;
    URI BASE_URL;

    public QuizService() {

    }

    @PostConstruct
    public void postConstruct(){
        restTemplate = new RestTemplate();
        List<ServiceInstance> quizservice = discoveryClient.getInstances(SERVICE_ID);
        ServiceInstance instanceInfo = quizservice.get(0);
        BASE_URL = instanceInfo.getUri();

        String pong = restTemplate.getForObject(BASE_URL + "/ping", String.class);
        System.out.println(pong);
    }

    public Long createQuiz(Quiz quiz){
        HashMap<String, String> result = restTemplate.postForObject(BASE_URL + "/create", quiz, HashMap.class);
        String id = result.get("id");

        return Long.valueOf(id);
    }
}
