package prueba;

import dao.DaoPersonas;
import dao.impl.DaoPersonaImpl;
import dto.Personas;

public class UpDate {
    
    public static void main(String[] args) {
        
    //se vee al alumno que se desea modifica
        Integer ide =13;

        DaoPersonas daoPersonas = new DaoPersonaImpl();
        Personas n = daoPersonas.personasGet(ide);

         System.out.println(n.getIde()+ " - " + n.getDni()+ " - " + n.getApepad()+ " - " + n.getNombres()+ " - "+ n.getCelular()+ " - " + n.getCorreo()+ " - " + n.getDireccion()+ " - "+ n.getLongitud()+ n.getLatitud());
            //se procede al cambio
        n.setNombres("Antero Matos");
        n.setCelular(923456989);
        String res = daoPersonas.personasUpd(n);
        //verificamos el resultado de la actualizacion
        if (res == null) {
            System.out.println("Actualizacion exitosa");
        } else {
            System.out.println("No se pudo actualizar... consulte con el administrador de la BD");
        }
        System.out.println(n.getIde()+ " - " + n.getDni()+ " - " + n.getApepad()+ " - " + n.getNombres()+ " - "+ n.getCelular()+ " - " + n.getCorreo()+ " - " + n.getDireccion()+ " - "+ n.getLongitud()+" - " + n.getLatitud());
    }
    
}
