package com.extsoft.comments.elements;

public class ContainsText implements Criteria {

    private final String textToContain;

    public ContainsText(String textToContain) {
        this.textToContain = textToContain;
    }

    @Override
    public boolean relevant(Element element) {
        return element.getText().contains(textToContain);
    }
}
