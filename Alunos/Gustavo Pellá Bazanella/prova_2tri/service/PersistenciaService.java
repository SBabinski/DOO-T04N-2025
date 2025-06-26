package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Usuario;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaService {
    private static final String ARQUIVO = "data/usuario.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void salvarUsuario(Usuario usuario) {
        try (FileWriter writer = new FileWriter(ARQUIVO)) {
            gson.toJson(usuario, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    public Usuario carregarUsuario() {
        try (FileReader reader = new FileReader(ARQUIVO)) {
            return gson.fromJson(reader, Usuario.class);
        } catch (IOException e) {
            return null;
        }
    }
}