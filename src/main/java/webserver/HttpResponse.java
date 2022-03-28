package webserver;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private final String version;
    private final HttpStatus httpStatus;
    private final Map<String, String> responseHeaders = new HashMap<>();
    private byte[] responseBody = new byte[]{};

    public HttpResponse(String version, HttpStatus httpStatus) {
        this.version = version;
        this.httpStatus = httpStatus;
    }

    public String getVersion() {
        return version;
    }

    public int getHttpStatusCode() {
        return httpStatus.getStatusCode();
    }

    public String getHttpStatusMessage() {
        return httpStatus.getMessage();
    }

    public Map<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public String getHeader(String key) {
        return responseHeaders.get(key);
    }

    public byte[] getResponseBody() {
        return responseBody;
    }

    public void addHeader(String key, String value) {
        responseHeaders.put(key, value);
    }

    public void addBody(byte[] responseBody) {
        this.responseBody = responseBody;
    }
}