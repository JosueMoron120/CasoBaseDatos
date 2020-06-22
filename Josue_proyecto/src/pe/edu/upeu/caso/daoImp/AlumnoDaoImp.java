package pe.edu.upeu.caso.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.caso.dao.AlumnoDao;
import pe.edu.upeu.caso.entity.Alumno;
import pe.edu.upeu.caso.util.Conexion;

public class AlumnoDaoImp implements AlumnoDao {
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;
	
	@Override
	public int create(Alumno u) {
		// TODO Auto-generated method stub
		int x = 0;
		String sql ="INSERT INTO bd_moron.alumnos (idalumnos, idescuela, nombre, correo, telefono) VALUES (NULL, ?, ?, ?, ?)";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setString(2, u.getNombre());
			ps.setString(3, u.getCorreo());
			ps.setString(4, u.getTelefono());
			ps.setInt(1, u.getIdescuela());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int update(Alumno u) {
		// TODO Auto-generated method stub
		int x = 0;
		String sql = "UPDATE bd_moron.alumnos SET idescuela = ?, nombre = ?, correo = ?, telefono = ? WHERE idalumnos = ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, u.getIdescuela());
			ps.setString(2, u.getNombre());
			ps.setString(3, u.getCorreo());
			ps.setString(4, u.getTelefono());
			ps.setInt(5, u.getIdalumnos());
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int delete(int id) {
		int x = 0;
		// TODO Auto-generated method stub
		String sql= "DELETE FROM bd_moron.alumnos WHERE idalumnos= ?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return x;
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = "select e.idescuela, e.nombre_escuela, "+
		             "a.idalumnos, a.nombre, "+ 
				     "a.correo, a.telefono from alumnos as a,"+
		             " bd_moron.escuela as e where e.idescuela = a.idescuela and a.idalumnos=?";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
                map.put("idescuela", rs.getInt("idescuela"));
                map.put("nombre_escuela", rs.getString("nombre_escuela"));
                map.put("idalumnos", rs.getInt("idalumnos"));
                map.put("nombre", rs.getString("nombre"));
                map.put("correo", rs.getString("correo"));
                map.put("telefono", rs.getString("telefono"));
			    list.add(map);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = "select e.idescuela, e.nombre_escuela, "+
		             "a.idalumnos, a.nombre, "+ 
				     "a.correo, a.telefono from bd_moron.alumnos as a,"+
		             "bd_moron.escuela as e where e.idescuela = a.idescuela";
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
                map.put("idescuela", rs.getInt("idescuela"));
                map.put("nombre_escuela", rs.getString("nombre_escuela"));
                map.put("idalumnos", rs.getInt("idalumnos"));
                map.put("nombre", rs.getString("nombre"));
                map.put("correo", rs.getString("correo"));
                map.put("telefono", rs.getString("telefono"));
			    list.add(map);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
