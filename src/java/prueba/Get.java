
package prueba;

import dao.DaoPersonas;
import dao.impl.DaoPersonaImpl;
import dto.Personas;


public class Get {
    public static void main(String[] args) {
        Integer ide=2;
        DaoPersonas DaoPersonas = new DaoPersonaImpl();
        Personas n = DaoPersonas.personasGet(ide);
        System.out.println(n.getIde()+ " - " + n.getDni()+ " - " + n.getApepad()+ " - " + n.getNombres()+ " - "+ n.getCelular()+ " - " + n.getCorreo()+ " - " + n.getDireccion()+ " - "+ n.getLongitud()+ n.getLatitud());
    
    
    }
}
