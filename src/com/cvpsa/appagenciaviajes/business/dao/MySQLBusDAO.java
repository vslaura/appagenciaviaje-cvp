package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.BusDAO;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLBusDAO implements BusDAO {

	@Override
	public int registrarBus(BusDTO busDTO) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_bus values (?, ?, ?, ?, ?, ?);";
			
			pst = con.prepareStatement(sql);
			pst.setString(1,busDTO.getCodBus());
			pst.setString(2,busDTO.getPlacaBus());
			pst.setString(3, busDTO.getColorBus());
			pst.setString(4,busDTO.getMarcaBus());
			pst.setInt(5,busDTO.getAsientoBus());
			pst.setString(6, busDTO.getEstadoBus());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la sentencia registrar bus: "
					+ ex);
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
	public int eliminarBus(String codBus) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarBus(BusDTO busDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BusDTO> buscarBus(String codBus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BusDTO> listarBuses(String estado) {
		
		List<BusDTO> listaBuses = new ArrayList<BusDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			
			con = MySQLConexion.getConexion();
			String sql = "";
			
			if (estado.equals("null")){
				sql = "select * from tb_bus";
				pst = con.prepareStatement(sql);
			}
			else if (estado.equals("") || estado == null || estado.equals("EB000")){
				sql = "select * from tb_bus";
				pst = con.prepareStatement(sql);
			}else{
				sql = "select * from tb_bus where cod_est_bus = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, estado);
			}
			
			rs = pst.executeQuery();

			while (rs.next()) {
				listaBuses.add(
						new BusDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia listar Buses servicio: " + e);
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
		return listaBuses;
	}

	@Override
	public String obtenerCodigoAutogenerado() {
			
			String codBus = "B0001";
			
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
						
				con = MySQLConexion.getConexion();
				
				String sql = "select max(cod_bus) FROM tb_bus";
				pst = con.prepareStatement(sql);
				
				rs = pst.executeQuery(); 

				if (rs.next()) { 
					codBus = "B" + String.format("%04d", (Integer.parseInt(rs.getString(1).substring(1)) + 1));
				}

			} catch (Exception e) {
				System.out.println("Error en la sentencia Obtener Codigo");
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
}
