package org.example;

public class QueryString {

    private final String value;
    private final String key;

    public QueryString(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public  String getValue() {
        return this.value;
    }

    public boolean exist(String key) {
        return key.equals(this.key);
    }
}
