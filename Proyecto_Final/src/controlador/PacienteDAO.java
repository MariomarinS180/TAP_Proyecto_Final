package controlador;


import conectorBaseDeDatos.ConexionBD;
import modelos.Paciente;

public class PacienteDAO {
	
	public boolean agregarPaciente(Paciente p) {
		String sql = "INSERT INTO Pacientes VALUES('"+p.getID_Paciente()+"','"+p.getNombre_Paciente()+"', '"+p.getApPaterno_Paciente()+"','"+p.getApMaterno_Paciente()+"','"+p.getTelefono_Paciente()+"','"+p.getEdad()+"', '"+p.getSexo()+"','"+p.getGravedad_Paciente()+"', '"+p.getCalle()+"', '"+p.getColonia()+"', '"+p.getNumero()+"');";
		boolean res = new ConexionBD().ejecutarInstruccion(sql);
		System.out.println(res);
		return res; 
	}
	
	
	
	
	
	
}//class
