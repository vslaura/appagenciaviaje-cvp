package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.PasajeDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.PasajeDAO;
import com.cvpsa.appagenciaviajes.business.utils.DataBase;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLPasajeDAO implements PasajeDAO {

//	DataBase dataBase = new DataBase();
	
	@Override
	public int registrarPasaje(PasajeDTO pasajeDTO) {

		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			con = MySQLConexion.getConexion();
				String sql = "insert into tb_pasaje values (?, ?, null, null, ?, ?, 'No', 'No');";

			pst = con.prepareStatement(sql);
			pst.setString(1, pasajeDTO.getCodPje());
			pst.setInt(2, pasajeDTO.getNroAsientoPje());
			pst.setString(3, pasajeDTO.getCodClie());
			pst.setString(4, pasajeDTO.getCodVje());

//			dataBase.almacenarInsercion("pasaje", pst.toString(), "pasaje.txt");
			
			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la sentencia registrar pasaje : " + ex);
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
	public List<PasajeDTO> listarPasajes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PasajeDTO> buscarPasaje(String codPje) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminarPasaje(String codPje) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarPasaje(PasajeDTO pasajeDTO) {
		
		return 0;
	}

	@Override
	public String generarCodigoPasaje() {

		String codBus = "P0001";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "select max(cod_psje) FROM tb_pasaje";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {
				codBus = "P" + String.format("%04d", (Integer.parseInt(rs.getString(1).substring(1)) + 1));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia generar codigo de pasaje: " + e);
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

		return codBus;
	}

	@Override
	public List<PasajeDTO> listaPasajesCliente(String codigoCliente) {

		List<PasajeDTO> listaPasajes = new ArrayList<PasajeDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = MySQLConexion.getConexion();

			String sql = "select * from tb_pasaje where cod_cli = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigoCliente);

			rs = pst.executeQuery();

		
			while (rs.next()) {
				listaPasajes.add(new PasajeDTO(rs.getString(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));

			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia generar codigo de pasaje: " + e);
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

		return listaPasajes;
	}

	@Override
	public List<PasajeDTO> listaPasajesReservados ( String codigoViaje ) {
		
		List<PasajeDTO> listaPasajes = new ArrayList<PasajeDTO>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			con = MySQLConexion.getConexion();			
			String sql = "select * from tb_pasaje where reservado = 'Si' and cod_vje = ?;";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigoViaje );
			
			rs = pst.executeQuery();
			
			while ( rs.next() ) {
				
				listaPasajes.add(new PasajeDTO(rs.getString(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar pasajes reservados: " + e);
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
		return listaPasajes;
	}

	@Override
	public List<PasajeDTO> listaPasajesNoReservados( String codigoViaje ) {

		List<PasajeDTO> listaPasajes = new ArrayList<PasajeDTO>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			con = MySQLConexion.getConexion();			
			String sql = "select * from tb_pasaje where reservado = 'No' and cod_vje = ?;";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, codigoViaje);
			
			rs = pst.executeQuery();
			
			while ( rs.next() ) {
				
				listaPasajes.add(new PasajeDTO(rs.getString(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
				
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar pasajes no reservados: " + e);
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
		return listaPasajes;
	}

	@Override
	public int adquirirPasajeCliente( String codigoCliente, String fechaReserva, String horaReserva, String codigoPasaje, String cambio) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		
		String sql = "";
		
		try {
			
			con = MySQLConexion.getConexion();
			
			if ( cambio.equals("Si")) {
				sql = "update tb_pasaje set cod_cli = ?, reservado = 'Si', fech_comp_psje = ?, hora_psje = ?, actualizado = 'Si' where cod_psje = ?;";
			} else {
				sql = "update tb_pasaje set cod_cli = ?, reservado = 'Si', fech_comp_psje = ?, hora_psje = ? where cod_psje = ?;";
			}
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigoCliente);
			pst.setString(2, fechaReserva);
			pst.setString(3, horaReserva);
			pst.setString(4, codigoPasaje);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia obtener pasaje: " + e);
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
		return rs;
	}

	@Override
	public int deshabilitarPasajeCliente( String codigoPasaje ) {
	
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		
		try {
			
			con = MySQLConexion.getConexion();
			String sql = "update tb_pasaje set cod_cli = '', reservado = 'No', fech_comp_psje = null, hora_psje = null where cod_psje = ?;";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigoPasaje);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia obtener pasaje: " + e);
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
		return rs;
	}

}
 

