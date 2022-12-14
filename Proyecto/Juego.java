package Proyecto;

import java.util.Random;

import javax.swing.JOptionPane;

public class Juego {
    private Jugador usuario;
    private Jugador CPU;
    private String tabCPU[][];
    private String tabCPUtrampa[][];
    private String tabUsuario[][];
    
    

    public Juego(Jugador usuario, Jugador CPU, tablero tabCPU, tablero tabCPUtrampa, tablero tabUsuario){
        this.usuario = usuario;
        this.CPU = CPU;
        this.tabCPU = new String[6][6];
        this.tabCPUtrampa = new String[6][6];
        this.tabUsuario = new String[6][6];
    }
    
    public String[][] getTabCPU() {
        return tabCPU;
    }

    public void setTabCPU(String [][]tabCPU) {
        this.tabCPU = tabCPU;
    }

    public String[][] getTabCPUtrampa() {
        return tabCPUtrampa;
    }

    public void setTabCPUtrampa(String[][] tabCPUtrampa) {
        this.tabCPUtrampa = tabCPUtrampa;
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
        
        String naves [] = {"Almirante","Capit??n 1","Capit??n 2",
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
        tabUsuario[ubicacionesN[1]][ubicacionesL[1]] = "3";       //Se le asigna un valor a la posici??n
        tabUsuario[ubicacionesN[2]][ubicacionesL[2]] = "3";       //de cada nave del usuario
        tabUsuario[ubicacionesN[3]][ubicacionesL[3]] = "1";
        tabUsuario[ubicacionesN[4]][ubicacionesL[4]] = "1";
        tabUsuario[ubicacionesN[5]][ubicacionesL[5]] = "1";

        for (int i = 0; i < tabCPUtrampa.length; i++) {
            for (int j = 0; j < tabCPUtrampa.length; j++) {
                tabCPUtrampa[i][j] = " ";
            }            
        }

        tabCPUtrampa[2][4] = "4";
        tabCPUtrampa[5][1] = "3";       //Se le asigna un valor a la posici??n
        tabCPUtrampa[4][0] = "3";       //de cada nave del CPU
        tabCPUtrampa[0][3] = "1";
        tabCPUtrampa[1][2] = "1";
        tabCPUtrampa[3][5] = "1";
        
        
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
        "Capit??n 1: " + usuario.getCapi1().getVida() + "\n" +
        "Capit??n 2: " + usuario.getCapi2().getVida() + "\n" +
        "Teniente 1: " + usuario.getTeniente1().getVida() + "\n" +
        "Teniente 2: " + usuario.getTeniente2().getVida() + "\n" +
        "Teniente 3: " + usuario.getTeniente3().getVida());     
        
    }

