/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import dto.LibroDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class LibroDAO {

    public boolean insertar(LibroDTO libro) throws SQLException {
        String sql = "INSERT INTO libros (titulo, autor, ejemplares) VALUES (?, ?, ?)";
        try (Connection cn = Conexion.obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setInt(3, libro.getEjemplares());
            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }

    public List<LibroDTO> listar() throws SQLException {
        String sql = "SELECT id, titulo, autor, ejemplares FROM libros ORDER BY id";
        List<LibroDTO> libros = new ArrayList<>();
        try (Connection cn = Conexion.obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ejemplares = rs.getInt("ejemplares");
                LibroDTO libro = new LibroDTO(id, titulo, autor, ejemplares);
                libros.add(libro);
            }
        }
        return libros;
    }
}
