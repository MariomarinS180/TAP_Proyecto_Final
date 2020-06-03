package controlador;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import conectorBaseDeDatos.ConexionBD;
import modelos.Paciente;

public class PacienteDAO {
	public boolean agregarUsuario(InicioDeSesion is) {
		String sql = "INSERT INTO Usuario VALUES('"+is.getUsuario()+"','"+is.getPassword()+"');";
		boolean res = new ConexionBD().ejecutarInstruccion(sql);
		return res; 
	}
	
	public boolean agregarPaciente(Paciente p) {
		String sql = "INSERT INTO Pacientes VALUES('"+p.getID_Paciente()+"','"+p.getNombre_Paciente()+"', '"+p.getApPaterno_Paciente()+"','"+p.getApMaterno_Paciente()+"','"+p.getTelefono_Paciente()+"','"+p.getEdad()+"', '"+p.getSexo()+"','"+p.getGravedad_Paciente()+"', '"+p.getCalle()+"', '"+p.getColonia()+"', '"+p.getNumero()+"');";
		boolean res = new ConexionBD().ejecutarInstruccion(sql);
		System.out.println(res);
		return res; 
	}
	
	
	public void buscarUsuariosConTableModel(DefaultTableModel model) {

		ConexionBD conex = new ConexionBD();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM Pacientes ");

			while (rs.next()) {
				// es para obtener los datos y almacenar las filas
				Object[] fila = new Object[10];
				// para llenar cada columna con lo datos almacenados
				for (int i = 0; i <10 ; i++)
					fila[i] = rs.getObject(i + 1);
				// es para cargar los datos en filas a la tabla modelo
				model.addRow(fila);
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}//Class Paciente DAO