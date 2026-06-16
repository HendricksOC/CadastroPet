package CadastroPet.Cadastro.Utilitarios;

import CadastroPet.domain.Pet.Pet;
import CadastroPet.domain.Pet.Sexo;

import java.util.Random;

public class GeneratorPets {
    public void GenPets(int quantidade){

        String[] nomes = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo",
                "Fernanda", "Gabriel", "Helena", "Igor", "Julia",
                "Lucas", "Mariana", "Nicolas", "Olivia", "Pedro",
                "Quintino", "Rafael", "Sofia", "Thiago", "Ursula",
                "Victor", "Wesley", "Xavier", "Yasmin", "Zelia",
                "Amanda", "Beatriz", "Camila", "Diego", "Elaine",
                "Felipe", "Gustavo", "Henrique", "Isabela", "Joao"
        };
        String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Souza", "Rodrigues",
                "Ferreira", "Alves", "Pereira", "Lima", "Gomes",
                "Costa", "Ribeiro", "Martins", "Carvalho", "Almeida",
                "Lopes", "Soares", "Fernandes", "Vieira", "Barbosa",
                "Rocha", "Dias", "Mendes", "Nunes", "Machado",
                "Moreira", "Marques", "Freitas", "Batista", "Pinto",
                "Melo", "Cavalcanti", "Monteiro", "Castro", "Tavares"
        };
        Sexo[] sexos ={Sexo.MACHO, Sexo.FEMEA};
        String[] ageTypes = {"MESES", "ANOS"};
        Random random = new Random();
        int petSalvos = 0;

        while(petSalvos < quantidade) {
            String nome = nomes[random.nextInt(nomes.length)];
            String sobrenome = sobrenomes[random.nextInt(nomes.length)];
            String ageType = ageTypes[random.nextInt(ageTypes.length)];
            Sexo sexo = sexos[random.nextInt(sexos.length)];
            int valorIdade;
            if (ageType.equals("MESES")){
                valorIdade = random.nextInt(11) + 1;
            }else{
                valorIdade = random.nextInt(15) + 1;
            }
            String idade = valorIdade + " " + ageType;
            Pet petCadastrado = new Pet(nome, sobrenome, idade , sexo);
            Cadastrar.EscreverPet(petCadastrado);
            petSalvos++;
            System.out.println("Cadastrando :" + nome.toUpperCase() + " " + sobrenome.toUpperCase());
        }
        System.out.println("Total de cadastros:" + petSalvos);
    }
}
