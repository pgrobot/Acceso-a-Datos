package aplicacionFCT.modelo;

import java.time.LocalDate;

public class Registro {

	private Long idRegistro;
	private Long idUsuario;
	private LocalDate fecha;
	private Double numHoras;
	private String descripcion;

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "registro [id_registro=" + idRegistro + ", id_usuario=" + idUsuario + ", fecha=" + fecha + ", num_horas="
				+ numHoras + ", descripcion=" + descripcion + "]";
	}

	public Long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Double getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(Double numHoras) {
		this.numHoras = numHoras;
	}

}
