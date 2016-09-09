<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <title>Base de datos de Clientes</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="jq/redmond/jquery-ui-1.10.3.custom.min.css" type="text/css" rel="stylesheet"/>
        <link href="parainfo/table/table.css" type="text/css" rel="stylesheet"/>
        <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"/>
        <link href="css/main.css" type="text/css" rel="stylesheet"/>
        <script src="jq/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui-1.10.3.custom.min.js" type="text/javascript">
        </script>
        <script src="parainfo/table/table.js" type="text/javascript"></script>
        <script src="js/main.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Base de datos Clientes</h1>
            <h1 class="text-center"><a href="index.html">Regresar a la página</a></h1>
        </div>
        
        <table class="parainfo" style="margin: auto;width: 800px">
            <thead>
                <tr>
                    <td>DNI</td>
                    <th>Apellidos</th>
                    <th>Nombres</th>
                    <th>Celular</th>
                    <td>Correo</td>
                    <td>Direccion</td>
                    <td>Longitud</td>
                    <td>Latitud</td>
                    <th class="crud">
                        <a href="#" class="ins" onclick="jsIns();" title="Nuevo"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="del" onclick="jsDel();" title="Retirar"><span></span></a>
                    </th>
                    <th class="crud">
                        <a href="#" class="upd" onclick="jsUpd(); "title="Actualizar"><span></span></a>
                    </th>
                    <td>Visor Map</td>
                </tr>
            </thead>
            <tbody>
                <c:if test="${list != null}">
                    <c:forEach var="f" items="${list}">
                        <tr>
                            <td style="text-align: center">
                                <fmt:formatNumber pattern="#" value="${f.dni}"/>
                            </td>
                            <td>${f.apepad}</td>
                            <td>${f.nombres}</td>
                            <td style="text-align: center">
                                <fmt:formatNumber pattern="#" value="${f.celular}"/>
                            </td>
                            <td>${f.correo}</td>
                            <td>${f.direccion}</td>
                            <td  style="text-align: center" data="lon${f.ide}" id="lon${f.ide}" >
                                <fmt:formatNumber pattern="#" value="${f.longitud}"/>
                            </td>
                            <td colspan="2" style="text-align: center" data="lat${f.ide}" id="lon${f.ide}">
                                <fmt:formatNumber pattern="#" value="${f.latitud}"/>
                            </td>
                            <th>
                                <input type="checkbox" name="_del" 
                                       value="${f.ide}"/>
                            </th>
                            <th>
                                <input type="radio" name="_upd" 
                                       value="${f.ide}"/>
                            </th>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
        <div id="map" style="width: 500px; height:400px">
            
        </div>
        

        <%-- para mensajes  --%>
        <c:if test="${msg != null}">
            <h4 style="text-align: center;color: red">${msg}</h4>
            <c:remove var="msg"/>
        </c:if>

    </body>
</html>