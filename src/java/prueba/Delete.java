
package prueba;

import dao.DaoPersonas;
import dao.impl.DaoPersonaImpl;
import java.util.LinkedList;
import java.util.List;

public class Delete {
    public static void main(String[] args) {
        List<Integer> ideList = new LinkedList<>();
       ideList.add(2);
        
        //procedomos a eliminar
        DaoPersonas daoPersonas = new DaoPersonaImpl();
        String res = daoPersonas.personasDel(ideList);
        
        //verificamos el resultado de la eliminacion
        if(res==null){
            System.out.println("Eliminacion exitosa");
        }else{
            System.out.println("No se pudo eliminar... consulte con el administrador de la BD");
        }
    }
}
