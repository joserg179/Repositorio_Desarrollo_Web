package datos;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.EmpleadoVO;

public class EmpleadoDAO {
	
	private static String driver = "com.mysql.jdbc.Driver";
	
	public static Connection obtenerConexion() {
		Connection conexion = null;
		
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bateriasBD","root","admin1234");
		}catch(Exception e) {
			System.out.println("error al obtener la conexión");
		}
		
		return conexion;
	}
	
	
	public static int guardarEmpleado(EmpleadoVO empleado) {
		
		int estado = 0;
		
		try {
			Connection conexion = EmpleadoDAO.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO empleados(nombre,password,email,zona) VALUES (?,?,?,?)");
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getPassword());
			ps.setString(3, empleado.getEmail());
			ps.setString(4, empleado.getZona());
			
			estado = ps.executeUpdate();
			
			conexion.close();
			
			
		}catch(Exception e) {
			
		}
		
		
		return estado;
		
	}
	
	
	public static List<EmpleadoVO> obtenerEmpleados() {
		
		List<EmpleadoVO> listaEmpleados = new ArrayList<EmpleadoVO>();
		
		try {
			Connection conexion = EmpleadoDAO.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement("SELECT * FROM empleados");
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {
				EmpleadoVO empleado = new EmpleadoVO();
				empleado.setId(resultado.getInt(1));
				empleado.setNombre(resultado.getString(2));
				empleado.setPassword(resultado.getString(3));
				empleado.setEmail(resultado.getString(4));
				empleado.setZona(resultado.getString(5));
				listaEmpleados.add(empleado);
			}
			
			conexion.close();
			
			
		}catch(Exception e) {
			
		}
		
		return listaEmpleados;
		
	}
	
	public static int eliminar(EmpleadoVO empleado) {
		
		int estado=0;
		
		try {
			Connection conexion = EmpleadoDAO.obtenerConexion();
			PreparedStatement ps = conexion.prepareStatement("DELETE FROM empleados WHERE id=?");
			ps.setInt(1, empleado.getId());
			estado = ps.executeUpdate();
	
			conexion.close();
			
			
		}catch(Exception e) {
			
		}
		
		return estado;
	}
}
