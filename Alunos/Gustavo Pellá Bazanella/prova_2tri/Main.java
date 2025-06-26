import model.Usuario;
import service.PersistenciaService;
import service.TvMazeService;
import view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersistenciaService persistencia = new PersistenciaService();
        Usuario usuario = persistencia.carregarUsuario();

        if (usuario == null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite seu nome: ");
            usuario = new Usuario(scanner.nextLine());
        }

        TvMazeService api = new TvMazeService();
        Menu menu = new Menu();
        menu.exibir(usuario, api, persistencia);
    }
}