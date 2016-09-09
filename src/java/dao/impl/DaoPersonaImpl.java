/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoPersonas;
import dto.Personas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import sql.ConectaDB;

public class DaoPersonaImpl implements DaoPersonas{
    private final ConectaDB db;

    public DaoPersonaImpl() {
        db = new ConectaDB("postgres");
    }
    @Override
    public List<Personas> personaQry() {
        List <Personas> list = null;
        String sql =""
                + "select "
                + "ide, "
                + "dni, "
                + "apepad, "
                + "nombres, "
                + "celular, "
                + "correo, "
                + "direccion, "
                + "longitud, "
                + "latitud "
                + " from "
                + "empleado"
                + "";
       Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Personas n= new Personas();
                    n.setIde(rs.getInt(1));
                    n.setDni(rs.getInt(2));
                    n.setApepad(rs.getString(3));
                    n.setNombres(rs.getString(4));
                    n.setCelular(rs.getInt(5));
                    n.setCorreo(rs.getString(6));
                    n.setDireccion(rs.getString(7));
                    n.setLongitud(rs.getDouble(8));
                    n.setLatitud(rs.getDouble(9));
                    list.add(n);
                }
               } catch (SQLException e) {
                list = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    list = null;
                }
            }
        }

        return list;   
    
    }

    @Override
    public String personasIns(Personas personas) {
        String result = null;
        String sql = "INSERT INTO EMPLEADO (DNI,APEPAD,NOMBRES,CELULAR,CORREO,DIRECCION,LONGITUD,LATITUD) VALUES(?,?,?,?,?,?,?,?)";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1,personas.getDni());
                ps.setString(2,personas.getApepad());
                ps.setString(3,personas.getNombres());
                ps.setInt(4,personas.getCelular());
                ps.setString(5,personas.getCorreo());
                ps.setString(6,personas.getDireccion());
                ps.setDouble(7,personas.getLongitud());
                ps.setDouble(8,personas.getLatitud());
                int cts = ps.executeUpdate();
                if (cts == 0) {
                    throw new SQLException("0 filas afectadas");
                }
            } catch (SQLException e) {
                result = "Error al insertar...";
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = null;
                }
            }
        }

        return result;
                
    }

    @Override
    public String personasDel(List<Integer> ide) {
        String result = null;
        String sql = "DELETE FROM empleado WHERE ide=?";
        Connection cn = db.getConnection();
        if (cn != null) {
            boolean ok = false;
            try {
                cn.setAutoCommit(false);
                PreparedStatement ps = cn.prepareStatement(sql);
                for (int row : ide) {
                    ps.setInt(1, row);
                    int ctos = ps.executeUpdate();
                    if (ctos == 0) {
                        throw new SQLException("Ide de la tabla no existe");
                    }
                }
                ok = true;
            } catch (SQLException e) {
                result = "Error al eliminar...no se encuentra en la tabla";
            } finally {
                try {
                    if (ok) {
                        cn.commit();
                    } else {
                        cn.rollback();
                    }
                    cn.setAutoCommit(true);
                    cn.close();
                } catch (SQLException e) {
                    result = "Error al eliminar...";
                }
            }
        }

        return result;
    }

    @Override
    public Personas personasGet(Integer ide) {
     Personas personas = null;
     String sql=""
                + "select "
                + "ide, "
                + "dni, "
                + "apepad, "
                + "nombres, "
                + "celular, "
                + "correo, "
                + "direccion,"
                + "longitud, "
                + "latitud "
                + " from "
                + "empleado "
                + "where "
                + "ide = ?"
                + "";
     Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, ide);
                ResultSet rs = ps.executeQuery();

                personas = new Personas();
                if (rs.next()) {
                    personas.setIde(rs.getInt(1));
                    personas.setDni(rs.getInt(2));
                    personas.setApepad(rs.getString(3));
                    personas.setNombres(rs.getString(4));
                    personas.setCelular(rs.getInt(5));
                    personas.setCorreo(rs.getString(6));
                    personas.setDireccion(rs.getString(7));
                    personas.setLongitud(rs.getDouble(8));
                    personas.setLatitud(rs.getDouble(9));
                   
                }
            } catch (SQLException e) {
                personas = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    personas = null;
                }
            }
        }

        return personas; 
     
    }

    @Override
    public String personasUpd(Personas personas) {
        String result = null;
        String sql = "UPDATE EMPLEADO "
                + "SET DNI = ?, APEPAD = ?, NOMBRES = ?, CELULAR = ?, CORREO = ?, DIRECCION = ?, LONGITUD = ?, LATITUD = ? "
                + "WHERE IDE = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, personas.getDni());
                ps.setString(2, personas.getApepad());
                ps.setString(3, personas.getNombres());
                ps.setInt(4, personas.getCelular());
                ps.setString(5, personas.getCorreo());
                ps.setString(6, personas.getDireccion());
                ps.setDouble(7, personas.getLongitud());
                ps.setDouble(8, personas.getLatitud());
                ps.setInt(9, personas.getIde());

                int cts = ps.executeUpdate();
                if (cts == 0) {
                    throw new SQLException("0 filas afectadas");
                }
            } catch (SQLException e) {
                result = "Error al actualizar...";
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = null;
                }
            }
        }

        return result;
    }
    

    
 
}
