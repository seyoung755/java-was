package webserver.login;

import com.google.common.base.Strings;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionDataBase {
    private static final Map<String, Cookie> cookies = new ConcurrentHashMap<>();

    private SessionDataBase() {

    }

    public static void addCookie(Cookie cookie) {
        if (Strings.isNullOrEmpty(cookie.getSessionId())) {
            throw new IllegalArgumentException("invalid access to session");
        }
        cookies.put(cookie.getSessionId(), cookie);
    }

    public static void deleteCookie(String sessionId) {
        cookies.remove(sessionId);
    }

    public static boolean isLoggedIn(String sessionId) {
        return cookies.containsKey(sessionId);
    }
}
