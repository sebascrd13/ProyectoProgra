package Proyecto;

import java.util.Random;

import javax.swing.JOptionPane;

public class Juego {
    private Jugador usuario;
    private Jugador CPU;
    private String tabCPU[][];
    private String tabUsuario[][];
    
    

    public Juego(Jugador usuario, Jugador CPU, tablero tabCPU, tablero tabUsuario){
        this.usuario = usuario;
        this.CPU = CPU;
        this.tabCPU = new String[6][6];
        this.tabUsuario = new String[6][6];
    }
    
    public String[][] getTabCPU() {
        return tabCPU;
    }

    public void setTabCPU(String [][]tabCPU) {
        this.tabCPU = tabCPU;
    }

    public String[][] getTabUsuario() {
        return tabUsuario;
    }

    public void setTabUsuario(String[][] tabUsuario) {
        this.tabUsuario = tabUsuario;
    }

    public Jugador getUsuario(){
        return usuario;
    }

    public Jugador getCPU(){
        return CPU;
    }
    
    public void impTabBlanco(){
        System.out.println("\n");
        System.out.println("  ===========================");
        System.out.println("           "+usuario.getNombre()+"         ");
        System.out.println("  ===========================");
        System.out.println("     A   B   C   D   E   F");
        System.out.println("   _________________________");
        for (int i = 0; i < tabUsuario.length; i++) {
            System.out.print(i+": | ");
            for (int j = 0; j < tabUsuario.length; j++) {
                tabUsuario[i][j] = " ";
                System.out.print(tabUsuario[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   |---|---|---|---|---|---|");
        }
        
        System.out.println("\n");
        System.out.println("  ===========================");
        System.out.println("           "+CPU.getNombre()+"        ");
        System.out.println("  ===========================");
        System.out.println("     A   B   C   D   E   F");
        System.out.println("   _________________________");
        for (int i = 0; i < tabCPU.length; i++) {
            System.out.print(i+": | ");
            for (int j = 0; j < tabCPU.length; j++) {
                tabCPU[i][j] = " ";
                System.out.print(tabCPU[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   |---|---|---|---|---|---|");
        }        
    }

    public void llenarTab(){
        
        String naves [] = {"Almirante","Capitán 1","Capitán 2",
        "Teniente 1","Teniente 2","Teniente 3"};

        int ubicacionesN [] = new int[6];
        int ubicacionesL [] = new int[6];

        boolean flag = true;
               
        while (flag) {
            byte op_llenar = Byte.parseByte(JOptionPane.showInputDialog(
            "OPCIONES PARA LLENAR TABLERO" +"\n"+
            "1. Manual" + "\n" + 
            "2. Aleatorio"));

            if (op_llenar == 1) {
                for (int i = 0; i < naves.length; i++) {
                    int ubiNum = Integer.parseInt(JOptionPane.showInputDialog(
                        "Coordenada en fila de: "+ naves[i]));                       //Se llena el tablero del usuario 
                    int ubiLet = Integer.parseInt(JOptionPane.showInputDialog(       //de manera manual
                        "Coordenada en columna de: "+ naves[i] +"\n" +
                        "A=0    B=1    C=2    D=3    E=4    F=5"));
                    ubicacionesL [i] = ubiLet;
                    ubicacionesN [i] = ubiNum;
                }                
                JOptionPane.showMessageDialog(null,
                    "Usted ha llenado su tablero"); 
                flag = false;               
            }
          
            if (op_llenar == 2) {
                
                int i = 0;
                while (i < 5) {
                    boolean valid=true;
                    Random random = new Random();                                  //Se llena el tablero del usuario
                    int randomN = random.nextInt(6);                        // de manera aleatoria
                    int randomL = random.nextInt(6);
                    for (int j = 0; j < ubicacionesN.length; j++) {
                        for (int k = 0; k < ubicacionesL.length; k++) {
                            if (ubicacionesN[j] == randomN || ubicacionesL[k] == randomL){
                            valid = false;
                            }
                        }
                    }
                    if (valid) {
                        ubicacionesN[i] = randomN;
                        ubicacionesL[i] = randomL;
                        i++;
                    }                              
                }
                flag = false;
               
            }
            usuario.getAlmirante().setUbiNum(ubicacionesN[0]);
            usuario.getAlmirante().setUbiLet(ubicacionesL[0]);
            
            usuario.getCapi1().setUbiNum(ubicacionesN[1]);
            usuario.getCapi1().setUbiLet(ubicacionesL[1]);              
                                                                        
            usuario.getCapi2().setUbiNum(ubicacionesN[2]);          //Se le asigan las posiciones
            usuario.getCapi2().setUbiLet(ubicacionesL[2]);          //a las naves del usuario
            
            usuario.getTeniente1().setUbiNum(ubicacionesN[3]);
            usuario.getTeniente1().setUbiLet(ubicacionesL[3]);
            
            usuario.getTeniente2().setUbiNum(ubicacionesN[4]);
            usuario.getTeniente2().setUbiLet(ubicacionesL[4]);
            
            usuario.getTeniente3().setUbiNum(ubicacionesN[5]);
            usuario.getTeniente3().setUbiLet(ubicacionesL[5]);
        }

        tabUsuario[ubicacionesN[0]][ubicacionesL[0]] = "4";
        tabUsuario[ubicacionesN[1]][ubicacionesL[1]] = "3";       //Se le asigna un valor a la posición
        tabUsuario[ubicacionesN[2]][ubicacionesL[2]] = "3";       //de cada nave del usuario
        tabUsuario[ubicacionesN[3]][ubicacionesL[3]] = "1";
        tabUsuario[ubicacionesN[4]][ubicacionesL[4]] = "1";
        tabUsuario[ubicacionesN[5]][ubicacionesL[5]] = "1";

        tabCPU[2][4] = "4";
        tabCPU[5][1] = "3";       //Se le asigna un valor a la posición
        tabCPU[4][0] = "3";       //de cada nave del CPU
        tabCPU[0][3] = "1";
        tabCPU[1][2] = "1";
        tabCPU[3][5] = "1";
        
        
    }

    public void impTabUser(){
        System.out.println("\n");
        System.out.println("  ===========================");
        System.out.println("           "+usuario.getNombre()+"        ");
        System.out.println("  ===========================");
        System.out.println("     A   B   C   D   E   F");
        System.out.println("   _________________________");
        for (int i = 0; i < tabUsuario.length; i++) {
            System.out.print(i+": | ");
            for (int j = 0; j < tabUsuario.length; j++) {
                System.out.print(tabUsuario[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   |---|---|---|---|---|---|");
        }
        System.out.println("Naves:" + "\n" + 
        "Almirante: " + usuario.getAlmirante().getVida() + "\n" +
        "Capitán 1: " + usuario.getCapi1().getVida() + "\n" +
        "Capitán 2: " + usuario.getCapi2().getVida() + "\n" +
        "Teniente 1: " + usuario.getTeniente1().getVida() + "\n" +
        "Teniente 2: " + usuario.getTeniente2().getVida() + "\n" +
        "Teniente 3: " + usuario.getTeniente3().getVida());
        

   
        
    }


    public void atacarCPU(){
        byte atacaN = Byte.parseByte(JOptionPane.showInputDialog(
            "Fila de Ataque: "));
        byte atacaL = Byte.parseByte(JOptionPane.showInputDialog(
            "Columna de Ataque: " + "\n" + "A=0  B=1  C=2  D=3  E=4  F=5"));
        
        for (int i = 0; i < tabCPU.length; i++) {
            for (int j = 0; j < tabCPU.length; j++) {
                if (tabCPU[atacaN][atacaL] == "4") {
                    tabCPU[atacaN][atacaL] = "3";  
                    CPU.getAlmirante().setAtaque();;                                     
                }
                                  
            }            
        }

        
    }

    public void trampa(){
        System.out.println("  ===========================");
        System.out.println("           "+CPU.getNombre()+"        ");
        System.out.println("  ===========================");
        System.out.println("     A   B   C   D   E   F");
        System.out.println("   _________________________");
        for (int i = 0; i < tabCPU.length; i++) {
            System.out.print(i + ": | ");
            for (int j = 0; j < tabCPU.length; j++) {
                System.out.print(tabCPU[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   |---|---|---|---|---|---|");
        }
        System.out.println();
        System.out.println("Naves:" + "\n" + 
        "Almirante: " + CPU.getAlmirante().getVida() + "\n" +
        "Capitán 1: " + CPU.getCapi1().getVida() + "\n" +
        "Capitán 2: " + CPU.getCapi2().getVida() + "\n" +
        "Teniente 1: " + CPU.getTeniente1().getVida() + "\n" +
        "Teniente 2: " + CPU.getTeniente2().getVida() + "\n" +
        "Teniente 3: " + CPU.getTeniente3().getVida());
    }
    


}
