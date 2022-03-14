package br.com.letscode;

public class GanhadoresOscar {


    private Integer index;
    private Integer ano;
    private Integer idade;
    private String nome;
    private String nomeDoFilme;


    private GanhadoresOscar(Integer index, Integer ano, Integer idade, String nome, String nomeDoFilme) {
        this.index = index;
        this.ano = ano;
        this.idade = idade;
        this.nome = nome;
        this.nomeDoFilme = nomeDoFilme;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public void setNomeDoFilme(String nomeDoFilme) {
        this.nomeDoFilme = nomeDoFilme;
    }

    public static GanhadoresOscar of(String line) {
        String[] split = line.split("; (?=\\S)");
        return new GanhadoresOscar(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2]),
                split[0],
                split[1]


        );
    }

    @Override
    public String toString() {
        return "GanhadoresOscar{" +
                "index=" + index +
                ", ano=" + ano +
                ", idade=" + idade +
                ", nome='" + nome + '\'' +
                ", nomeDoFilme='" + nomeDoFilme + '\'' +
                '}';
    }


}
