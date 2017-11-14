package com.cvpsa.appagenciaviajes.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cvpsa.appagenciaviajes.business.bean.ClienteDTO;
import com.cvpsa.appagenciaviajes.business.interfaces.ClienteDAO;
import com.cvpsa.appagenciaviajes.business.utils.DataBase;
import com.cvpsa.appagenciaviajes.business.utils.MySQLConexion;

public class MySQLClienteDAO implements ClienteDAO {

	DataBase dataBase = new DataBase();
	
	@Override
	public int registrarCliente(ClienteDTO clienteDTO) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_cliente values (?, ?, ?, ?, ?, ?, ?);";

			pst = con.prepareStatement(sql);
			pst.setString(1, clienteDTO.getCodCli());
			pst.setString(2, clienteDTO.getDniCli());
			pst.setString(3, clienteDTO.getNomCli());
			pst.setString(4, clienteDTO.getApeCli());
			pst.setString(5, clienteDTO.getEmailCli());
			pst.setString(6, clienteDTO.getUsuarioCli());
			pst.setString(7, clienteDTO.getClaveCli());
			
			dataBase.almacenarInsercion("cliente", pst.toString(), "cliente.txt");
			
			rs = pst.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Error en la sentencia registrar cliente: " + ex);
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
	public int actualizarCliente(ClienteDTO clienteDTO) {
		
		Connection con = null;
		PreparedStatement pst = null;
		int rs = 0;
		try {
			
			con = MySQLConexion.getConexion(); 

			String sql = "update tb_cliente  set nom_cli =?, apell_cli =?,email_cli =?,usu_cli =?,cla_cli =? where cod_cli =?";
			pst = con.prepareStatement(sql);
			
			
			pst.setString(1, clienteDTO.getNomCli());
			pst.setString(2, clienteDTO.getApeCli());
			pst.setString(3, clienteDTO.getEmailCli());
			pst.setString(4, clienteDTO.getUsuarioCli());
			pst.setString(5, clienteDTO.getClaveCli());
			pst.setString(6, clienteDTO.getCodCli());
			
			rs = pst.executeUpdate();
		
			System.out.println("Actualizacion con exito");
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia al Actualizar cliente: " + e);
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar.");
			}
		}
		return rs;
	}

	@Override
	public List<ClienteDTO> listarClientes() {

		List<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_cliente";

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				listaClientes.add(new ClienteDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia listar clientes: " + e);
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
		return listaClientes;
	}

	@Override
	public ClienteDTO buscarCliente(String nombreUsuario, String clave) {

		ClienteDTO clienteDTO = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			con = MySQLConexion.getConexion();
			
			String sql = "select * from tb_cliente where usu_cli = ? and cla_cli = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, nombreUsuario);
			pst.setString(2, clave);
			
			rs = pst.executeQuery();
			
			while ( rs.next() ) {

				clienteDTO = new ClienteDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia buscar cliente (detalle): " + e);
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
		return clienteDTO;
	}

	@Override
	public ClienteDTO detalleCliente(String codigo) {
		
		return null;
	}

	@Override
	public ClienteDTO consultarCliente(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminarCliente(String codigo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String obtenerCodigoAutogeneradoCliente() {

		String codCliente = "C0001";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySQLConexion.getConexion();

			String sql = "select max(cod_cli) from tb_cliente";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			if (rs.next()) {
				codCliente = "C" + String.format("%04d", (Integer.parseInt(rs.getString(1).substring(1)) + 1));
			}

		} catch (Exception e) {
			System.out.println("Error en la sentencia Obtener Codigo de Cliente");
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

		return codCliente;

	}
}
