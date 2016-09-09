package prueba;

import sql.ConectaDB;

public class pruebaCn {
  
    public static void main(String[] args) {
        /*
        ConectaDb conectaDb = new ConectaDb();
        Connection cn = conectaDb.getConnection();
        if(cn!=null){
            System.out.println("Ok...");
        }else{
            System.out.println("Error...");
        }
        */
        /*
        if((new ConectaDb()).getConnection()!=null){
            System.out.println("Ok2...");
        }else{
            System.out.println("Error2...");
        }
        */
        /*
        String msg=((new ConectaDb()).getConnection()!=null)?"Ok3...":"Error3...";
        System.out.println(msg);
        */
        System.out.println(((new ConectaDB("postgres")).getConnection()!=null)?"Ok4...":"Error4...");
    }
    
   
}
