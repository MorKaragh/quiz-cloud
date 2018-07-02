package ru.mewory.quizui.ui;


import com.netflix.appinfo.InstanceInfo;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;
import ru.mewory.quizui.model.Quiz;
import ru.mewory.quizui.services.QuizService;

import java.util.List;

@Route("new")
public class NewQuizUI extends VerticalLayout {

    @Autowired
    private QuizService quizService;

    private final TextField descriptionFld;

    public NewQuizUI(){
        FormLayout descriptionForm = new FormLayout();
        descriptionFld = new TextField("Описание");
        descriptionForm.add(descriptionFld);
        add(descriptionForm);

        Button saveQuestion = new Button("Сохранить");
        saveQuestion.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                save();
            }
        });
        add(saveQuestion);

        Button addQuestion = new Button("Новый вопрос");
        addQuestion.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                add(new QuestionBlock());
            }
        });
        add(addQuestion);
    }

    private void save() {
        Quiz quiz = new Quiz();
        quiz.setDescription(descriptionFld.getValue());
        Long id = quizService.createQuiz(quiz);
        Notification.show("new ID = " + id);
    }
}
