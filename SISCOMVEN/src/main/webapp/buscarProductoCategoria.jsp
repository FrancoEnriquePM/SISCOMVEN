<%-- 
    Document   : buscarProductoCategoria
    Created on : 19-06-2021, 09:30:43 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Producto</title>
        <%! String salidaTabla = "";%>
    </head>
    <body>
        <h1>BUSCAR PRODUCTO</h1>
        <jsp:useBean id="categoriaBean" scope="session" class="com.mycompany.bean.CategoriaBean"/>
        <jsp:useBean id="productoBean" scope="session" class="com.mycompany.bean.ProductoBean"/>
        <%
            if(request.getParameter("buscar")!=null){
                String codCat = request.getParameter("codCategoria");
                //llamando al metodo de busqueda de productos de una determinada categoria
                salidaTabla=productoBean.listarProductoCategoria(codCat);
            }
        %>
        <form method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">CATEGORIA</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <select name="codCategoria">
                                <%=categoriaBean.listarCategoriaSelect()%>
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
                        <th>PRODUCTO</th>
                        <th>DESCRIPCION</th>
                        <th>COSTO U. COMPRA</th>
                        <th>COSTO U. VENTA</th>
                        <th>STOCK</th>
                        <th>PROVEEDOR</th>
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
