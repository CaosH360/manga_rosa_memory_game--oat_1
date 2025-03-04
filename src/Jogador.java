
public class Jogador {

    private String nome;
    private String cor;
    private int pontos;

    /* Tava pontuacao, mudei para pontos */

    //Construtor
    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.pontos = 0;/* Adicionei o pontos no contrutor */
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

    public void aumentarPontos() {
        this.pontos++;
        /* metodo para adicionar pontos */
    }

    public boolean isEmpty() {
        return true;
    }
}
