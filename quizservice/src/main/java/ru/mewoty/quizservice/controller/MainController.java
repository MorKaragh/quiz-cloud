package ru.mewoty.quizservice.controller;

import com.netflix.client.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mewoty.quizservice.exception.NoSuchQuizException;
import ru.mewoty.quizservice.quiz.Quiz;
import ru.mewoty.quizservice.service.QuizService;

import java.util.HashMap;

@RestController
public class MainController {

    @Autowired
    private QuizService quizService;

    @RequestMapping(method = RequestMethod.POST, value = {"/create"} , consumes = "application/json")
    public ResponseEntity<HashMap<String, String>> create(@RequestBody Quiz quiz){
        Long id = quizService.saveNew(quiz);
        HashMap<String, String> responseMap = new HashMap<>();
        responseMap.put("id", String.valueOf(id));
        return new ResponseEntity<>(responseMap, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/count"})
    public ResponseEntity<String> getCount(){
        return new ResponseEntity<>(quizService.count().toString(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/getDescription"})
    public ResponseEntity<String> getDescription(@RequestParam Long id){
        System.out.println(id);
        String description;
        try {
            description = quizService.getDescription(id);
        } catch (NoSuchQuizException e) {
            return new ResponseEntity<>("no such quiz", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(description, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = {"/ping"})
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>("pong!", HttpStatus.OK);
    }

}
