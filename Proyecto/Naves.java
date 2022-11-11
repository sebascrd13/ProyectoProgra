package Proyecto;

public class Naves {
    private int vida;
    private int ubiNum;
    private int ubiLet;
    
    public Naves(int vida, int ubiNum, int ubiLet) {
        this.vida = vida;
        this.ubiNum = ubiNum;
        this.ubiLet = ubiLet;
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setUbiNum(int ubiNum){
        this.ubiNum = ubiNum;
    }

    public int getUbiNum(){
        return ubiNum;
    }

    public void setUbiLet(int ubiLet){
        this.ubiLet = ubiLet;
    }

    public int getUbiLet(){
        return ubiLet;
    }

    public int getAtaque(){
        return vida -1;
    }

    
    
    
}
