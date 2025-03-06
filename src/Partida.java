
import java.util.Scanner;

public class Partida {

    private Tabuleiro tabuleiro;
    private int tentativasInvalidas;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;

    // Variavel array para armazenar a linha da carta a ser revelada
    public static int[] linha = new int[2];

    // Variavel array para armazenar a coluna da carta a ser revelada
    public static int[] coluna = new int[2];

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
        System.out.println("\n|===================================|");
        System.out.println("| ======= Tabuleiro Inicial ======= |");

        tabuleiro.exibirTabuleiro(false);

        // Loop para permitir que o jogador escolha posições
        while (tentativasInvalidas < 3) {

            // Variavel array para armazenar a carta a ser revelada
            boolean[] cartaRevelada = new boolean[2];

            // Loop para garantir a requisição de duas cartas par serem reveladas e para verificar o par
            for (int i = 0; i < 2 ; i++) {
                mostrarPontuacao();
                System.out.println("\n|====================================|");
                System.out.println("| = Vez do jogador: " + jogadorAtual.getCor() + jogadorAtual.getNome() + "\u001B[0m = |");
                System.out.println("|====================================|");

                System.out.println("\n|====================================|");
                System.out.println("Escolha as posições da linha e coluna que deseja: ");
                System.out.println("Linha (1 a " + tabuleiro.getSize() + "): ");
                linha[i] = scanner.nextInt();

                System.out.println("Coluna (1 a " + tabuleiro.getSize() + "): ");
                coluna[i] = scanner.nextInt();



                // Vira a carta conforme a posição
                cartaRevelada[i] = tabuleiro.revelarCarta((linha[i] - 1), (coluna[i] - 1));
                if (cartaRevelada[i]) {
                    System.out.println("|===================================|");
                    System.out.println("| ===== Tabuleiro Atualizado =====  |");

                    // Exibe a carta no tabuleiro
                    tabuleiro.exibirTabuleiro(false);

                } else {
                    tentativasInvalidas++;
                    System.out.println("Você errou! Tentativas erradas: " + tentativasInvalidas);
                }
            }
            // Variavel para verificar se as cartas reveladas sao pares
            boolean parVerify = tabuleiro.verificarPar((linha[0] - 1), (coluna[0] - 1), (linha[1] - 1), (coluna[1] - 1));

            if (parVerify) {
                jogadorAtual.Pontuar(tabuleiro);

                tabuleiro.exibirTabuleiro(false);


                if (jogadorAtual.isCartaPreta()) {
                    // if para caso a carta preta tenha sido encontrada mas seu par também
                    System.out.println("=============================================================================");
                    System.out.println("O jogo acabou! " + jogadorAtual.getNome() + " venceu ao encontrar o par preto!");
                    System.out.println("==============================================================================");
                    mostrarPontuacao();
                    // Retorna para o menu apos finalizar o jogo
                    return;
                }
            }else {
                // Ocultar as cartas caso nao sejam pares
                tabuleiro.ocultarCartas((linha[0] - 1), (coluna[0] - 1), (linha[1] - 1), (coluna[1] - 1));
                // Alterna para o próximo jogador
                jogadorAtual.Pontuar(tabuleiro);
                tabuleiro.exibirTabuleiro(false);
                if (jogadorAtual.isCartaPreta()) {
                    // if para caso a carta preta tenha sido encontrada mas seu par não
                    System.out.println("=============================================================================");
                    System.out.println("O jogo acabou! "  + jogador1.getCor() +  jogadorAtual.getNome() + "\u001B[0m perdeu por não encontrar o par preto!");
                    System.out.println("================================================================================");
                    mostrarPontuacao();
                    // Retorna para o menu apos finalizar o jogo
                    return;
                } else {
                    trocarTurno();
                }
            }
        }

        // Verifica se o jogador perdeu a vez
        if (tentativasInvalidas == 3) {
            System.out.println("|===================================|");
            System.out.println("| = Você errou três vezes, perdeu = |");
            System.out.println("|===================================|");
            mostrarPontuacao();
        }

    }

    public void mostrarPontuacao() {
        System.out.println("\n|=========================================|");
        System.out.println("| =========== Pontuação atual =========== |");
        System.out.println("|=========================================|");
        System.out.println("| == Jogador: " + jogador1.getCor() + jogador1.getNome() + ": " + jogador1.getPontos() + "\u001B[0m pontos == |");
        System.out.println("| == Jogador: " + jogador2.getCor() + jogador2.getNome() + ": " + jogador2.getPontos() + "\u001B[0m pontos == |");
        System.out.println("|=========================================|");

    }

    private void trocarTurno() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }
}
