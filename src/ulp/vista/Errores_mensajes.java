/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.vista;

/**
 *
 * @author Genaro
 */
public class Errores_mensajes {
        
    public static String estado;

    public Errores_mensajes() {
    }
    
    
    
    public static void escribirMensaje(String estado){
        Errores_mensajes.estado = estado;
//        System.out.println(estado+"este");
//        System.out.println("hasta aca llego");
//        System.out.println(Errores_mensajes.getEstado()+" reslut");
        
    }

    public static String getEstado() {
        return estado;
    }
    
    
    
}
