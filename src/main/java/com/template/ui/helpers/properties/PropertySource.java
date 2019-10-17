package com.template.ui.helpers.properties;

public enum PropertySource {
    USER("user.properties"),;
    public String sourceFile;

    public PropertySource[] getOptions(){
        return PropertySource.values();
    }

    PropertySource(String sourceFile) {
        this.sourceFile = sourceFile;
    }

}

