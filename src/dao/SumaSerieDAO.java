package dao;

import db.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SumaSerieDAO {

    public void registrarSuma(int n, String procedimiento, int resultado) {
        String sql = "INSERT INTO SUMA_SERIE (VALOR_N, PROCEDIMIENTO, RESULTADO) VALUES (?,?,?)";

        try (Connection conn = ConexionOracle.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, n);
            ps.setString(2, procedimiento);
            ps.setInt(3, resultado);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   
