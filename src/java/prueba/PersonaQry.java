
package prueba;

import dao.DaoPersonas;
import dao.impl.DaoPersonaImpl;
import dto.Personas;
import java.util.List;

/**
 *
 * @author SENCICO
 */
public class PersonaQry {
        public static void main(String[] args) {
 
            DaoPersonas dn = new  DaoPersonaImpl();
            List<Personas> listPersonas = dn.personaQry();
        
        for(Personas n:listPersonas){
            System.out.println(n.getDni()+ " - " +n.getApepad()+ " - " + n.getNombres() + " - " + n.getCelular()+ " - " + n.getCorreo()+ " - " + n.getDireccion()+" - " + n.getLongitud()+" - " + n.getLatitud());
         
        }
    }
}
