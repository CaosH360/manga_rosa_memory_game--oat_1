
public class Jogador {

    private String nome;
    private String cor;
    private String NomeCor;
    private int pontos;
    public boolean cartaPreta = false;

    /* Tava pontuacao, mudei para pontos */

    //Construtor
    public Jogador(String nome, String cor, String NomeCor) {
        this.nome = nome;
        this.cor = cor;
        this.NomeCor = NomeCor;
        this.pontos = 0;/* Adicionei o pontos no contrutor */

    }

    public boolean isCartaPreta() {
        return cartaPreta;
    }

    public void setCartaPreta(boolean parPreto) {
        this.cartaPreta = parPreto;
    }

    public String getNomeCor() {
        return NomeCor;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getPontos() {
        return pontos;/* Mudei para pontos */
    }

    public void Pontuar(Tabuleiro tabuleiro) {
        boolean parVerif = tabuleiro.verificarPar((Partida.linha[0] - 1), (Partida.coluna[0] - 1), (Partida.linha[1] - 1), (Partida.coluna[1] - 1));
        String corCarta = tabuleiro.getCarta((Partida.linha[0] - 1), (Partida.coluna[0] - 1)).getCorID();
        String corJogador = getNomeCor();
        if (parVerif){
            if (corCarta.equals("vermelho") && corJogador.equals("vemelho")) {
                pontos = pontos + 5;
                System.out.println("Você ganhou 5 ponto");
            }
            else if (corCarta.equals("vermelho") && corJogador.equals("azul")) {
            pontos = pontos + 1;
                System.out.println("Você ganhou 1 ponto");
            }
            else if (corCarta.equals("azul")  && corJogador.equals("azul")) {
                pontos = pontos + 5;
                System.out.println("Você ganhou 5 ponto");
            }
            else if (corCarta.equals("azul")  && corJogador.equals("vemelho")) {
                pontos = pontos + 1;
                System.out.println("Você ganhou 1 ponto");
            }
            else if (corCarta.equals("amarelo")) {
                pontos = pontos + 1;
                System.out.println("Você ganhou 1 ponto");
            }
            else if (corCarta.equals("preto")) {
                System.out.println("Você venceu o jogo por achar um par de cartas pretas");
                setCartaPreta(true);
            }
        }else {
            if (corCarta.equals("vermelho") && corJogador.equals("vemelho")) {
                pontos = pontos - 1;
                System.out.println("Você perdeu 1 ponto");
            }
            else if (corCarta.equals("vermelho") && corJogador.equals("azul")) {
                pontos = pontos - 2;
                System.out.println("Você perdeu 2 ponto");
            }
            else if (corCarta.equals("azul")  && corJogador.equals("azul")) {
                pontos = pontos - 1;
                System.out.println("Você perdeu 1 ponto");
            }
            else if (corCarta.equals("azul")  && corJogador.equals("vemelho")) {
                pontos = pontos - 2;
                System.out.println("Você perdeu 2 ponto");
            }
            else if (corCarta.equals("amarelo")) {
                pontos = pontos - 1;
                System.out.println("Você perdeu 1 ponto");
            }
            else if (corCarta.equals("preto")) {
                System.out.println("Você perdeu o jogo por nao encontrar o par de cartas pretas");
                setCartaPreta(true);
            }
        }
        if(pontos < 0) {
            pontos = 0;
        }
    }

    public boolean isEmpty() {
        return true;
    }
}
