<%-- 
    Document   : buscarUsuarioRol
    Created on : 27-06-2021, 12:11:07 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Usuario</title>
        <%! String salidaTabla = "";%>
    </head>
    <body>
        <h1>BUSCAR USUARIO</h1>
        <jsp:useBean id="rolBean" scope="session" class="com.mycompany.bean.RolBean"/>
        <jsp:useBean id="usuarioBean" scope="session" class="com.mycompany.bean.UsuarioBean"/>
        <%
            if(request.getParameter("buscar")!=null){
                String codRol = request.getParameter("codRol");
                //llamando al metodo de busqueda de productos de una determinada categoria
                salidaTabla=usuarioBean.listarUsuarioRol(codRol);
            }
        %>
        <form method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">ROL</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <select name="codRol">
                                <%=rolBean.listarRolSelect()%>
                            </select>
                        </td>
                        <td>
                            <input type="submit" value="BUSCAR" name="buscar" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table border="1">
                <thead>
                    <tr>
                        <th>AP. PATERNO</th>
                        <th>AP. MATERNO</th>
                        <th>NOMBRES</th>
                        <th>CEDULA DE IDENTIDAD</th>
                        <th>CODIGO</th>
                        <th>NOMBRE DEL ROL</th>
                    </tr>
                </thead>
                <tbody>
                    <%=salidaTabla%>
                </tbody>
            </table>
        </form>
        <a href="index.jsp">Menu Inicio</a>
    </body>
</html>
