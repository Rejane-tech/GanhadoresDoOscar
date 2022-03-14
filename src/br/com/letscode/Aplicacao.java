package br.com.letscode;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Aplicacao {


    private static LeituraDoArquivo leituraDoArquivoMasculino;
    private static LeituraDoArquivo leituraDoArquivoFeminino;

    private GanhadoresOscar atorlists;


    public static void main(String[] args) {

        leituraDoArquivoMasculino = new LeituraDoArquivo("oscar_age_male.csv");
        leituraDoArquivoFeminino = new LeituraDoArquivo("oscar_age_female.csv");

    }

    private void atorMaisJovemQueGanhouOscar() {
        System.out.println("Quem foi o ator mais jovem a ganhar um Oscar?");
        List<GanhadoresOscar> menuAtoreslist = leituraDoArquivoMasculino.getMenuAtoresList();
        menuAtoreslist.stream()
                .sorted(Comparator.comparing(GanhadoresOscar::getIdade))
                .findFirst();

    }

    private void atrizMaisVezesPremiada() {
        System.out.println("Quem foi a atriz que mais vezes foi premiada?");
        List<GanhadoresOscar> menuAtoreslist = leituraDoArquivoFeminino.getMenuAtoresList();
        Map<String, Long> map = menuAtoreslist.stream()
                .map(GanhadoresOscar::getNome)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(c -> System.out.println(c.getKey() + " premiada " + c.getValue() + "vezes"));
    }

    private void atrizEntreVinteTrintaAnosMaisPremiada() {
        System.out.println("Qual a atriz entre 20 e 30 anos que mais vezes foi vencedora?");
        List<GanhadoresOscar> menuAtoreslist = leituraDoArquivoFeminino.getMenuAtoresList();
        Map<String, Long> map = menuAtoreslist.stream()
                .filter(ganhadoresOscar -> (ganhadoresOscar.getIdade() >= 20 && ganhadoresOscar.getIdade() <= 30))
                .map(GanhadoresOscar::getNome)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(c -> System.out.println(c.getKey() + "vencedora entre 20 e 30 anos  " + c.getValue() + "premios"));
    }

    private void quaisAtoresReceberamMaisDeUmOscar(String nome) {
        System.out.println("Quais atores ou atrizes receberam mais de um Oscar? Elabore uma unica estrutura " +
                "contendo atores e atrizes");
        List<List<String>> atores = List.of(List.of("oscar_age_male.csv"), List.of("oscar_age_female.csv"));
        Stream<List<String>> stream = atores.stream();
        Stream<String> flatStream = stream.flatMap(list -> list.stream());
        long distinctAtores = flatStream.distinct().count();
        Map<String, Long> map = atorlists.stream()
                .map(GanhadoresOscar::getNome)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(c -> System.out.println(c.getKey() + " - " + c.getValue()));

    }

    private void resumoDePremios(String nome) {
        System.out.println("Quando informado o nome de um ator e atriz, dê um resumo de quantos prêmios ele/ela recebeu");
    }

    private void anoIdadeENomedoFilme(String nome) {
        System.out.println("Liste ano, idade e nome de cada filme pelo qual foi premiado");
        //professor daria para usar o index nesta questão ?
    }


}

