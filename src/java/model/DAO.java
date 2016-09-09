
package model;

public class DAO {
    public User exist(User u){
        if(!u.getMail().equalsIgnoreCase("vilcapoma@gmail.com")&&
                !u.getPass().equalsIgnoreCase("vilcapoma")){
            /**Malo**/
            u.addError(new Error(300, "Mail y Pass incorrecta"));
            return u;
            
        }else if( u.getMail().equalsIgnoreCase("vilcapoma@gmail.com")){
          /*ok*/
          if(u.getPass().equalsIgnoreCase("vilcapoma")){
              /*Ok*/
              return new User(u.getMail(), u.getPass(), "Vilcapoma SA");
          }else{
              /* Pass Incorrecto*/
              User newUser = new User(u.getMail(), u.getPass(), "Vilcapoma SA");
              newUser.addError(new Error(100, "Pass Incorrecta"));
              return newUser;
          }
        }else{
            /*Email erróneo*/
            User newUser = new User(u.getMail(), u.getPass(), "Vilcapoma SA");
            newUser.addError(new Error(200, "Mail Incorrecta"));
            return newUser;
            
        }
   
    }
}
