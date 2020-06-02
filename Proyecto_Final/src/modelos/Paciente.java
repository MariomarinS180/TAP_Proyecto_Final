package modelos;
public class Paciente {
	private String ID_Paciente; 
	private String nombre_Paciente; 
	private String apPaterno_Paciente; 
	private String apMaterno_Paciente; 
	private String telefono_Paciente;
	private int gravedad_Paciente; 
	private String calle;
	private String colonia; 
	private int numero;
	private int sexo; 
	private int edad; 
	public Paciente() {}
	public Paciente(String iD_Paciente, String nombre_Paciente, String apPaterno_Paciente, String apMaterno_Paciente,
			String telefono_Paciente, int gravedad_Paciente, String calle, String colonia, int numero, int sexo,
			int edad) {
		ID_Paciente = iD_Paciente;
		this.nombre_Paciente = nombre_Paciente;
		this.apPaterno_Paciente = apPaterno_Paciente;
		this.apMaterno_Paciente = apMaterno_Paciente;
		this.telefono_Paciente = telefono_Paciente;
		this.gravedad_Paciente = gravedad_Paciente;
		this.calle = calle;
		this.colonia = colonia;
		this.numero = numero;
		this.sexo = sexo;
		this.edad = edad;
	}//Constructor
	public String getID_Paciente() {
		return ID_Paciente;
	}
	public void setID_Paciente(String iD_Paciente) {
		ID_Paciente = iD_Paciente;
	}
	public String getNombre_Paciente() {
		return nombre_Paciente;
	}
	public void setNombre_Paciente(String nombre_Paciente) {
		this.nombre_Paciente = nombre_Paciente;
	}
	public String getApPaterno_Paciente() {
		return apPaterno_Paciente;
	}
	public void setApPaterno_Paciente(String apPaterno_Paciente) {
		this.apPaterno_Paciente = apPaterno_Paciente;
	}
	public String getApMaterno_Paciente() {
		return apMaterno_Paciente;
	}
	public void setApMaterno_Paciente(String apMaterno_Paciente) {
		this.apMaterno_Paciente = apMaterno_Paciente;
	}
	public String getTelefono_Paciente() {
		return telefono_Paciente;
	}
	public void setTelefono_Paciente(String telefono_Paciente) {
		this.telefono_Paciente = telefono_Paciente;
	}
	public int getGravedad_Paciente() {
		return gravedad_Paciente;
	}
	public void setGravedad_Paciente(int gravedad_Paciente) {
		this.gravedad_Paciente = gravedad_Paciente;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}//class