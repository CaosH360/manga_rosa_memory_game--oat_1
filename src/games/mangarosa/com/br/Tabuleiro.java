package games.mangarosa.com.br;

import java.util.*;

public class Tabuleiro {
    private Carta[][] board;
    private int tamanho;

    public Tabuleiro(int tamanho){
        this.tamanho = tamanho;
        board = new Carta[tamanho][tamanho];
        gerarTabuleiro();
    }

    public Carta[][] getBoard() {
        return board;
    }

    public int getSize(){
        return tamanho;
    }

    private void gerarTabuleiro(){
        //Distribuição das cartas
        int totalCartas = tamanho * tamanho;
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
                cartas.add(new Carta(code , "Vermelho"));
            }
        }

        for (int i = 0; i < paresAzuis; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "Azul"));
            }
        }
        for (int i = 0; i < parPreto; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "Preto"));
            }
        }
        for (int i = 0; i < paresAmarelos; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "Amarelo"));
            }
        }

        //Embaralha
        Collections.shuffle(cartas);

        //Preenche o tabuleiro
        Iterator<Carta> it = cartas.iterator();
        for (int i = 0; i < tamanho; i++){
            for (int j = 0; j < tamanho; j++){
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

    public void exibirTabuleiro(boolean revelarALL){
        System.out.println("Tabuleiro:");
        System.out.print("  ");

        //Gera o cabeçalho numerado
        for (int j = 0; j < tamanho; j++){
            System.out.printf("%-5d" , (j + 1));
        }
        System.out.println();
        for (int i = 0; i < tamanho; i++){
            System.out.printf("%-3d" , (i + 1));
            for (int j = 0; j < tamanho; j++){
                if (board[i][j].isRevelada() || revelarALL){
                    System.out.printf("%-5s" , board[i][j].getCodigo());
                } else{
                    System.out.printf("%-5s" , "C");
                }
            }
            System.out.println();
        }
    }

    public boolean virarCarta(int linha, int coluna) {
        // Verifica se as coordenadas são válidas
        if (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho) {
            Carta carta = board[linha][coluna];
            // Verifica se a carta já está revelada
            if (!carta.isRevelada()) {
                carta.setRevelada(true); // Revela a carta
                return true; // Sucesso: carta virada
            } else {
                System.out.println("Carta já está virada!");
                return false; // Carta já estava virada
            }
        } else {
            System.out.println("Posição inválida!");
            return false; // Posição inválida
        }
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
            this.revelada = revelada;
        }
    }
}