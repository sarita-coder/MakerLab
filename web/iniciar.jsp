<%-- 
    Document   : iniciar
    Created on : 28/06/2016, 12:40:50 PM
    Author     : SARITA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicie cesión</title>
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Dosis:300,400,500,600,700">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main_1.css" rel="stylesheet">
        
    </head>
    <body>
        <div class="container text-center">
            <div class="col-sm-8 col-sm-offset-2">
                <h1 class="title-cesion">Ingrese tus credenciales</h1>
                <form class="parainfo1" action="validate.do" method="post">
                    <label class="sub-cesion">Mail:
                    </label>
                    <input type="email" name="txtMail" placeholder="E-mail" required="required"/> 
                    <br>
                    <label class="sub-cesion">Password:   
                    </label>
                    <input type="password" name="txtPass" placeholder="Password" required="required"/>
                        <br>
                    <input type="submit" value="Enviar" class="btn-inicio" />
                </form>
            </div>
        </div>
    </body>
</html>
