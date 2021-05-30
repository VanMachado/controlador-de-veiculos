package com.van.log.microservices.fipe.dtos.responses;

import java.util.List;

public class ModeloDtoResponse {

	private List<ModeloInternoDtoResponse> modelosInternos;
	private List<AnoDtoResponse> anos;

	public List<ModeloInternoDtoResponse> getModelosInternos() {
		return modelosInternos;
	}

	public void setModelosInternos(List<ModeloInternoDtoResponse> modelosInternos) {
		this.modelosInternos = modelosInternos;
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
		result = prime * result + ((modelosInternos == null) ? 0 : modelosInternos.hashCode());
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
		if (modelosInternos == null) {
			if (other.modelosInternos != null)
				return false;
		} else if (!modelosInternos.equals(other.modelosInternos))
			return false;
		return true;
	}

}
