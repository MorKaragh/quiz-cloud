package ru.mewory.quizui.model;


import java.util.ArrayList;
import java.util.List;

public class Question {
    private List<Variant> variants = new ArrayList<>();

    private String type;

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
