package model;

import util.FileManager;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


public class Controller {

    private ArrayList<Departamento> departamentos;

    private FileManager fileManager;

    public Controller() {
        fileManager = new FileManager();
       // departamentos = fileManager.loadCsv();
        departamentos = fileManager.loadJson();
    }

    // Burbuja
    public void sortByTotalMedals() {
        int n = departamentos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (departamentos.get(j).getTotalMedallas() < departamentos.get(j + 1).getTotalMedallas()) {
                    Departamento temp = departamentos.get(j);
                    departamentos.set(j, departamentos.get(j + 1));
                    departamentos.set(j + 1, temp);
                }
            }
        }
    }

    // Inserción
    public void sortByGoldMedals() {
        int n = departamentos.size();
        for (int i = 1; i < n; i++) {
            Departamento key = departamentos.get(i);
            int j = i - 1;
            while (j >= 0 && departamentos.get(j).getTotalGoldMedals() < key.getTotalGoldMedals()) {
                departamentos.set(j + 1, departamentos.get(j));
                j = j - 1;
            }
            departamentos.set(j + 1, key);
        }
    }


    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

}
