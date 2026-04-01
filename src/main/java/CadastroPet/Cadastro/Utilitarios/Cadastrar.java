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
             String nome = lerEntrada(sc , "Nome Pet ");
             String sobrenome = lerEntrada(sc , "Sobrenome Pet");
            System.out.println("Gerando Id...");
             String idN = String.valueOf(nome.hashCode());String idS = String.valueOf(sobrenome.hashCode());
             String id = idN+idS;
             IdadePet idadePet = lerIdadePet(sc);
             String idade = idadePet.valor + " " + idadePet.unidade;
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
        public static boolean validarNome(String texto){
            if(texto.trim().isEmpty()) {
                return false;
            }
            return texto.matches("^[a-zA-ZÀ-ÖØ-öø-ÿ\\s]+$");

        }

        public static String lerEntrada(Scanner sc , String campo){
            System.out.println(campo + ": ");
            String entrada = sc.nextLine();
            while(!validarNome(entrada)){
                System.out.println("não pode haver caracteres especiais ou numero");
                System.out.print("Digite novamente: ");
                entrada = sc.nextLine();
            } return entrada;

        }
        public static IdadePet lerIdadePet(Scanner sc){
            while (true){
                System.out.println("Deseja cadastrar idade em ANOS ou MESES?");
                String opcao = sc.nextLine().toUpperCase().trim();
                if (opcao.equals("MESES")){
                    int meses = lerInteiro(sc, "Digite a quantidade em meses" , 1,12);
                    return new IdadePet(meses, "Meses");
                }
                if (opcao.equals("ANOS")){
                    int anos = lerInteiro(sc , "Digite a quantidade em anos" , 1 , 30);
                    return new IdadePet(anos , "Anos");

                }else {
                    System.out.println("Opção inválida! Digite apenas 'ANOS' ou 'MESES'.");
            }}

        }
        public record IdadePet(int valor, String unidade) {}
        public static int lerInteiro(Scanner sc , String mensagem, int min , int max){
            while (true){
                try {
                    System.out.println(mensagem + " (" + min + " a " + max + "): ");
                    int valor = Integer.parseInt(sc.nextLine());

                    if (valor >= min && valor <= max) {
                        return valor;
                    }
                    System.out.println("Erro: O valor deve estar entre " + min + " e " + max);

                } catch (NumberFormatException e){
                    System.out.println("ERRO: digite um numero valido");
                }
            }
        }

}

