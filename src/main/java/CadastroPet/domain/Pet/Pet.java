package CadastroPet.domain.Pet;

public class Pet {
    private String id;
    private String nome;
    private String sobrenome;
    private int idade;
    private Sexo sexo;


    public Pet(String nome, String sobrenome, int idade, Sexo sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Pet(String id, String nome, String sobrenome, int idade) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    public Pet(String id, String nome, String sobrenome, int idade, Sexo sexo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Sobrenome: " + sobrenome + "\n" +
                "Idade: " + idade + "\n" +
                "Sexo: " + sexo;

    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }
}
