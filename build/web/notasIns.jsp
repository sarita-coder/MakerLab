<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>

<%
   
    User u = (User) session.getAttribute("user");
        
        if( u == null){
            /**Ingreso trusho*/
            request.getRequestDispatcher("error.view").forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Clientes</title>
        <link href="jq/redmond/jquery-ui-1.10.3.custom.min.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/form/form.css" type="text/css" rel="stylesheet"/>
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <script src="jq/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
        <script src="parainfo/form/form.js" type="text/javascript"></script>
        <script src="js/main.js" type="text/javascript"></script>
    </head>
    <body>
        <form class="parainfo" action="Personas" method="post" style="margin: auto;display: table">
            <input type="hidden" name="accion" value="INS"/>

            <fieldset>
                <legend>Ingreso de Cliente</legend>

                <table class="tabla">
                    <tr>
                        <td><label for="dni">dni</label></td>
                        <td>
                            <input required="required" type="text" name="dni" maxlength="8" style="width: 60px;text-align: right" value="${personas.dni}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="apepad">Apellidos</label></td>
                        <td>
                            <input type="text" name="apepad" style="width: 200px"  maxlength="150" value="${personas.apepad}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="nota2">Nombres</label></td>
                        <td>
                            <input type="text" name="nombres" maxlength="150" style="width: 60px;text-align: right" value="${personas.nombres}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="celular">Celular</label></td>
                        <td>
                            <input type="text" name="celular" maxlength="9" style="width: 60px;text-align: right" value="${personas.celular}"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><label for="correo">Correo</label></td>
                        <td>
                            <input type="text" name="correo" style="width: 200px"  maxlength="150" value="${personas.correo}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="direccion">Direccion</label></td>
                        <td>
                            <input type="text" name="direccion" style="width: 200px"  maxlength="50" value="${personas.direccion}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="longitud">Longitud</label></td>
                        <td>
                            <input type="text" name="longitud" style="width: 200px"  maxlength="50" value="${personas.longitud}"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="latitud">Latitud</label></td>
                        <td>
                            <input type="text" name="latitud" style="width: 200px"  maxlength="50" value="${personas.latitud}"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <input type="button" value="Cancelar" onclick="cancelar();"/>
                            <input type="submit" value="Enviar Datos"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>

        <%-- para mensajes  --%>
        <c:if test="${msg != null}">
            <div style="margin: auto;display: table;color: red">${msg}</div>
            <c:remove var="msg"/>
        </c:if>
    </body>
</html>
