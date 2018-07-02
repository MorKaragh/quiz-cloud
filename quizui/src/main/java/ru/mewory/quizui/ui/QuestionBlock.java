package ru.mewory.quizui.ui;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class QuestionBlock extends VerticalLayout implements HasValue{
    private TextField descriptionFld = new TextField("текст вопроса");
    private List<TextField> variants = new ArrayList<>();
    private TextField lastField = null;


    public QuestionBlock(){
        add(descriptionFld);
        add(new Text("варианты ответов"));
        addVariant();
    }

    private void addVariant() {
        TextField variant = new TextField();
        variants.add(variant);
        lastField = variant;
        variant.addValueChangeListener(new ValueChangeListener<AbstractField.ComponentValueChangeEvent<TextField, String>>() {
            @Override
            public void valueChanged(AbstractField.ComponentValueChangeEvent<TextField, String> val) {
                if (variant == lastField && StringUtils.isNoneBlank(val.getValue())){
                    addVariant();
                } else if (variant != lastField && StringUtils.isBlank(val.getValue())) {
                    removeVariant(val.getSource());
                }
            }
        });
        add(variant);
    }

    private void removeVariant(TextField source) {
        remove(source);
        variants.remove(source);
    }


    @Override
    public void setValue(Object o) {

    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener valueChangeListener) {
        return null;
    }

    @Override
    public void setReadOnly(boolean b) {

    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public void setRequiredIndicatorVisible(boolean b) {

    }

    @Override
    public boolean isRequiredIndicatorVisible() {
        return false;
    }
}
