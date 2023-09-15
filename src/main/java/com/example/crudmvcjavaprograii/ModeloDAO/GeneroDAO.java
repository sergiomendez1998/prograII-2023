/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.crudmvcjavaprograii.ModeloDAO;


import com.example.crudmvcjavaprograii.Intefaces.CRUD;
import com.example.crudmvcjavaprograii.Modelo.Genero;
import com.example.crudmvcjavaprograii.Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author SERGIO-MENDEZ
 */
public class GeneroDAO implements CRUD<Genero> {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Genero genero=new Genero();
    
    public static final Set<Genero> LISTA_GENEROS = new HashSet<>();
 
    
    @Override
    public List listar() {
       ArrayList<Genero>list=new ArrayList<>();
        String sql="SELECT * FROM genero";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){

                Genero genero = new Genero();
                genero.setId(rs.getInt("id"));
                genero.setNombre(rs.getString("nombre"));
                genero.setDescripcion(rs.getString("descripcion"));

                list.add(genero);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public Genero list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean add(Genero genero) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean edit(Genero genero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void addGenerosToList(){
      LISTA_GENEROS.addAll(listar());
    }
    
    public Genero getGeneroById(int id){
    return LISTA_GENEROS.stream()
            .filter(genero-> genero.getId()==id).findFirst()
            .orElse(null);
    }
    
}
