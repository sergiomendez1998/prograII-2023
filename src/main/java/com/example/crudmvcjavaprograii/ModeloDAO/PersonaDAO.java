
package com.example.crudmvcjavaprograii.ModeloDAO;


import com.example.crudmvcjavaprograii.Intefaces.CRUD;
import com.example.crudmvcjavaprograii.Modelo.Genero;
import com.example.crudmvcjavaprograii.Config.Conexion;
import com.example.crudmvcjavaprograii.Modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaDAO implements CRUD<Persona> {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona persona=new Persona();
    Genero genero = new Genero();
    
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();
        String sql="SELECT * FROM persona p INNER JOIN genero g ON p.genero_id = g.id";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Persona per=new Persona();
                Genero genero = new Genero();

                getAttributesFromResultSet(per, genero);

                list.add(per);
            }
        } catch (SQLException e) {
        }
        return list.stream()
                .filter(persona->persona.isActivo()!=false)
                .collect(Collectors.toList());
    }

    @Override
    public Persona list(int id) {
        String sql="SELECT * FROM persona p INNER JOIN genero g ON p.genero_id = g.id where p.Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                getAttributesFromResultSet(persona, genero);

            }
        } catch (Exception e) {
        }
        return persona;
    }


    @Override
    public boolean add(Persona persona) {
       String sql="insert into persona(DPI, Nombres, genero_id)values('"+persona.getDpi()+"','"+persona.getNom()+"','"+persona.getGenero().getId()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

@Override
public boolean edit(Persona persona) {
    String sql = "UPDATE persona SET DPI=?, Nombres=?, genero_id = ? WHERE Id=?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, persona.getDpi());
        ps.setString(2, persona.getNom());
        ps.setInt(3,persona.getGenero().getId());
        ps.setInt(4, persona.getId());
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            return true; // La actualización fue exitosa
        }
    } catch (Exception e) {
        e.printStackTrace();
    } 
    return false;
}

    @Override
    public boolean eliminar(int id) {
        String sql="UPDATE persona SET activo = false WHERE id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    private void getAttributesFromResultSet(Persona p, Genero genero) throws SQLException {
        p.setId(rs.getInt("p.Id"));
        p.setDpi(rs.getString("p.DPI"));
        p.setNom(rs.getString("p.Nombres"));
        p.setActivo(rs.getBoolean("p.activo"));

        genero.setId(rs.getInt("g.id"));
        genero.setNombre(rs.getString("g.nombre"));
        genero.setDescripcion(rs.getString("g.descripcion"));
        p.setGenero(genero);
    }
    
}
