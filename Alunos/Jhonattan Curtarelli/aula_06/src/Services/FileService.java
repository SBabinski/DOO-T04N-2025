package src.Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Classe responsável por manipular arquivos:
 * Criar o arquivo,
 * Ler o arquivo,
 * Escrever no arquivo
 */
public class FileService {
    private String path;
    private String fileName;
    private File file;
    private FileWriter fileWriter;

    public FileService(String path, String fileName) {
        this.path = (path != null) ? path : Paths.get("").toAbsolutePath().toString();
        this.fileName = (fileName != null) ? fileName : "database.txt";
    }

    public void CreateFile() throws IOException {
        this.file = new File(this.path + "/" + this.fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        this.fileWriter = new FileWriter(file, true);
    }

    public void WriteFile(String content) throws IOException {
        if (this.fileWriter == null) {
            this.CreateFile();
        }

        this.fileWriter.write(content + System.lineSeparator());
        this.fileWriter.flush();
    }

    public List<String> ReadFile() throws IOException {
        return Files.readAllLines(Paths.get(this.file.getPath()));
    }
}
