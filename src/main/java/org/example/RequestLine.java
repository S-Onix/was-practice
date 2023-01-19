package org.example;

import java.util.Objects;

public class RequestLine {
    /**
     * RequestLine 구성요소
     *     - HttpMethod
     *     - path
     *     - queryString
     * */

    private final String method;
    private final String urlPath;

    private QueryStrings queryStrings;


    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }
    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];

        String [] urlTokens = tokens[1].split("\\?");
        this.urlPath = urlTokens[0];

        if(urlTokens.length == 2)
            this.queryStrings = new QueryStrings(urlTokens[1]);
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String path) {
        return path.equals(this.urlPath);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestLine that = (RequestLine) o;
        return Objects.equals(method, that.method) && Objects.equals(urlPath, that.urlPath) && Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, urlPath, queryStrings);
    }


    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }
}
