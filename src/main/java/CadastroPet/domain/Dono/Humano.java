package CadastroPet.domain.Dono;
public class Humano {

    private String nome;
    private int idade;

    public Humano(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Humano(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }


}
