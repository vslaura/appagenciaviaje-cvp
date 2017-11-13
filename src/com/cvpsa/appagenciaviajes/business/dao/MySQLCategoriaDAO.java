package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.CategoriaDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.CategoriaDAO;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLCategoriaDAO implements CategoriaDAO {

	@Override
	public int registrarCategoria(CategoriaDTO categoriaDTO) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_categoria values (?, ?);";

			pst = con.prepareStatement(sql);
			pst.setInt(1,categoriaDTO.getCodCate());
			pst.setString(2, categoriaDTO.getTipoCate());

			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la sentencia registrar categoria: "
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
	public List<CategoriaDTO> listarCategorias() {
		
		List<CategoriaDTO> listaCategorias = 
				new ArrayList<CategoriaDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_categoria";

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				listaCategorias.add(new CategoriaDTO(rs.getInt(1), rs.getString(2)));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia listar categorias: " + e);
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
		return listaCategorias;
	}

	@Override
	public List<CategoriaDTO> buscarCategoria(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminarCategoria(String codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarCategoria(CategoriaDTO categoriaDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
