
import java.util.Scanner;

public class MangaRosaMemoryGame {

    private static Partida partida = null;// Agora a partida é uma variável de classe pq se não o valor não ia conseguir

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n|==================================|");
            System.out.println("|===== MANGA ROSA MEMORY GAME =====|");
            System.out.println("|==================================|");
            System.out.println("|1 - Iniciar Jogo                  |");
            System.out.println("|2 - Pontuação                     |");
            System.out.println("|3 - Regras                        |");
            System.out.println("|4 - Sair                          |");
            System.out.println("|==================================|");
            System.out.print("\nSelecione a opção desejada: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                iniciarJogo(scanner);
            } else if (opcao == 2) {
                System.out.println("Pontuação atual:");/* vai puxar a funcao mostrarPontuacao se nao for vazio */
                if (partida != null) {
                    partida.mostrarPontuacao();
                } else {
                    System.out.println("O jogo ainda não foi iniciado.");
                }
            } else if (opcao == 3) {
                System.out.println("Regras: O jogo consiste em virar cartas para formar pares de cartas");
                /* regras */

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
        System.out.println("\n|==================================|");
        System.out.println("| Escolha o tamanho do tabuleiro:  |");
        System.out.println("|==================================|");
        System.out.println("| 1 - 4x4                          |");
        System.out.println("| 2 - 6x6                          |");
        System.out.println("| 3 - 8x8                          |");
        System.out.println("| 4 - 10x10                        |");
        System.out.println("|==================================|");
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
        System.out.println("\n|==================================|");
        System.out.println("| === Nome do jogador 1: ");
        String nomeJogador1 = scanner.nextLine().trim();
        String corJogador1 = "\u001B[30m\u001B[44m"; //azul
        String NomeCorJogador1 = "azul";
        if (nomeJogador1.isEmpty()) {
            nomeJogador1 = "PARTICIPANTE01";
        }/* joguei para cima o if para ficar padrao "jogador1" caso nao coloque nenhum nome */

        //cria o objeto jogador
        Jogador jogador1 = new Jogador(nomeJogador1, corJogador1, NomeCorJogador1);

        //ainda falta alteração
        System.out.println("\n|==================================|");
        System.out.print("| === Nome do jogador 2: ");
        String nomeJogador2 = scanner.nextLine().trim();
        String corJogador2 = "\u001B[41m"; //vermelho
        String NomeCorJogador2 = "vermelho";

        if (nomeJogador2.isEmpty()) {
            // a ideia é que ele caso não coloque nada no nome, o nome será "PARTICIPANTE"
            nomeJogador2 = "PARTICIPANTE02";/* Nmesma coisa de cima */
        }
        //cria o objeto jogador
        Jogador jogador2 = new Jogador(nomeJogador2, corJogador2, NomeCorJogador2);

        //ainda falta alteração
        System.out.println("\n \n|==================================|");
        System.out.println("| === Tabuleiro " + tamanho + "x" + tamanho + " escolhido! === |");
        System.out.println("| ========== Jogadores: ========== |\n" +
                "| " + corJogador1 + nomeJogador1 + "\u001B[0m vs " + corJogador2 + nomeJogador2 + "\u001B[0m |");
        System.out.println("| ========== Boa sorte! ========== |");
        System.out.println("|==================================|");

        // Criar e iniciar a partida com o tamanho do tabuleiro e jogadores
        partida = new Partida(tamanho, jogador1, jogador2);/* Permitir acessar os pontos fora do metodo */
        partida.iniciar();
    }

}
