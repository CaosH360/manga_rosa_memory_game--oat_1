package games.mangarosa.com.br;
import java.util.Scanner;

public class MangaRosaMemoryGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MANGA ROSA MEMORY GAME =====");
            System.out.println("1 - Iniciar Jogo");
            System.out.println("2 - Pontuação");
            System.out.println("3 - Regras");
            System.out.println("4 - Sair");
            System.out.print("\n Selecione a opção desejada: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                iniciarJogo(scanner);
            } else if (opcao == 2) {
                System.out.println("IMPLEMENTAR PONTUAÇÕES");

            } else if (opcao == 3) {
                System.out.println("IMPLEMENTAR REGRAS");

            } else if (opcao == 4) {
                System.out.println("Até logo!...");
                break;

            } else {
                System.out.println("Não foi possível selecionar a opção, tente novamente.");
            }
        }

        scanner.close();
    }

    private static void iniciarJogo(Scanner scanner) {
        System.out.println("\nEscolha o tamanho do tabuleiro: ");
        System.out.println("1 - 4x4");
        System.out.println("2 - 6x6");
        System.out.println("3 - 8x8");
        System.out.println("4 - 10x10");
        System.out.print("Opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine();
        int tamanho;
        
        if (escolha == 1) {
            tamanho = 4;
        } else if (escolha == 2) {
            tamanho = 6;
        } else if (escolha == 3) {
            tamanho = 8;
        } else if (escolha == 4) {
            tamanho = 10;
        } else {
            System.out.println("Opção inválida, tente novamente.");
            return;
        }

        Tabuleiro tabuleiro = new Tabuleiro(tamanho);

        System.out.println("Nome do jogador 1: ");
        String nomeJogador1 = scanner.nextLine().trim();
        String corJogador1 = "\u001B[44m";

        //cria o objeto jogador
        Jogador jogador1 = new Jogador(nomeJogador1, corJogador1);

        //ainda falta alteração
        if (jogador1.isEmpty()){
            nomeJogador1 = "PARTICIPANTE01";
        }

        System.out.print("\nNome do jogador 2: ");
        String nomeJogador2 = scanner.nextLine().trim();
        String corJogador2 = "\u001B[41m";

        //cria o objeto jogador
        Jogador jogador2 = new Jogador(nomeJogador2, corJogador2);

        //ainda falta alteração
        if (jogador2 == " ") {
            // tá dando erro e fazer com que se o nome do jogador estiver vazio, o nome dele será:
            nomeJogador2 = "PARTICIPANTE02";
        }

        System.out.println("Tabuleiro " + tamanho + "x" + tamanho + " escolhido!");
        System.out.println("Jogadores: " + nomeJogador1 + " vs " + nomeJogador2);
        System.out.println("Boa sorte!");

        // Criar e iniciar a partida com o tamanho do tabuleiro e jogadores
        Partida partida = new Partida(tamanho, jogador1, jogador2);
        partida.iniciar();
    }


}