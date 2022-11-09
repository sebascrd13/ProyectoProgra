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
        this.tablero = tablero;
    }

    public void llenarTabCPU(){

    }

    public void impTablero(String[][] tablero){
        System.out.println("\n");
        System.out.println("  ===========================");
        System.out.println("             TABLERO         ");
        System.out.println("  ===========================");
        System.out.println("     A   B   C   D   E   F");
        System.out.println("   _________________________");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i+": | ");
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = " ";
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   |---|---|---|---|---|---|");
        }
        
    }


} 

