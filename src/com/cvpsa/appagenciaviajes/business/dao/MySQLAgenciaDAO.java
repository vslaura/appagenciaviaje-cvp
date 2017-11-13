package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.AgenciaDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.AgenciaDAO;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLAgenciaDAO implements AgenciaDAO {

	@Override
	public List<AgenciaDTO> listarAgencias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registrarAgencia(AgenciaDTO agenciaDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String obtenerDescripcionAgencia(String codigoAgencia) {

		String descripcionAgencia = "";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = MySQLConexion.getConexion();
			String sql = "select nombreAgencia from tb_agencia where codigoAgencia = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigoAgencia);
			rs = pst.executeQuery();

			while (rs.next()) {
				descripcionAgencia = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia obtener descripcion de la agencia: " + e);
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar ");
			}
		}
		return descripcionAgencia;

	}

}
