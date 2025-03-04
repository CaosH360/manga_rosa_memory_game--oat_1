
import java.util.Scanner;

public class Partida {

    private Tabuleiro tabuleiro;
    private int tentativasInvalidas;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    public Partida(int tamanho, Jogador jogador1, Jogador jogador2) {
        this.tabuleiro = new Tabuleiro(tamanho);
        this.tentativasInvalidas = 0;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogadorAtual = jogador1; // Começa com o primeiro jogador
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        // Exibe o tabuleiro inicial
        System.out.println("\nTabuleiro Inicial:");
        tabuleiro.exibirTabuleiro(false);

        // Loop para permitir que o jogador escolha posições
        while (tentativasInvalidas < 3) {
            System.out.println("\nVez do jogador: " + jogadorAtual.getCor() + jogadorAtual.getNome() + "\u001B[0m");

            System.out.println("Escolha as posições da linha e coluna que deseja: ");
            System.out.println("Linha (1 a " + tabuleiro.getSize() + "): ");
            int linha = scanner.nextInt();

            System.out.println("Coluna (1 a " + tabuleiro.getSize() + "): ");
            int coluna = scanner.nextInt();

            // Tenta virar a carta
            boolean sucesso = tabuleiro.revelarCarta((linha - 1), (coluna - 1));
            if (sucesso) {
                System.out.println("\nTabuleiro Atualizado:");
                tabuleiro.exibirTabuleiro(false);
                System.out.println("Vc ganhou 1 ponto");/* Informa o ponto que o jogador ganhou */
                jogadorAtual.aumentarPontos();/* Adiciona o ponto do jogador */
            } else {
                tentativasInvalidas++;
                System.out.println("Você errou! Tentativas erradas: " + tentativasInvalidas);
            }

            // Alterna para o próximo jogador
            trocarTurno();
        }

        // Verifica se o jogador perdeu a vez
        if (tentativasInvalidas == 3) {
            System.out.println("Você errou três vezes, perdeu!");
        }
    }

    public void mostrarPontuacao() {
        System.out.println("\nPontuação atual:");
        System.out.println("Jogador: " + jogador1.getNome() + ": " + jogador1.getPontos() + " pontos");
        System.out.println("Jogador: " + jogador2.getNome() + ": " + jogador2.getPontos() + " pontos");
    }

    private void trocarTurno() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }
}
