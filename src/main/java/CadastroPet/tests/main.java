package CadastroPet.tests;

import CadastroPet.Cadastro.Utilitarios.BuscarPet;
import CadastroPet.Cadastro.Utilitarios.Cadastrar;

import java.util.Scanner;


public class main {

    static void main() {
        Cadastrar cadastrar = new Cadastrar();
        BuscarPet buscarPet = new BuscarPet();
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Cadastro de pet via linha de comando");
        System.out.println("O que deseja fazer Escolha uma das opções: ");
        System.out.println("[1] Cadastrar Pet");
        System.out.println("[2] Buscar Pet");
        System.out.println("[3] Deletar Pet");
        boolean menu = true;
        while (menu){
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    cadastrar.CadastrarPet();
                    break;
                case 2:
                    buscarPet.ListandoPet();
                    break;
                case 3:
                    menu = false;
                    break;
            }

        }
    }
}
