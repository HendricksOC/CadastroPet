package CadastroPet.domain.Pet;

public class Pet {
    private String nome;
    private String sobrenome;
    private String idade;
    private Sexo sexo;


    public Pet(String nome, String sobrenome, String idade, Sexo sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Pet(String nome, String sobrenome, String idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getIdade() {
        return idade;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNome() {
        return nome;
    }
}