    public void impTabCPU() {
        System.out.println("\n");
        System.out.println("  ===========================");
        System.out.println("           "+CPU.getNombre()+"        ");
        System.out.println("  ===========================");
        System.out.println("     A   B   C   D   E   F");
        System.out.println("   _________________________");
        for (int i = 0; i < tabCPU.length; i++) {
            System.out.print(i+": | ");
            for (int j = 0; j < tabCPU.length; j++) {
                System.out.print(tabCPU[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   |---|---|---|---|---|---|");
        }
        System.out.println("Naves:" + "\n" + 
        "Almirante: " + CPU.getAlmirante().getVida() + "\n" +
        "Capit??n 1: " + CPU.getCapi1().getVida() + "\n" +
        "Capit??n 2: " + CPU.getCapi2().getVida() + "\n" +
        "Teniente 1: " + CPU.getTeniente1().getVida() + "\n" +
        "Teniente 2: " + CPU.getTeniente2().getVida() + "\n" +
        "Teniente 3: " + CPU.getTeniente3().getVida());
    }


    public void atacarCPU(){
        boolean turnoUsuario = true;
        impTabCPU();
        while (turnoUsuario) {
            byte atacaN = Byte.parseByte(JOptionPane.showInputDialog(
            "Fila de Ataque: "));
            byte atacaL = Byte.parseByte(JOptionPane.showInputDialog(
            "Columna de Ataque: " + "\n" + "A=0  B=1  C=2  D=3  E=4  F=5"));

            if (atacaN == 2 && atacaL == 4) {
                if (tabCPU[atacaN][atacaL] != "*") {
                    tabCPU[atacaN][atacaL] = "O";
                    tabCPUtrampa[atacaN][atacaL] = "O";
                    JOptionPane.showMessageDialog(null,
                    "Ha golpeado con ??xito al Almirante");
                    CPU.getAlmirante().setAtaque();            //Ataque al almirante
                    if (CPU.getAlmirante().getVida() == 0) {   //del CPU
                        tabCPU[2][4] = "*"; 
                        tabCPUtrampa[2][4] = "*";                                   
                    }
                    impTabCPU(); 
                    turnoUsuario = false;             
                }                
            }

            if (atacaN == 5 && atacaL == 1) {
                if (tabCPU[5][1] != "*") {
                    tabCPU[5][1] = "O";
                    tabCPUtrampa[5][1] = "O";
                    JOptionPane.showMessageDialog(null,
                    "Ha golpeado con ??xito al Capit??n 1");
                    CPU.getCapi1().setAtaque();                //Ataque al Capit??n1
                    if (CPU.getCapi1().getVida() == 0) {       //del CPU
                        tabCPU[5][1] = "*";
                        tabCPUtrampa[5][1] = "*";
                    }
                    impTabCPU();
                    turnoUsuario = false;
                }                                
            }

            if (atacaN == 4 && atacaL == 0) {
                if (tabCPU[4][0] != "*") {
                    tabCPU[4][0] = "O";
                    tabCPUtrampa[4][0] = "O";
                    JOptionPane.showMessageDialog(null,
                    "Ha golpeado con ??xito al Capit??n 2");
                    CPU.getCapi2().setAtaque();                //Ataque al Capit??n2 
                    if (CPU.getCapi2().getVida() == 0) {       //del CPU
                        tabCPU[4][0] = "*";
                        tabCPUtrampa[4][0] = "*";
                    }
                    impTabCPU();
                    turnoUsuario = false;
                }                                
            }

            if (atacaN == 0 && atacaL == 3) {
                if (tabCPU[0][3] != "*") {
                    tabCPU[0][3] = "O";
                    tabCPUtrampa[0][3] = "O";
                    JOptionPane.showMessageDialog(null,
                    "Ha golpeado con ??xito al Teniente 1");
                    CPU.getTeniente1().setAtaque();            //Ataque al Teniente1
                    if (CPU.getTeniente1().getVida() == 0) {   //del CPU
                        tabCPU[0][3] = "*";
                        tabCPUtrampa[0][3] = "*";
                    }
                    impTabCPU();
                    turnoUsuario = false;
                }                                
            }

            if (atacaN == 1 && atacaL == 2) {
                if (tabCPU[1][2] != "*") {
                    tabCPU[1][2] = "O";
                    tabCPUtrampa[1][2] = "O";
                    JOptionPane.showMessageDialog(null,
                    "Ha golpeado con ??xito al Teniente 2");
                    CPU.getTeniente2().setAtaque();            //Ataque al Teniente2
                    if (CPU.getTeniente2().getVida() == 0) {   //del CPU
                        tabCPU[1][2] = "*";
                        tabCPUtrampa[1][2] = "*";
                    }
                    impTabCPU();
                    turnoUsuario = false;
                }                                
            }

            if (atacaN == 3 && atacaL == 5) {
                if (tabCPU[3][5] != "*") {
                    tabCPU[3][5] = "O";
                    tabCPUtrampa[3][5] = "O";
                    JOptionPane.showMessageDialog(null,
                    "Ha golpeado con ??xito al Teniente 3");
                    CPU.getTeniente3().setAtaque();            //Ataque al Teniente3
                    if (CPU.getTeniente3().getVida() == 0) {   //del CPU
                        tabCPU[3][5] = "*";
                        tabCPUtrampa[3][5] = "*";
                    }
                    impTabCPU();
                    turnoUsuario = false;
                }                                
            }
                  
            if (tabCPU[atacaN][atacaL] == "X") {
                JOptionPane.showMessageDialog(null,  
                "Ya atac?? esa posici??n y fall??");                
            }
            
            if (tabCPU[atacaN][atacaL] == " ") {
                tabCPU[atacaN][atacaL] = "X";
                tabCPUtrampa[atacaN][atacaL] = "X";
                impTabCPU();
                turnoUsuario = false;
                JOptionPane.showMessageDialog(null,
                "No hay barcos en esa posici??n");
            }                     

            if (tabCPU[atacaN][atacaL] == "*") {
                JOptionPane.showMessageDialog(null,
                "Ya la nave est?? destruida");                
            }

            if (CPU.getAlmirante().getVida() == 0 && CPU.getCapi1().getVida() == 0
            && CPU.getCapi2().getVida() == 0 && CPU.getTeniente1().getVida() == 0
            && CPU.getTeniente2().getVida() == 0 && CPU.getTeniente3().getVida() == 0) {
                JOptionPane.showMessageDialog(null,
                usuario.getNombre() + " ha ganado el juego!!!");
                usuario.setVictoria(true);          
            }            
             
        }          
    }

    public void atacarUsuario() {
        boolean turnoCPU = true;
        Random random = new Random();                                  
        int randomN = random.nextInt(6);                        
        int randomL = random.nextInt(6);
        
        while (turnoCPU) {
            JOptionPane.showMessageDialog(null,
            "Turno de " + CPU.getNombre());
            if (tabUsuario[randomN][randomL] == "*") { 
                JOptionPane.showMessageDialog(null,
                CPU.getNombre() + " atac?? una nave que ya est?? destruida");
                impTabUser();         
                turnoCPU = false;    
            }

            if (randomN == usuario.getAlmirante().getUbiNum() 
            && randomL == usuario.getAlmirante().getUbiLet()) {
                if (tabUsuario[randomN][randomL] != "*") {           //Ataque al Almirante
                    tabUsuario[randomN][randomL] = "O";              //del Usuario
                    JOptionPane.showMessageDialog(null,
                    "Han golpeado con ??xito a su Almirante");
                    usuario.getAlmirante().setAtaque();
                    impTabUser();
                    if (usuario.getAlmirante().getVida() == 0) {
                        tabUsuario[randomN][randomL] = "*";
                        JOptionPane.showMessageDialog(null,
                        "Su Almirante ha sido destruido");  
                        turnoCPU = false;                                     
                    }
                     
                    turnoCPU = false;
                }
            } 
            
            if (randomN == usuario.getCapi1().getUbiNum()
            && randomL == usuario.getCapi1().getUbiLet()) {
                if (tabUsuario[randomN][randomL] != "*") {           //Ataque al Capit??n1 
                    tabUsuario[randomN][randomL] = "O";              //del usuario
                    JOptionPane.showMessageDialog(null,
                    "Han golpeado con ??xito a su Capit??n 1");
                    usuario.getCapi1().setAtaque();
                    impTabUser();
                    if (usuario.getCapi1().getVida() == 0) {
                        tabUsuario[randomN][randomL] = "*";
                        JOptionPane.showMessageDialog(null,
                        "Su Capit??n 1 ha sido destruido"); 
                        turnoCPU = false;
                    } 
                    turnoCPU = false;                 
                }                
            }

            if (randomN == usuario.getCapi2().getUbiNum()
            && randomL == usuario.getCapi2().getUbiLet()) {
                if (tabUsuario[randomN][randomL] != "*") {           //Ataque al Capit??n2
                    tabUsuario[randomN][randomL] = "O";              //del usuario 
                    JOptionPane.showMessageDialog(null,
                    "Han golpeado con ??xito a su Capit??n 2");
                    usuario.getCapi2().setAtaque();
                    impTabUser(); 
                    if (usuario.getCapi2().getVida() == 0) {
                        tabUsuario[randomN][randomL] = "*"; 
                        JOptionPane.showMessageDialog(null,
                        "Su Capit??n 2 ha sido destruido");  
                        turnoCPU = false;                      
                    }
                    turnoCPU = false;                  
                }
            }

            if (randomN == usuario.getTeniente1().getUbiNum()
            && randomL == usuario.getTeniente1().getUbiLet()) {
                if (tabUsuario[randomN][randomL] != "*") {           //Ataque al Teniente1 
                    tabUsuario[randomN][randomL] = "*";              //del usuario
                    JOptionPane.showMessageDialog(null,
                    "Han destruido a su Teniente 1");
                    usuario.getTeniente1().setAtaque();               
                    impTabUser();
                    turnoCPU = false;
                }
            }

            if (randomN == usuario.getTeniente2().getUbiNum()
            && randomL == usuario.getTeniente2().getUbiLet()) {
                if (tabUsuario[randomN][randomL] != "*") {           //Ataque al Teniente2
                    tabUsuario[randomN][randomL] = "*";              //del usuario
                    JOptionPane.showMessageDialog(null,
                    "Han destruido a su Teniente 2");
                    usuario.getTeniente2().setAtaque();                   
                    impTabUser();
                    turnoCPU = false;
                }
            }

            if (randomN == usuario.getTeniente3().getUbiNum()
            && randomL == usuario.getTeniente3().getUbiLet()) {
                if (tabUsuario[randomN][randomL] != "*") {           //Ataque al Teniente3
                    tabUsuario[randomN][randomL] = "*";              //del usuario
                    JOptionPane.showMessageDialog(null,
                    "Han destruido a su Teniente 3");
                    usuario.getTeniente3().setAtaque();                  
                    impTabUser();
                    turnoCPU = false;
                }
            }

            if (tabUsuario[randomN][randomL] == "X") {
                JOptionPane.showMessageDialog(null,
                CPU.getNombre() + " atac?? una celda en la que ya hab??a fallado");   
                impTabUser();
                turnoCPU = false;                           
            }
            
            if (tabUsuario[randomN][randomL] == " ") {
                tabUsuario[randomN][randomL] = "X";
                impTabUser();
                JOptionPane.showMessageDialog(null,
                CPU.getNombre() + " ha fallado");
                turnoCPU = false;
            } 

            if (usuario.getAlmirante().getVida() == 0 && usuario.getCapi1().getVida() == 0
            && usuario.getCapi2().getVida() == 0 && usuario.getTeniente1().getVida() == 0
            && usuario.getTeniente2().getVida() == 0 && usuario.getTeniente3().getVida() == 0) {
                JOptionPane.showMessageDialog(null,
                CPU.getNombre() + " ha ganado el juego!!!");
                CPU.setVictoria(true);            
            }                          
        } 
    }

    public void trampa(){
        System.out.println("  ===========================");
        System.out.println("           "+CPU.getNombre()+"        ");
        System.out.println("  ===========================");
        System.out.println("     A   B   C   D   E   F");
        System.out.println("   _________________________");
        for (int i = 0; i < tabCPUtrampa.length; i++) {
            System.out.print(i + ": | ");
            for (int j = 0; j < tabCPUtrampa.length; j++) {
                System.out.print(tabCPUtrampa[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   |---|---|---|---|---|---|");
        }
        System.out.println();
        System.out.println("Naves:" + "\n" + 
        "Almirante: " + CPU.getAlmirante().getVida() + "\n" +
        "Capit??n 1: " + CPU.getCapi1().getVida() + "\n" +
        "Capit??n 2: " + CPU.getCapi2().getVida() + "\n" +
        "Teniente 1: " + CPU.getTeniente1().getVida() + "\n" +
        "Teniente 2: " + CPU.getTeniente2().getVida() + "\n" +
        "Teniente 3: " + CPU.getTeniente3().getVida());
    }
}