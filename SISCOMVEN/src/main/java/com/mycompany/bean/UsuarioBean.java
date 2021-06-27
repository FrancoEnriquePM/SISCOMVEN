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
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.annotation.PreDestroy;

/**
 *
 * @author hp
 */
public class UsuarioBean {
    //Atributos
    private VariablesConexion variable;
    private Connection connection;
    //constructores
    public UsuarioBean() throws SQLDataException, SQLException{
        variable = new VariablesConexion();
        variable.inicioConexion();
        connection=variable.getConnection();
        System.out.println("Iniciando la Conexion");            
    }
    @PreDestroy
    public void cerrarConexion(){
        variable.cerrarConexion();
    }
    //Metodos
    /*public String listarProduto(){
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();
        query.append(" select p.nom_pro, p.des_pro, p.costo_uc, p.costo_uv, p.stock, prov.razon_social, c.nom_cat ");
        query.append(" from producto p ");
        query.append(" inner join proveedor prov ON p.cod_prov = prov.cod_prov ");
        query.append(" inner join categoria c ON c.cod_cat = p.cod_cat ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {                
                salidaTabla.append("<tr>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(1));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getDouble(3));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getDouble(4));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getInt(5));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(6));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(7));
                salidaTabla.append("</td>");
                salidaTabla.append("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de conexion!!");
        }
        return salidaTabla.toString();
    }*/
    
    //Buscar todos los productos de una determinada categoria
    
    public String listarUsuarioRol(String codRol){
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();
        query.append(" SELECT u.ap_pat, u.ap_mat, u.nombres, u.cedula, u.codigo,r.nombre_rol ");
        query.append(" FROM usuario u ");
        query.append(" INNER JOIN rol r ON r.cod_rol = u.cod_rol ");
        query.append(" WHERE u.cod_rol=? ");
        try {
            PreparedStatement pst=connection.prepareStatement(query.toString());
            //pasando a la consulta el parametro del codigo de categoria
            pst.setInt(1, Integer.parseInt(codRol));
            ResultSet resultado=pst.executeQuery();
            while(resultado.next()){
                salidaTabla.append("<tr>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(1));
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
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(6));
                salidaTabla.append("</td>");
                salidaTabla.append("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salidaTabla.toString();
    }
    //Getter y setter
}
