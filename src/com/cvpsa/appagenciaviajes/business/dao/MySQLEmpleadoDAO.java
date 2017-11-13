package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.EmpleadoDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.EmpleadoDAO;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLEmpleadoDAO implements EmpleadoDAO {

	@Override
	public int registrarEmpleado(EmpleadoDTO empleadoDTO) {

		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_empleado values (?, ?, ?, ?, ?);";

			pst = con.prepareStatement(sql);
			pst.setString(1, empleadoDTO.getCodEmp());
			pst.setString(2, empleadoDTO.getDniEmp());
			pst.setString(3, empleadoDTO.getNomEmp());
			pst.setString(4, empleadoDTO.getApellEmp());
			pst.setInt(5, empleadoDTO.getCategoria());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la sentencia registrar empleado: " + ex);
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
	public List<EmpleadoDTO> listarEmpleados() {

		List<EmpleadoDTO> listaEmpleados = new ArrayList<EmpleadoDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_empleado";

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				listaEmpleados.add(new EmpleadoDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5)));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia listar empleados: " + e);
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
		return listaEmpleados;
	}

	@Override
	public List<EmpleadoDTO> buscarEmpleado(String codEmp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminarEmpleado(String codEmp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarEmpleado(EmpleadoDTO empleadoDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String obtenerCodigoAutogeneradoEmpleado() {

		String codEmple = "EA001";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "select max(cod_em) from tb_empleado;";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {
				codEmple = "EC" + String.format("%03d", (Integer.parseInt(rs.getString(1).substring(2)) + 1));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia Obtener Codigo Empleado :" + e );
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

		return codEmple;
	}
}
