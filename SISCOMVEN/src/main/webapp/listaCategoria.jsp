<%-- 
    Document   : listaCategoria
    Created on : 08-06-2021, 01:24:21 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Categoria</title>
    </head>
    <body>
        <h1>LISTA DE CATEGORIA</h1>
        <jsp:useBean id="categoriaBean" scope="session" class="com.mycompany.bean.CategoriaBean"/>
        <table border="1" bgcolor="#aabbcc">
            <thead>
                <tr>
                    <th>CODIGO</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                </tr>
            </thead>
            <tbody>
                <%=categoriaBean.listarCategoria()%>
            </tbody>
        </table>
            <a href="index.jsp">Menu Inicio</a>
    </body>
</html>
