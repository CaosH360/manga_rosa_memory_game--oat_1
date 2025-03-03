public class Jogador {
    private String nome;
    private String cor;
    private int pontucao = 0;

    //Construtor
    public Jogador(String nome, String cor){
        this.nome = nome;
        this.cor = cor;
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

    public boolean isEmpty() {
        return true;
    }
}
