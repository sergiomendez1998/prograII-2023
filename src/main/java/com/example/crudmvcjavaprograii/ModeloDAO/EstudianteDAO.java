package com.example.crudmvcjavaprograii.ModeloDAO;

import com.example.crudmvcjavaprograii.Config.Conexion;
import com.example.crudmvcjavaprograii.Intefaces.CRUD;
import com.example.crudmvcjavaprograii.Modelo.Estudiante;
import com.example.crudmvcjavaprograii.Modelo.Sede;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO implements CRUD<Estudiante> {

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        ArrayList<Estudiante> list=new ArrayList<>();
        String sql="select * from estudiantes e inner join sedes s on e.sede_id = s.id";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){
                Estudiante estudiante=new Estudiante();
                estudiante.setId(rs.getInt("e.id"));
                estudiante.setCarnet(rs.getString("e.carnet"));
                estudiante.setNombre(rs.getString("e.nombre"));
                estudiante.setApellido(rs.getString("e.apellido"));
                estudiante.setEdad(rs.getInt("e.edad"));

                Sede sede = new Sede();
                sede.setId(rs.getInt("s.id"));
                sede.setNombre(rs.getString("s.nombre"));
                sede.setDescripcion(rs.getString("s.descripcion"));
            }
        } catch (SQLException e) {
        }
       return list;
    }

    @Override
    public Estudiante list(int id) {
        return null;
    }

    @Override
    public boolean add(Estudiante entity) {
        String sql="insert into estudiantes (carnet, nombre, apellido, edad, sede_id) values (?,?,?,?,?)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, entity.getCarnet());
            ps.setString(2, entity.getNombre());
            ps.setString(3, entity.getApellido());
            ps.setInt(4, entity.getEdad());
            ps.setInt(5, entity.getSede().getId());
            ps.execute();
        } catch (SQLException e) {
        }
        return false;
    }

    @Override
    public boolean edit(Estudiante entity) {
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }
}
