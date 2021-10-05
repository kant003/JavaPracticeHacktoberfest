public class fabiopintos4 extends JFrame {
        JLabel barraEstado;
    
        public Tetris(){
            barraEstado = new JLabel(" 0");
            add(barraEstado, BorderLayout.SOUTH);
            Tablero tablero = new Tablero(this);
            add(tablero);
            tablero.start();
    
            setSize(200, 400);
            setTitle("Tetris");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    
        public JLabel getBarraEstado(){
            return barraEstado;
        }
    
        public static void main(String[] args){
            Tetris juego = new Tetris();
            juego.setLocationRelativeTo(null);
            juego.setVisible(true);
        }


}
