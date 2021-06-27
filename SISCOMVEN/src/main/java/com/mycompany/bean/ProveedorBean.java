/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.conexion.VariablesConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hp
 */
public class ProveedorBean {
    //Atributos
    private Connection connection;
    private PreparedStatement insertProveedor;
    private VariablesConexion variable;
    //Constructores
    public ProveedorBean() throws SQLException{
        //Instanciando
        variable = new VariablesConexion();
        variable.inicioConexion();
        //Obteniendo la conexion
        connection = variable.getConnection();
        System.out.println("Iniciando la conexion");
    }    
    //Metodos
    @PreDestroy
    public void cerrarConexion(){
        variable.cerrarConexion();
    }
    /*public String registrarProveedor(HttpServletRequest request){
        String mensaje="";
        if (request == null) {
            return  "";
        }
        if(connection != null){
            try {
                //Defiendo la consulta
                StringBuilder query=new StringBuilder();
                query.append(" insert into categoria ");
                query.append(" values (nextval('sec_cat'),?,?)");
                //enviando la consulta
                if(insertProveedor == null){
                    insertProveedor = connection.prepareStatement(query.toString());
                }
                
                //Rescatando los parametros del formulario jsp registrar Categoria
                
                String nombre=request.getParameter("nomCat");
                String descripcion=request.getParameter("desCat");
                
                //pasando los datos a los parametros de la consulta
                
                insertProveedor.setString(1, nombre);
                insertProveedor.setString(2, descripcion);
                
                //ejecutando la consulta
                
                int registro = insertProveedor.executeUpdate();
                if(registro == 1){
                    mensaje = "Registro realizado con exito..!";
                }else{
                    mensaje = "Error al insertar el registro";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mensaje;
    }*/
    
    //Realizando el listado de todas las categorias que se tiene registrado
    
    public String listarProveedor(){
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();
        query.append(" SELECT * FROM proveedor ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            ResultSet resultado=pst.executeQuery();
            while (resultado.next()) {                
                salidaTabla.append("<tr>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getInt(1));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(3));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getInt(4));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(5));
                salidaTabla.append("</td>");
                salidaTabla.append("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la conexion..!");
        }
        return salidaTabla.toString();
    }
    
    /*public String listarProveedorSelect(){
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();
        query.append(" SELECT c.cod_cat, c.nom_cat ");
        query.append(" FROM categoria c ");
        try {
            PreparedStatement pst = connection.prepareCall(query.toString());
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {                
                salidaTabla.append("<option value='");
                salidaTabla.append(resultado.getInt(1));
                salidaTabla.append("'>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</option>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salidaTabla.toString();
    }*/
    //getter y setter
}
