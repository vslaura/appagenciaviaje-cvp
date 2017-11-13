package com.cvpsa.appagenciaviajes.business.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que establece la conexion con la
 * base de datos
 * 
 * @author G'Macedo
 *
 */
public class MySQLConexion {

	/**
	 * Método estatico que devuelve la conexion
	 * con la base de datos
	 * 
	 * @return estado de conexion
	 */
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bd_appagenciaviajes";
			String usr = "root";
			String psw = "mysql";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD");
		}
		return con;
	}

}
