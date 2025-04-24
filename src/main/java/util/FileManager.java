package util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Departamento;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private File data;
    private Path dataFolder;
    private Path dataJson;
    private Path dataCsv;
    private List<Departamento> departamentos ;

    public FileManager(){
        /*Path dataProject = Paths.get(System.getProperty("user.dir"));
        dataFolder = dataProject.resolve(dataProject+"/src/main/data");
        dataCsv = dataFolder.resolve("data.csv");*/

        departamentos = new ArrayList<>();
        Path dataProject = Paths.get(System.getProperty("user.dir"));
        dataFolder = dataProject.resolve(dataProject+"/src/main/data");
        dataJson = dataFolder.resolve("departamentos.json");

    }

    public void inicialize() throws IOException {
        if(!Files.exists(dataFolder)){
            Files.createDirectories(dataFolder);
            if(!Files.exists(dataCsv)){
                Files.createFile(dataCsv);
            }
        }
    }

    public ArrayList<Departamento> loadJson() {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        try {
            String jsonData = Files.readString(dataJson);
            Gson gson = new Gson();
            Type list = new TypeToken<ArrayList<Departamento>>(){}.getType();
            departamentos = gson.fromJson(jsonData, list);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return departamentos;
    }


    /* public ArrayList<Departamento> loadCsv(){
        ArrayList<Departamento> departamentos = new ArrayList<>();
        try {
            inicialize();
            List<String> csvData = Files.readAllLines(dataCsv, StandardCharsets.UTF_8);
            for(String line: csvData){
                String[] params = line.split(";");
                Departamento departamento = new Departamento(
                        params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]),
                        Integer.parseInt(params[4]), Integer.parseInt(params[5]), Integer.parseInt(params[6]),
                        Integer.parseInt(params[7]), Integer.parseInt(params[8]), Integer.parseInt(params[9])
                );
                departamentos.add(departamento);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return departamentos;
    } */
}
