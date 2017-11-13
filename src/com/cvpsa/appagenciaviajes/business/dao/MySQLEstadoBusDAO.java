package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.EstadoBusDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.EstadoBusDAO;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLEstadoBusDAO implements EstadoBusDAO {

	@Override
	public List<EstadoBusDTO> listarEstadoBuses() {

		List<EstadoBusDTO> listadoEstadoBus = new ArrayList<EstadoBusDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = MySQLConexion.getConexion();
			String sql = "select * from tb_estado_bus";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				listadoEstadoBus.add(new EstadoBusDTO(rs.getString(1), rs.getString(2), rs.getString(3)));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia listar estado de buses: " + e);
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
		return listadoEstadoBus;
	}

	@Override
	public String obtenerDescripcionEstado(String codigoEstadoBus) {

		String descripcionEstadoBus = "";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = MySQLConexion.getConexion();
			String sql = "select desc_est_bus from tb_estado_bus where cod_est_bus = ?;";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigoEstadoBus);
			rs = pst.executeQuery();

			while ( rs.next()) {
				descripcionEstadoBus = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia obtener descripcion del estado: " + e);
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
		return descripcionEstadoBus;
	}

}
