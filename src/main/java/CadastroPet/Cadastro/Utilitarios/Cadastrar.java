package CadastroPet.Cadastro.Utilitarios;

import CadastroPet.domain.Pet.Pet;
import CadastroPet.domain.Pet.Sexo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Cadastrar {
    public  void CadastrarPet() {
        Scanner sc = new Scanner(System.in);
        boolean menuCadastro = true;
        System.out.println("Cadastrando Pet");
        while(menuCadastro){
            try {

            } catch (IllegalArgumentException e){

            }
             System.out.println("Nome do Pet: ");
             String nome = sc.nextLine();
             System.out.println("Gerando Id...");
             System.out.println("Sobrenome: ");
             String sobrenome = sc.nextLine();
             String idN = String.valueOf(nome.hashCode());String idS = String.valueOf(sobrenome.hashCode());
             String id = idN+idS;
             System.out.println("Idade: ");
             int idade = sc.nextInt();
             sc.nextLine();
             System.out.println("Sexo do Pet: (FEMEA) OU (MACHO)");
             String sexoEs = sc.nextLine().toUpperCase().trim();
             Sexo sexo = null;
             try {
                 sexo = Sexo.valueOf(sexoEs);
                 System.out.println("Criado com sucesso");
             }catch (IllegalArgumentException e){
                 System.out.println("Argumento invalido");
                 e.printStackTrace();
             }
             Pet petCadastrado = new Pet(id,nome, sobrenome , idade, sexo);
             System.out.println(petCadastrado);
            EscreverPet(petCadastrado);
            System.out.println("Pet Cadastrado com sucesso!");
            menuCadastro = false;
        }
        }

        public static void EscreverPet(Pet pet){
            Path path = Paths.get("C:\\Users\\hendr\\IdeaProjects\\CadastroPet\\DadosPet");
            try {
                Files.createDirectories(path);
                System.out.println("Diretorio criado com sucesso");

            }catch (IOException e){
                System.out.println("Falha ao criar diretorio");
                e.printStackTrace();
            }

            String petFileName = pet.getNome() + "_" + pet.getSobrenome() + ".txt";
            File diretorio = new File(path.toUri());
            File file1 = new File(diretorio, petFileName);
            try (FileWriter fw = new FileWriter(file1);
                 BufferedWriter bw = new BufferedWriter(fw)){
                bw.write(pet.toString());
                bw.flush();

            } catch (IOException e) {
                throw new RuntimeException("Erro ao cadastrar o pet" + e);
            }
        }

    }
