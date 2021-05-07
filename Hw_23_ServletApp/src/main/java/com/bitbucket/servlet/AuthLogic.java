package com.bitbucket.servlet;

import java.util.HashMap;
import java.util.Map;

public class AuthLogic {

    private static final Map<String, String> database = new HashMap<>();

    public static boolean auth(String login, String password) {
        if(database.containsKey(login) && password.equals(database.get(login))) {
            return true;
        }
        return false;
    }

    public static void reg(String login, String password) {
        database.put(login, password);
    }

}
