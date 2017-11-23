package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.ViajeDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.ViajeDAO;
import com.cvpsa.appagenciaviajes.business.utils.DataBase;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLViajeDAO implements ViajeDAO {

	DataBase dataBase = new DataBase();
	
	@Override
	public int registrarViaje(ViajeDTO viajeDTO) {

		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_viaje values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			pst = con.prepareStatement(sql);
			pst.setString(1, viajeDTO.getCodVje());
			pst.setString(2, viajeDTO.getCodEmp());
			pst.setString(3, viajeDTO.getCodBus());
			pst.setString(4, viajeDTO.getFecPartiVje());
			pst.setString(5, viajeDTO.getFecLlgarVje());
			pst.setString(6, viajeDTO.getCodDepOrigen());
			pst.setString(7, viajeDTO.getCodDepDestino());
			pst.setString(8, viajeDTO.getCodigoAgencia());
			pst.setInt(9, viajeDTO.getCantidadAsientos());
			pst.setDouble(10, viajeDTO.getPrecioViaje());

			dataBase.almacenarInsercion("viaje", pst.toString(), "viaje.txt");

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la sentencia registrar viaje : " + ex);
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar ");
			}
		}
		return rs;
	}

	@Override
	public List<ViajeDTO> listarViajes() {
		List<ViajeDTO> listaViajes = new ArrayList<ViajeDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_viaje";

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

				while (rs.next()) {
				listaViajes.add(new ViajeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10)));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia listar Viaje: " + e);
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
		return listaViajes;
	}

	@Override
	public ViajeDTO buscarViaje( String codVje ) {
		
		ViajeDTO viajeDTO = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_viaje where cod_vje = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, codVje);

			rs = pst.executeQuery();

		
			while (rs.next()) {
				viajeDTO = new ViajeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10));
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia buscar viaje: " + e);
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
		return viajeDTO;
		
	}

	@Override
	public List<ViajeDTO> listarViajesPorOrigenDestinoFecha(String codigoOrigen, String codigoDestino, String fecha) {

		List<ViajeDTO> listaViajes = new ArrayList<ViajeDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_viaje where cod_dep_origen = ? and cod_dep_destino = ? and fec_par_vje = ?;";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigoOrigen);
			pst.setString(2, codigoDestino);
			pst.setString(3, fecha);

			rs = pst.executeQuery();
	
			while (rs.next()) {
				listaViajes.add(new ViajeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10)));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia listar Viaje: " + e);
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
		return listaViajes;
	}

	@Override
	public String obtenerCodigoAutogenerado() {

		String codigoViaje = "V0001";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "select max(cod_vje) FROM tb_viaje";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {
				codigoViaje = "V" + String.format("%04d", (Integer.parseInt(rs.getString(1).substring(1)) + 1));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia generar codigo de viaje: " + e);
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

		return codigoViaje;
	}

}
