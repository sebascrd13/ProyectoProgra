package Proyecto;

public class tablero {
    private String[][] tablero;
    
    public tablero(String[][] tablero) {
        this.tablero = new String[6][6];
    }
    
    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = new String[6][6];
    }

} 