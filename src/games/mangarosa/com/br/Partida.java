package games.mangarosa.com.br;

import java.util.Scanner;

public class Partida {
    private Tabuleiro tabuleiro;
    private int tentativasInvalidas;

    public Partida(int tamanho, Jogador jogador1, Jogador jogador2) {
        this.tabuleiro = new Tabuleiro(tamanho);
        this.tentativasInvalidas = 0;
    }

    public void iniciar () {
        Scanner scanner = new Scanner(System.in);

        // Exibe o tabuleiro inicial
        System.out.println("\nTabuleiro Inicial:");
        tabuleiro.exibirTabuleiro(false);

        // Loop para permitir que o jogador escolha posições
        while (tentativasInvalidas < 3) {
            System.out.println("Escolha as posições da linha e coluna que deseja: ");
            System.out.println("Você deseja a linha de 0 a " + (tabuleiro.getSize() - 1) + "): ");
            int linha = scanner.nextInt();

            System.out.println("Você deseja a coluna de 0 a " + (tabuleiro.getSize() - 1) + "): ");
            int coluna = scanner.nextInt();

            // Tenta virar a carta
            boolean sucesso = tabuleiro.revelarCarta(linha, coluna);
            if (sucesso) {
                System.out.println("\nTabuleiro Atualizado:");
                tabuleiro.exibirTabuleiro(false);
                break;
            } else {
                tentativasInvalidas ++;
                System.out.println("Você perdeu, você errou : " + tentativasInvalidas);
            }

        }

        // Verifica se o jogador perdeu a vez
        if ( tentativasInvalidas == 3 ){
            System.out.println("Você errou três vezes, perdeu!");
        }

        scanner.close(); // Fecha o Scanner
    }
}