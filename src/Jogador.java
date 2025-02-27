public class Jogador {
    private String nome;
    private String cor;
    private int pontucao;

    public Jogador(String nome, String cor, int pontuacao){
        this.nome = nome;
        this.cor = cor;
        this.pontucao = 0;
    }

    public String getNome(){
        return nome;
    }

    public String getCor(){
        return cor;
    }

    public int getPontucao(){
        return pontucao;
    }

    public void adicionarPontos(int pontos){
        this.pontucao += pontos;
        if (this.pontucao < 0){
            this.pontucao = 0;
        }
    }
}
