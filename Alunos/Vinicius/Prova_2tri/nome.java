import java.io.*;
import com.google.gson.*;

public class Persistencia {
    private static final String ARQ = "usuarios.json";

    public static void salvar(Usuario u) {
        try (FileWriter w = new FileWriter(ARQ)) {
            new Gson().toJson(u, w);
        } catch (Exception e) {
            System.out.println("erro ao salvar: " + e.getMessage());
        }
    }

    public static Usuario carregar(String nome) {
        try (FileReader r = new FileReader(ARQ)) {
            Usuario u = new Gson().fromJson(r, Usuario.class);
            return (u != null && u.nome.equals(nome)) ? u : new Usuario(nome);
        } catch (Exception e) {
            return new Usuario(nome);
        }
    }
}
