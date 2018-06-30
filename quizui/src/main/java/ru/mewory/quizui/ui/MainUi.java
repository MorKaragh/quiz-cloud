package ru.mewory.quizui.ui;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainUi  extends Div {
    public MainUi(){
        setText("Hello world!");
    }
}
