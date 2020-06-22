package pe.edu.upeu.caso.test;

import com.google.gson.Gson;

import pe.edu.upeu.caso.dao.AlumnoDao;
import pe.edu.upeu.caso.dao.EscuelaDao;
import pe.edu.upeu.caso.daoImp.AlumnoDaoImp;
import pe.edu.upeu.caso.daoImp.EscuelaDaoImp;
import pe.edu.upeu.caso.util.Conexion;

public class Test {
	private static AlumnoDao pd = new AlumnoDaoImp();
	private static EscuelaDao ed = new EscuelaDaoImp();
	private static Gson g = new Gson();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listarP();
		//conex();
	}
	static void listarP() {
		  System.out.println(g.toJson(ed.readAll()));
	 }
	 static void conex() {
	      if(Conexion.getConexion() != null) {
	          System.out.println("Conectado");
	      }else {
	          System.out.println("Desconectado");
	      }


	  }
}
