package games.mangarosa.com.br;

import java.util.*;

public class Tabuleiro {
    private Carta[][] board;
    private int size;

    public Tabuleiro(int size){
        this.size = size;
        board = new Carta[size][size];
        gerarTabuleiro();
    }

    public Carta[][] getBoard() {
        return board;
    }

    public int getSize(){
        return size;
    }

    private void gerarTabuleiro(){
        //Distribuição das cartas
        int totalCartas = size * size;
        int totalPares = totalCartas / 2;
        int blueRedpares = totalPares / 2;
        int parPreto = 1;
        int paresAmarelos = totalPares - blueRedpares - parPreto;
        int paresVermelhos = blueRedpares / 2;
        int paresAzuis = blueRedpares - paresVermelhos;

        List<Carta> cartas = new ArrayList<>();

        //Vai gerar pares com os fundos corretos
        for (int i = 0; i < paresVermelhos; i++){
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++){
                cartas.add(new Carta(code , "\u001B[41m"));
            }
        }

        for (int i = 0; i < paresAzuis; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "\u001B[44m"));
            }
        }
        for (int i = 0; i < parPreto; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "\u001B[40m"));
            }
        }
        for (int i = 0; i < paresAmarelos; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "\u001B[43m"));
            }
        }

        //Embaralha
        Collections.shuffle(cartas);

        //Preenche o tabuleiro
        Iterator<Carta> it = cartas.iterator();
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = it.next();
            }
        }
    }

    //Gera o codigo aleatorio
    private String gerarRandomCode(){
        String chars = "ABCDEFGHIJKLMNOPRSTUVWXYZ123456789";
        Random rand = new Random();
        char c1 = chars.charAt(rand.nextInt(chars.length()));
        char c2 = chars.charAt(rand.nextInt(chars.length()));
        return "" + c1 + c2;
    }

    public static class Carta {
        private String codigo;
        private String corFundo;
        private boolean revelada;

        public Carta(String codigo, String corFundo){
            this.codigo = codigo;
            this.corFundo = corFundo;
            this.revelada = false;
        }

        public String getCodigo(){
            return codigo;
        }

        public String getCorFundo(){
            return corFundo;
        }

        public boolean isRevelada(){
            return revelada;
        }

        public void setRevelada(boolean revelada){
            this.revelada = revelada;}
    }

    // Método para verificar se duas cartas reveladas sao um par
    public boolean verificarPar(int x1, int y1, int x2, int y2){
        return board[x1][y2].getCodigo().equals(board[x2][y2].getCodigo());
    }

    // Método para revelar uma carta
    public void revelarCarta(int x, int y){
        board[x][y].setRevelada(true);
    }

    // Método para ocultar duas cartas caso elas nao sejam um par
    public void ocultarCartas(int x1, int y1, int x2, int y2){
        board[x1][y1].setRevelada(false);
        board[x2][y2].setRevelada(false);
    }

    // Verifica se todas as cartas já foram encontradas

    public boolean todasAsCartasReveladas(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!board[i][j].isRevelada()){
                    return false;
                }
            }
        }
        return true;
    }

    // Método para exibir o tabuleiro no terminal
    public void exibirTabuleiro(boolean revelarALL){
        System.out.println("games.mangarosa.com.br.MangaRosaMemoryGame:");
        System.out.print("  ");

        //Gera o cabeçalho numerado
        for (int j = 0; j < size; j++){
            System.out.printf("%-5d" , (j + 1));
        }
        System.out.println();
        for (int i = 0; i < size; i++){
            System.out.printf("%-3d" , (i + 1));
            for (int j = 0; j < size; j++){
                if (board[i][j].isRevelada() || revelarALL){
                    System.out.printf("%-5s" , board[i][j].getCodigo());
                } else{
                    System.out.printf("%-5s" , "C");
                }
            }
            System.out.println();
        }
    }

    // Método para obter uma carta do tabuleiro
    public Carta getCarta(int x, int y) {
        return board[x][y];
    }

}
