package com.example.crudmvcjavaprograii.ModeloDAO;

import com.example.crudmvcjavaprograii.Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean validar(String user, String pass){
        String sql="select * from usuarios where username = ? and password = SHA2(?, 256);";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();

            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
