package org.mediawiki.gusev.constants;

public enum PathConstants {
    WIKI_API("/w/api.php");

    private final String method;

    PathConstants(String method) {
        this.method = method;
    }

    public String getApiMethod() {
        return method;
    }
}
