package br.com.letscode;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeituraDoArquivo {


    private final List<GanhadoresOscar> menuAtoresList;

    public LeituraDoArquivo(String filename) {
        this.menuAtoresList = lerArquivo(filename);
    }

    private List<GanhadoresOscar> lerArquivo(String filename) {
        try (Stream<String> fileLines = Files.lines(Paths.get(filename))) {
            return fileLines
                    .skip(1)
                    .map(GanhadoresOscar::of)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<GanhadoresOscar> getMenuAtoresList() {
        return menuAtoresList;
    }
}






