import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import services.ApiRequester;
import services.SerieMapper;
import utils.JsonHandler;
import utils.JsonHandlerRegEx;

import javax.swing.JOptionPane;

import models.Serie;
import models.User;

public class App {
    public static void main(String[] args) throws Exception {
        //com jackson
        ver1();
        //com regex
        //ver2();
    }

    public static void ver1(){
        User user;
        ArrayList<Serie> favorites = null;
        ArrayList<Serie> toWatch = null;
        ArrayList<Serie> watching = null;

        if (!new File("data/user.json").exists()) {
            user = new User();
            user.setName("teste");
            JOptionPane.showMessageDialog(null, "Seja bem vindo " + user.getName(), "Bem vindo",
                    JOptionPane.INFORMATION_MESSAGE);
            favorites = new ArrayList<Serie>();
            toWatch = new ArrayList<Serie>();
            watching = new ArrayList<Serie>();
        } else {
            user = JsonHandler.readJson();
            System.out.println(user);
            System.exit(0);
        }

        String query = "breaking+bad";
        Serie serie = SerieMapper.singleSerieMapper(ApiRequester.getSingle(query));
        if (serie != null) {
            System.out.println(serie);
            favorites.add(serie);
        }

        ArrayList<Serie> series = SerieMapper.multipleSerieMapper(ApiRequester.getMultiple(query));
        if (series != null) {
            System.out.println(series);
            toWatch.addAll(series);
        }

        if (serie != null && series != null) {
            user.setFavorites(favorites);
            user.setToWatch(toWatch);
            JsonHandler.writeJson(user);
        }
    }

    public static void ver2(){
        String query = "breaking+bad";
        Map<String, Object> map = JsonHandlerRegEx.getJsonRegEx(ApiRequester.getSingle(query));
        System.out.println(map);
    }
}
