
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
                cartas.add(new Carta(code , "\u001B[30m\u001B[41m")); //vermelho
            }
        }

        for (int i = 0; i < paresAzuis; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "\u001B[30m\u001B[44m")); //azul
            }
        }
        for (int i = 0; i < parPreto; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "\u001B[37m\u001B[40m")); //preto
            }
        }
        for (int i = 0; i < paresAmarelos; i++) {
            String code = gerarRandomCode();
            for (int j = 0; j < 2; j++) {
                cartas.add(new Carta(code, "\u001B[30m\u001B[43m")); //amarelo
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
        return " " + c1 + c2 + "  ";
    }

    public static class Carta {
        private String codigo;
        private String corFundo;
        private boolean revelada;

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public void setCorFundo(String corFundo) {
            this.corFundo = corFundo;
        }

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

        public String getCodeCor() {
            return corFundo + codigo;
        }

        public boolean isRevelada(){
            return revelada;
        }

        public void setRevelada(boolean revelada){
            this.revelada = revelada;}
    }

    // Método para verificar se duas cartas reveladas sao um par
    public boolean verificarPar(int linha1, int coluna1, int linha2, int coluna2){
        return board[linha1][coluna1].getCodigo().equals(board[linha2][coluna2].getCodigo());
    }

    // Método para revelar uma carta
    public boolean revelarCarta(int linha, int coluna) {
        if (!board[linha][coluna].isRevelada()) { // Se a carta ainda estiver oculta
            board[linha][coluna].setRevelada(true);
            return true;
        } else {
            return false;
        }
    }

    // Método para ocultar duas cartas caso elas nao sejam um par
    public void ocultarCartas(int linha1, int coluna1, int linha2, int coluna2){
        board[linha1][coluna1].setRevelada(false);
        board[linha2][coluna2].setRevelada(false);
    }

    // Verifica se todas as cartas já foram encontradas

    public boolean todasAsCartasReveladas(){
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (!board[i][j].isRevelada()){
                    return false;
                }
            }
        }
        return true;
    }

    // Método para exibir o tabuleiro no terminal
    public void exibirTabuleiro(boolean revelarALL){
        System.out.println("MangaRosaMemoryGame:");
        System.out.print("   ");

        //Gera o cabeçalho numerado
        for (int j = 0; j < tamanho; j++){
            System.out.printf("%-5d" , (j + 1));
        }
        System.out.println();
        for (int i = 0; i < tamanho; i++){
            System.out.printf("%-3d" , (i + 1));
            for (int j = 0; j < tamanho; j++){
                if (board[i][j].isRevelada() || revelarALL){
                    System.out.printf("%-5s\u001B[0m", board[i][j].getCodeCor());
                } else{
                    System.out.printf("\u001B[30m\u001B[47m%-5s", "C");
                }
            }
            System.out.println("\u001B[0m");
        }
    }

    // Método para obter uma carta do tabuleiro
    public Carta getCarta(int x, int y) {
        return board[x][y];
    }
}
