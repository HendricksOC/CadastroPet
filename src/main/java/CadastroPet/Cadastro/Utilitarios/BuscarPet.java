package CadastroPet.Cadastro.Utilitarios;

import java.io.IOException;
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

    private Path dadosPath(){
        Path path = Paths.get("C:\\Users\\hendr\\IdeaProjects\\CadastroPet\\DadosPet");
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
            arquivos.filter(Files::isRegularFile)
                    .map(p -> p.getFileName().toString())
                    .filter(nome -> nome.endsWith(".txt"))
                    .map(nome -> nome.replace(".txt", ""))
                    .map(nome -> nome.replace("_", " "))
                    .forEach(n -> System.out.println(" " + n));
        } catch (IOException e){
            e.getMessage();
        }
        System.out.println("=================================");
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
                    System.out.println("Pet encontrado: " + mapapets.get(nomeBuscado));
                } else {
                    System.out.println("Pet nao encontrado,tente novamente");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

