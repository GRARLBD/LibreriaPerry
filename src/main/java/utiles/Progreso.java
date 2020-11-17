/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 * @author Kevin
 */
public class Progreso {
    private int progreso;
    
    public Progreso() {
        progreso = 0;        
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }
    
    public void incrementar()
    {
        progreso++;
    }
    
}
