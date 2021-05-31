package com.van.log.microservices.fipe.dtos.responses;

import java.util.List;

public class ModeloDtoResponse {

	private List<ModeloInternoDtoResponse> modelos;
	private List<AnoDtoResponse> anos;

	public List<ModeloInternoDtoResponse> getModelos() {
		return modelos;
	}

	public void setModelos(List<ModeloInternoDtoResponse> modelos) {
		this.modelos = modelos;
	}

	public List<AnoDtoResponse> getAnos() {
		return anos;
	}

	public void setAnos(List<AnoDtoResponse> anos) {
		this.anos = anos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anos == null) ? 0 : anos.hashCode());
		result = prime * result + ((modelos == null) ? 0 : modelos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloDtoResponse other = (ModeloDtoResponse) obj;
		if (anos == null) {
			if (other.anos != null)
				return false;
		} else if (!anos.equals(other.anos))
			return false;
		if (modelos == null) {
			if (other.modelos != null)
				return false;
		} else if (!modelos.equals(other.modelos))
			return false;
		return true;
	}

}
