package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.BusDTO;
import com.cvpsa.appagenciaviajes.business.bean.DepartamentoDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.DepartamentoDAO;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLDepartamentoDAO implements DepartamentoDAO {

	@Override
	public int registrarDepartamento(DepartamentoDTO departamentoDTO) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_departamento values (?, ?);";
			
			pst = con.prepareStatement(sql);
			pst.setString(1,departamentoDTO.getCodDep());
			pst.setString(2,departamentoDTO.getDescDep());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la sentencia registrar departamento: "
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
	public List<DepartamentoDTO> listarDepartamentos() {
	
		List<DepartamentoDTO> listaDepartamentos = new ArrayList<DepartamentoDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			
			con = MySQLConexion.getConexion();
			
			String sql = "select * from tb_departamento";			
			pst = con.prepareStatement(sql);
					
			rs = pst.executeQuery();

			while (rs.next()) {
				listaDepartamentos.add(
						new DepartamentoDTO(rs.getString(1), rs.getString(2)));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia listar departamentos: " + e);
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
		return listaDepartamentos;
		
	}

	@Override
	public String obtenerCodigoAutogeneradoDepartamento() {
		
		String codDepartamento = "DEP01";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "select max(cod_dep) from tb_departamento;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {
				codDepartamento = "DEP" + String.format("%02d", (Integer.parseInt(rs.getString(1).substring(3)) + 1));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia Obtener Codigo de Departamento: " + e);
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

		return codDepartamento;

	
	}


	@Override
	public String obtenerDescripcionDepartamento( String codigoDepartamento ) {

		String descripcionDepartamento = "";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			con = MySQLConexion.getConexion();
			String sql = "select desc_dep from tb_departamento where cod_dep = ?;";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigoDepartamento);
			rs = pst.executeQuery();

			while ( rs.next()) {
				descripcionDepartamento = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia obtener descripcion del departamento: " + e);
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
		return descripcionDepartamento;
	}


}
