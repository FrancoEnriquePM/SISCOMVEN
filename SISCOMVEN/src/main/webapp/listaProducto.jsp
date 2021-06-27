<%-- 
    Document   : listaProducto
    Created on : 08-06-2021, 02:25:27 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Productos</title>
    </head>
    <body>
        
        <h1>LISTA DE PRODUCTOS</h1>
        <jsp:useBean id="productoBean" scope="session" class="com.mycompany.bean.ProductoBean"/>
        <table border="1">
            <thead>
                <tr>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                    <th>COSTO UNIT. COMPRA</th>
                    <th>COSTO UNIT. VENTA</th>
                    <th>STOCK</th>
                    <th>PRODUCTO</th>
                    <th>CATEGORIA</th>
                </tr>
            </thead>
            <tbody>
                <%=productoBean.listarProduto()%>
            </tbody>
        </table>
            <a href="index.jsp">MENU PRINCIPAL</a>
    </body>
</html>
