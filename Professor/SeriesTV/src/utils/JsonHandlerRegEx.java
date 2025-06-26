package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class JsonHandlerRegEx {

    public static Map<String, Object> getJsonRegEx(String body) {
        try {
            // Extrair os dados do JSON usando expressões regulares
            Pattern pattern = Pattern.compile("\"(\\w+)\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(body);
            // Mapa que irá armazenar a chave:valor do json
            Map<String, Object> jsonData = new HashMap<>();
            while (matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);
                jsonData.put(key, value);
            }
            return jsonData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
