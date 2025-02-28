package games.mangarosa.com.br;

import java.util.Scanner;

public class Partida {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private Scanner scanner;
    private boolean jogoAtivo;

    public Partida(int tamanho, String nomeJogador1, String nomeJogador2) {
        scanner = new Scanner(System.in);
        this.tabuleiro = new Tabuleiro(tamanho);
        this.jogador1 = new Jogador(nomeJogador1, "\uD83D\uDD34", 0);
        this.jogador2 = new Jogador(nomeJogador2, "\uD83D\uDD35", 0);
        this.jogadorAtual = jogador1;
        this.jogoAtivo = true;

    }

    public void iniciarJogo(){
        while (jogoAtivo) {
            jogarTurno(jogadorAtual);
            if (!jogoAtivo) break;
            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }
    }
}
