package com.extsoft.comments.elements;

public class SmartCheckBox implements CheckBox {

    private final CheckBox checkBox;

    public SmartCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public void check() {
        if (!checkBox.checked()) {
            checkBox.check();
        }
    }

    @Override
    public void uncheck() {
        if (checkBox.checked()) {
            checkBox.uncheck();
        }
    }

    @Override
    public boolean checked() {
        return checkBox.checked();
    }
}
