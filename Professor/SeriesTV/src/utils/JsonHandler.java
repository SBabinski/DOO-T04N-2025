package utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import models.User;

public abstract class JsonHandler {

    static final ObjectMapper mapper = new ObjectMapper();
    static final String filePath = "data/user.json";
    static final File file = new File(filePath);

    public static boolean writeJson(User user) {
        try {
            file.getParentFile().mkdirs();
            mapper.writeValue(file, user);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User readJson() {
        try {
            User user = mapper.readValue(file, User.class);
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
