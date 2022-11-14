package Proyecto;

public class Jugador {
    private String nombre;
    private Naves almirante;
    private Naves capi1;
    private Naves capi2;
    private Naves teniente1;
    private Naves teniente2;
    private Naves teniente3;
    


    public Jugador(String nombre, Naves almirante, Naves capi1,
            Naves capi2, Naves teniente1, Naves teniente2,
            Naves teniente3) {
        this.nombre = nombre;
        this.almirante = almirante;
        this.capi1 = capi1;
        this.capi2 = capi2;
        this.teniente1 = teniente1;
        this.teniente2 = teniente2;
        this.teniente3 = teniente3;
    
    }

    public String getNombre(){
        return nombre;
    } 

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
   
    public Naves getAlmirante() {
        return almirante;
    }

    public void setAlmirante(Naves almirante) {
        this.almirante = almirante;
    }

    public Naves getCapi1() {
        return capi1;
    }

    public void setCapi1(Naves capi1) {
        this.capi1 = capi1;
    }

    public Naves getCapi2() {
        return capi2;
    }

    public void setCapi2(Naves capi2) {
        this.capi2 = capi2;
    }

    public Naves getTeniente1() {
        return teniente1;
    }

    public void setTeniente1(Naves teniente1) {
        this.teniente1 = teniente1;
    }

    public Naves getTeniente2() {
        return teniente2;
    }

    public void setTeniente2(Naves teniente2) {
        this.teniente2 = teniente2;
    }

    public Naves getTeniente3() {
        return teniente3;
    }

    public void setTeniente3(Naves teniente3) {
        this.teniente3 = teniente3;
    }

 
}

