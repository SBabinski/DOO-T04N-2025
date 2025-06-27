import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.gson.*;

public class APIConnection {
    public static List<Show> searchShows(String name) {
        List<Show> shows = new ArrayList<>();
        try {
            String urlStr = "https://api.tvmaze.com/search/shows?q=" + name.replace(" ", "%20");
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("GET");

            JsonArray jsonArray = JsonParser.parseReader(new InputStreamReader(conn.getInputStream())).getAsJsonArray();
            for (JsonElement e : jsonArray) {
                JsonObject show = e.getAsJsonObject().getAsJsonObject("show");
                Show s = new Show(
                    show.get("id").getAsInt(),
                    show.get("name").getAsString(),
                    show.get("language") != null ? show.get("language").getAsString() : "Unknown",
                    new Gson().fromJson(show.get("genres"), List.class),
                    show.has("rating") && show.get("rating").getAsJsonObject().has("average") ?
                        show.get("rating").getAsJsonObject().get("average").getAsDouble() : 0.0,
                    show.has("status") ? show.get("status").getAsString() : "Unknown",
                    show.has("premiered") ? show.get("premiered").getAsString() : "Unknown",
                    show.has("ended") && !show.get("ended").isJsonNull() ? show.get("ended").getAsString() : "N/A",
                    show.has("network") && !show.get("network").isJsonNull() && show.get("network").getAsJsonObject().has("name") ?
                        show.get("network").getAsJsonObject().get("name").getAsString() : "N/A"
                );
                shows.add(s);
            }
        } catch (Exception e) {
            System.out.println("API Error: " + e.getMessage());
        }
        return shows;
    }
}
