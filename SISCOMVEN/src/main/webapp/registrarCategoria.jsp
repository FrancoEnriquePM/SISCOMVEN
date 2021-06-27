<%-- 
    Document   : registrarCategoria
    Created on : 06-06-2021, 10:08:27 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Categoria</title>
    </head>
    <body>
        <jsp:useBean id="categoria" scope="session" class="com.mycompany.bean.CategoriaBean"/>
        <%
            if(request.getParameter("guardar")!= null){
                String mensaje=categoria.registrarCategoria(request);
                out.print(mensaje);
            }
        %>
        <h1>Categoria</h1>
        <form method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">REGISTRAR CATEGORIA</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>NOMBRE: </td>
                        <td><input type="text" name="nomCat" value="" /></td>
                    </tr>
                    <tr>
                        <td>DESCRIPCION: </td>
                        <td><input type="text" name="desCat" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="REGISTRAR" name="guardar" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        <a href="index.jsp">INICIO</a>
    </body>
</html>
