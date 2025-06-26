package util;

import model.Serie;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenadorSeries {
    public static void ordenarPorNome(List<Serie> lista) {
        Collections.sort(lista, Comparator.comparing(Serie::getNome));
    }
}