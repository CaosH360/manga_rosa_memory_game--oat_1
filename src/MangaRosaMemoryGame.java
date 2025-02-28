package games.mangarosa.com.br;
import java.util.Scanner;

public class MangaRosaMemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nJogo da Memória");
            System.out.println("1 - Start");
            System.out.println("2 - Pontuação");
            System.out.println("3 - Regras");
            System.out.println("4 - Sair");
            System.out.print("Selecione o número da opção desejada:");

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

        System.out.print("\nNome do jogador 1: ");
        String jogador1 = scanner.nextLine().trim();

        if (jogador1.isEmpty()) {

            jogador1 = "PARTICIPANTE01";

        }
        System.out.print("\nNome do jogador 2: ");
        String jogador2 = scanner.nextLine().trim();

        if (jogador2.isEmpty()) {

            jogador2 = "PARTICIPANTE02";

        }

        System.out.println("\nTabuleiro " + tamanho + "x" + tamanho + " escolhido!");
        System.out.println("Jogadores: " + jogador1 + " vs " + jogador2);
        System.out.println("Boa sorte!");

        //ESPAÇO RESERVADO PARA A LÓGICA DO JOGO + TABULIRO DE TESTE
        mostrarTabuleiro(tamanho);
    }

    private static void mostrarTabuleiro(int tamanho) {
        System.out.println("\nTabuleiro: ");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print("C ");
            }
            System.out.println();
        }
    }
}




