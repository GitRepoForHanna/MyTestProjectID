package utils;

public enum Language {
    RUSSIA("lang_ru"),
    ITALIA("lang_it"),
    USA("lang_en-us"),
    UK("lang_en-gb");

    private String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
