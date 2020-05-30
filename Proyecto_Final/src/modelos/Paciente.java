package modelos;
public class Paciente {
	private String ID_Paciente; 
	private String nombre_Paciente; 
	private String apPaterno_Paciente; 
	private String apMaterno_Paciente; 
	private String domicilo_Paciente; 
	private String telefono_Paciente; 
	private String motivo_Consulta; 
	private byte sexo; 
	private byte edad; 
	public Paciente() {}
	public Paciente(String iD_Paciente, String nombre_Paciente, String apPaterno_Paciente, String apMaterno_Paciente,
			String domicilo_Paciente, String telefono_Paciente, String motivo_Consulta, byte sexo, byte edad) {
		ID_Paciente = iD_Paciente;
		this.nombre_Paciente = nombre_Paciente;
		this.apPaterno_Paciente = apPaterno_Paciente;
		this.apMaterno_Paciente = apMaterno_Paciente;
		this.domicilo_Paciente = domicilo_Paciente;
		this.telefono_Paciente = telefono_Paciente;
		this.motivo_Consulta = motivo_Consulta;
		this.sexo = sexo;
		this.edad = edad;
	}
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
	public String getDomicilo_Paciente() {
		return domicilo_Paciente;
	}
	public void setDomicilo_Paciente(String domicilo_Paciente) {
		this.domicilo_Paciente = domicilo_Paciente;
	}
	public String getTelefono_Paciente() {
		return telefono_Paciente;
	}
	public void setTelefono_Paciente(String telefono_Paciente) {
		this.telefono_Paciente = telefono_Paciente;
	}
	public String getMotivo_Consulta() {
		return motivo_Consulta;
	}
	public void setMotivo_Consulta(String motivo_Consulta) {
		this.motivo_Consulta = motivo_Consulta;
	}
	public byte getSexo() {
		return sexo;
	}
	public void setSexo(byte sexo) {
		this.sexo = sexo;
	}
	public byte getEdad() {
		return edad;
	}
	public void setEdad(byte edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Paciente [ID_Paciente=" + ID_Paciente + ", nombre_Paciente=" + nombre_Paciente + ", apPaterno_Paciente="
				+ apPaterno_Paciente + ", apMaterno_Paciente=" + apMaterno_Paciente + ", domicilo_Paciente="
				+ domicilo_Paciente + ", telefono_Paciente=" + telefono_Paciente + ", motivo_Consulta="
				+ motivo_Consulta + ", sexo=" + sexo + ", edad=" + edad + "]";
	}
}//class