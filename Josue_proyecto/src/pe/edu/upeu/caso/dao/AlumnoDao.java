package pe.edu.upeu.caso.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.caso.entity.Alumno;

public interface AlumnoDao {
	public int create(Alumno u);
	public int update(Alumno u);
	public int delete(int id);
	public List<Map<String,Object>> read(int id);
	public List<Map<String,Object>> readAll();
}
