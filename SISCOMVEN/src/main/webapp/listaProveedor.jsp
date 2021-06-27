<%-- 
    Document   : listarProveedor
    Created on : 27-06-2021, 11:21:42 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Proveedor</title>        
    </head>
    <body>
        <h1>LISTA PROVEEDOR</h1>
        <jsp:useBean id="proveedorBean" scope="session" class="com.mycompany.bean.ProveedorBean"/>
        <table border="1">
            <thead>
                <tr>
                    <th>CODIGO</th>
                    <th>RAZON SOCIAL</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th>CORREO ELECTRONICO</th>
                </tr>
            </thead>
            <tbody>
                <%=proveedorBean.listarProveedor()%>
            </tbody>
        </table>
            <a href="index.jsp">Menu Inicio</a>
    </body>
</html>
