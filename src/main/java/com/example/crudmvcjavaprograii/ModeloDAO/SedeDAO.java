package com.example.crudmvcjavaprograii.ModeloDAO;

import com.example.crudmvcjavaprograii.Config.Conexion;
import com.example.crudmvcjavaprograii.Intefaces.CRUD;
import com.example.crudmvcjavaprograii.Modelo.Sede;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SedeDAO implements CRUD<Sede> {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public static final Set<Sede> LISTA_SEDES = new HashSet<>();

    @Override
    public List listar() {
        ArrayList<Sede>list=new ArrayList<>();
        String sql="SELECT * FROM sedes";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){

                Sede sede = new Sede();
                sede.setId(rs.getInt("id"));
                sede.setNombre(rs.getString("nombre"));
                sede.setDescripcion(rs.getString("descripcion"));

                list.add(sede);
            }
        } catch (SQLException e) {
        }
        return list;

    }

    @Override
    public Sede list(int id) {
        return null;
    }

    @Override
    public boolean add(Sede entity) {
        return false;
    }

    @Override
    public boolean edit(Sede entity) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    public void llenarListadoSedes(){
        LISTA_SEDES.addAll(listar());
    }
}
