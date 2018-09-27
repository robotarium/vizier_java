package utils;

import com.google.gson.Gson;

public class Request {

    private final String id;
    private final String method;
    private final String link;

    public Request(String id, String method, String link) {
        this.id = id;
        this.method = method;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getLink() {
        return link;
    }
}


