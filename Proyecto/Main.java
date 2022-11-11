package Proyecto;
import javax.swing.JOptionPane;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        byte op;
        
        String nomUser = JOptionPane.showInputDialog(
            "Digite su nombre: ");
        String nomCPU = JOptionPane.showInputDialog(
            "Nombre del CPU: ");

        Jugador CPU = new Jugador(nomCPU, null, null, null,
         null, null, null, null);

        Jugador usuario = new Jugador(nomUser, null, null, null,
         null, null, null, null);

        
        Naves almirante = new Naves(4,0,0);
        Naves capi1 = new Naves(3,0,0);
        Naves capi2 = new Naves(3,0,0);       //Se crean los barcos
        Naves teniente1 = new Naves(1,0,0);
        Naves teniente2 = new Naves(1,0,0);
        Naves teniente3 = new Naves(1,0,0);

        CPU.setAlmirante(almirante);
        CPU.setCapi1(capi1);
        CPU.setCapi2(capi2);
        CPU.setTeniente1(teniente1);   //Se le asignan las naves al CPU
        CPU.setTeniente2(teniente2);
        CPU.setTeniente3(teniente3);

        usuario.setAlmirante(almirante);
        usuario.setCapi1(capi1);
        usuario.setCapi2(capi2);         //Se le asignan las naves al usuario
        usuario.setTeniente1(teniente1);
        usuario.setTeniente2(teniente2);
        usuario.setTeniente3(teniente3);
       
        
        String[][] tab_usuario = new String [6][6];
        String[][] tab_CPU = new String [6][6];

        tablero tabUsuario = new tablero(tab_usuario);
        tablero tabCPU = new tablero(tab_CPU);

        usuario.setTablero(tabUsuario);      //Se le asigna un tablero al usuario
        CPU.setTablero(tabCPU);              //y al CPU


        String naves [] = {"Almirante","Capitán 1","Capitán 2",
        "Teniente 1","Teniente 2","Teniente 3"};
        
        
        int ubicacionesL [] = new int[6];       //Se guardan las coordenadas de columna
        int ubicacionesN [] = new int[6];       //Se guardan las coordenadas de fila
        
        
        tabUsuario.impTablero(tab_usuario);
        tabCPU.impTablero(tab_CPU);
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

        tab_usuario [ubicacionesN[0]][ubicacionesL[0]] = "4";
        tab_usuario [ubicacionesN[1]][ubicacionesL[1]] = "3";       //Se le asigna un valor a la posición
        tab_usuario [ubicacionesN[2]][ubicacionesL[2]] = "3";       //de cada nave del usuario
        tab_usuario [ubicacionesN[3]][ubicacionesL[3]] = "1";
        tab_usuario [ubicacionesN[4]][ubicacionesL[4]] = "1";
        tab_usuario [ubicacionesN[5]][ubicacionesL[5]] = "1";

        tab_CPU [2][4] = "4";
        tab_CPU [5][1] = "3";       //Se le asigna un valor a la posición
        tab_CPU [4][0] = "3";       //de cada nave del CPU
        tab_CPU [0][3] = "1";
        tab_CPU [1][2] = "1";
        tab_CPU [3][5] = "1";

     
        System.out.print("\n");
        System.out.println("  ===========================");
        System.out.println("           SU TABLERO        ");
        System.out.println("  ===========================");
        System.out.println("     A   B   C   D   E   F");
        System.out.println("   _________________________");
        for (int i = 0; i < tab_usuario.length; i++) {
            System.out.print(i+": | ");
            for (int j = 0; j < tab_usuario.length; j++) {
                System.out.print(tab_usuario[i][j] + " | ");
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
        
        
        


        JOptionPane.showMessageDialog(null,"UBICACIONES"+"\n"+
        "Almirante: "+usuario.getAlmirante().getUbiNum()+" "+usuario.getAlmirante().getUbiLet()+"\n"
        +"Capitán 1: "+usuario.getCapi1().getUbiNum()+" "+usuario.getCapi1().getUbiLet()+"\n"
        +"Capitán 2: "+usuario.getCapi2().getUbiNum()+" "+usuario.getCapi2().getUbiLet()+"\n"
        +"Almirante 1: "+usuario.getTeniente1().getUbiNum()+" "+usuario.getTeniente1().getUbiLet()+"\n"
        +"Almirante 2: "+usuario.getTeniente2().getUbiNum()+" "+usuario.getTeniente2().getUbiLet()+"\n"
        +"Almirante 3: "+usuario.getTeniente3().getUbiNum()+" "+usuario.getTeniente3().getUbiLet());       





        op = 0;
        while (op != 5) {
            op = Byte.parseByte(JOptionPane.showInputDialog(
                "MENÚ DEL JUEGO" + "\n" + 
                "1. Atacar" + "\n" +
                "2. Ver tablero de ataque" + "\n" + 
                "3. Ver tablero propio" + "\n" +
                "4. Hacer trampa " + "\n" +
                "5. Salir"));
            
            if (op == 1) {

            }

            if (op == 2) {
                                 
            }

            if (op == 3) {
                System.out.println("  ===========================");
                System.out.println("           SU TABLERO        ");
                System.out.println("  ===========================");
                System.out.println("     A   B   C   D   E   F");
                System.out.println("   _________________________");
                for (int i = 0; i < tab_usuario.length; i++) {
                    System.out.print(i + ": | ");
                    for (int j = 0; j < tab_usuario.length; j++) {
                        System.out.print(tab_usuario[i][j] + " | ");
                    }
                    System.out.println();
                    System.out.println("   |---|---|---|---|---|---|");
            }        
            }

            if (op == 4) {
                System.out.println("  ===========================");
                System.out.println("              CPU            ");
                System.out.println("  ===========================");
                System.out.println("     A   B   C   D   E   F");
                System.out.println("   _________________________");
                for (int i = 0; i < tab_CPU.length; i++) {
                    System.out.print(i + ": | ");
                    for (int j = 0; j < tab_CPU.length; j++) {
                        System.out.print(tab_CPU[i][j] + " | ");
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

            if (op == 5) {
                JOptionPane.showMessageDialog(null,
                "Usted ha salido del juego");
            }
            
        }        



        

















       //Pruebas:         
        

        usuario.getAlmirante().setVida(almirante.getAtaque());
        usuario.getAlmirante().setVida(almirante.getAtaque());

        System.out.println(usuario.getAlmirante().getVida());      
    


        // System.out.println("Usuario: "+usuario.getNombre());
        // System.out.println("CPU: "+CPU.getNombre());
        // System.out.printf("\n");

        // System.out.println("Almirante: "+almirante.getVida());
        // almirante.setVida(almirante.getAtaque());
        // System.out.println(almirante.getVida());
        // almirante.setVida(almirante.getAtaque());
        // System.out.println(almirante.getVida());

        // System.out.println("Capitán 1: "+capi1.getVida());
        // System.out.println("Capitán 2: "+capi2.getVida());
        // System.out.println("Teniente 1: "+teniente1.getVida());
        // System.out.println("Teniente 2: "+teniente2.getVida());
        // System.out.println("Teniente 3: "+teniente3.getVida());

    }
}
