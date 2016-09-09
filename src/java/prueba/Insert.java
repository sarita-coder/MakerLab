
package prueba;

import dao.DaoPersonas;
import dao.impl.DaoPersonaImpl;
import dto.Personas;

/**
 *
 * @author SENCICO
 */
public class Insert {
    public static void main(String[] args) {
        Personas n1 = new Personas();
        n1.setDni(47169753);
        n1.setApepad("AFETR MAFTER");
        n1.setNombres("MEN");
        n1.setCelular(471697559);
        n1.setCorreo("SARITA.ROMAN@GMAIL");
        n1.setDireccion("AV.MICAELA");
        n1.setLongitud(-1234568);
        n1.setLatitud(-1234568);
        
        DaoPersonas dn= new DaoPersonaImpl();
        String in = dn.personasIns(n1);
                if(in==null){
            System.err.println("Solicitud atendida");
        }else{
            System.err.println("Lo lamento no se guardo los cambios");
        }
        
    }
    
}
