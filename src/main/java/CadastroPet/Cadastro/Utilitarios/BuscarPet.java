package CadastroPet.Cadastro.Utilitarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class BuscarPet {

    public void ListandoPet(){
        boolean painel = true;
        Path path = Paths.get("C:\\Users\\hendr\\IdeaProjects\\CadastroPet\\DadosPet");
        if(!Files.exists(path)){
            System.out.println("Diretorio DadosPet criado.");
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException("Não foi possivel criar o diretorio " + e);
            }
        }
        try (Stream<Path> arquivos = Files.list(path)){
            arquivos.filter(Files::isRegularFile)
                    .map(p -> p.getFileName().toString())
                    .filter(nome -> nome.endsWith(".txt"))
                    .map(nome -> nome.replace(".txt", ""))
                    .map(nome -> nome.replace("_", " "))
                    .forEach(n -> System.out.println("Pet: " + n));
        } catch (IOException e){
            e.getMessage();
        }
    }
}

