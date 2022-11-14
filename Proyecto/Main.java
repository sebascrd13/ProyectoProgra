package Proyecto;
import javax.swing.JOptionPane;



public class Main {
    public static void main(String[] args) {
        byte op;
        
        String nomUser = JOptionPane.showInputDialog(
            "Digite su nombre: ");
        String nomCPU = JOptionPane.showInputDialog(
            "Nombre del CPU: ");

        Jugador CPU = new Jugador(nomCPU, null, null, null,
         null, null, null);

        Jugador usuario = new Jugador(nomUser, null, null,
         null, null, null, null); 
        
        Juego battleship = new Juego(usuario, CPU, null, null);

        
        Naves almirante = new Naves(4,0,0);
        Naves capi1 = new Naves(3,0,0);
        Naves capi2 = new Naves(3,0,0);       //Se crean los barcos
        Naves teniente1 = new Naves(1,0,0);
        Naves teniente2 = new Naves(1,0,0);
        Naves teniente3 = new Naves(1,0,0);

        usuario.setAlmirante(almirante);
        usuario.setCapi1(capi1);
        usuario.setCapi2(capi2);         //Se le asignan las naves al usuario
        usuario.setTeniente1(teniente1);
        usuario.setTeniente2(teniente2);
        usuario.setTeniente3(teniente3);

        CPU.setAlmirante(almirante);
        CPU.setCapi1(capi1);
        CPU.setCapi2(capi2);         //Se le asignan las naves al CPU
        CPU.setTeniente1(teniente1);
        CPU.setTeniente2(teniente2);
        CPU.setTeniente3(teniente3);
           
        

        

        battleship.impTabBlanco();

        battleship.llenarTab(); //Se llenan ambos tableros
        
        battleship.impTabUser();
        

        

     
        
        
        


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
                battleship.atacarCPU();
            }

            if (op == 2) {
                                 
            }

            if (op == 3) {
                battleship.impTabUser();           
            }        
            

            if (op == 4) {
                battleship.trampa();
                                               
            }

            if (op == 5) {
                JOptionPane.showMessageDialog(null,
                "Usted ha salido del juego");
            }
            
        }   
        
        



        

















       //Pruebas:         
        

       

         
    


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