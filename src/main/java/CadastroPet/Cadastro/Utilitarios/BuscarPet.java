package CadastroPet.Cadastro.Utilitarios;

import CadastroPet.domain.Pet.Sexo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuscarPet {
    Cadastrar cadastrar = new Cadastrar();

    private Path dadosPath(){
        Path path = Paths.get("/home/hendrick/IdeaProjects/CadastroPet/DadosPet");
        return path;
    }

    public void ListandoPet(){
        Path path = dadosPath();
        if(!Files.exists(path)){
            try {
                System.out.println("Diretorio DadosPet criado.");
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException("Não foi possivel criar o diretorio " + e);
            }
        }
        System.out.println("========Pets Cadastrados==========");
        try (Stream<Path> arquivos = Files.list(path)){
            List<String> nomes = arquivos.filter(Files::isRegularFile)
                    .map(p -> p.getFileName().toString())
                    .filter(nome -> nome.endsWith(".txt"))
                    .map(nome -> nome.replace(".txt", ""))
                    .map(nome -> nome.replace("_", " "))
                    .toList();

            nomes.forEach(n -> System.out.println(" " + n + " "));

            int total = nomes.size();
            System.out.println("Total de registros no sistema: " + total);

        } catch (IOException e){
            e.getMessage();
        }
        System.out.println("=================================");
    }

    public void findPetFile(String nome){
        Path path = dadosPath();
       try (Stream<Path> stream = Files.list(path)){


       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    public void AlterarPet() {
        Scanner sc = new Scanner(System.in);
        Path path = dadosPath();
        while (true) {
            try (Stream<Path> stream = Files.list(path)) {
                Map<String, String> mapapets = stream.filter(Files::isRegularFile)
                        .map(p -> p.getFileName().toString())
                        .filter(nome -> nome.endsWith(".txt"))
                        .collect(Collectors.toMap(nomeArquivo -> nomeArquivo.replace(".txt", "").replace("_", " ").toLowerCase(),
                                nomeArquivo -> nomeArquivo
                        ));
                System.out.println("Qual o pet deseja alterar?");
                String nomeBuscado = sc.nextLine().toLowerCase();
                if (mapapets.containsKey(nomeBuscado)) {
                    String nomeArquivoReal = mapapets.get(nomeBuscado);
                    Path arquivoPet = path.resolve(nomeArquivoReal);

                    List<String> linhasArquivos = Files.readAllLines(arquivoPet);

                    System.out.println("Pet encontrado: " + nomeArquivoReal);

                    int opcao;
                    boolean alterando = true;
                    while (alterando) {
                        System.out.println("[1] Nome\n[2] Sobrenome\n[3] Idade\n[4] Sexo\n[0] Verificar Alterações");
                        try {
                            opcao = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Digite um numero valido");
                            continue;
                        }
                        switch (opcao) {
                            case 1:
                                String name = Cadastrar.lerEntrada(sc, "Nome: ");
                                linhasArquivos.set(0, "Nome: " + name);
                                break;
                            case 2:
                                String sobrenome = Cadastrar.lerEntrada(sc, "Sobrenome: ");
                                linhasArquivos.set(1, "Sobrenome: " + sobrenome);
                                break;
                            case 3:
                                Cadastrar.IdadePet idadePet = Cadastrar.lerIdadePet(sc);
                                String idade = idadePet.valor() +  " " + idadePet.unidade();
                                linhasArquivos.set(2, "Idade: " + idade);
                                break;
                            case 4:
                                linhasArquivos.set(3, "Sexo: " + sc.nextLine());
                                break;
                            case 0:
                                System.out.println("Dados atuais salvos");
                                System.out.println(linhasArquivos);
                                System.out.println("Confirmar Alterações ?");
                                System.out.println("\n[1] Salvar \n[2] Continuar Alterando");
                                int alternativa = Integer.parseInt(sc.nextLine());
                                if(alternativa == 1){
                                    Files.write(arquivoPet, linhasArquivos);
                                    alterando = false;
                                    System.out.println("Alterações salvas");
                                }else if(alternativa == 2){
                                    break;
                                }else {
                                    continue;
                                }
                            default:
                                System.out.println("Opção invalida");
                        }
                    }
                } else {
                    System.out.println("Pet nao encontrado,tente novamente");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

