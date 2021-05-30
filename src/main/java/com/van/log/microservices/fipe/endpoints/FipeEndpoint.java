package com.van.log.microservices.fipe.endpoints;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.van.log.microservices.fipe.dtos.responses.MarcaDtoReponse;
import com.van.log.microservices.fipe.dtos.responses.ModeloDtoResponse;

@FeignClient(name = "${feign.fipe}", url = "${feign.url_fipe}")
public interface FipeEndpoint {

	@GetMapping("/marcas")
	public List<MarcaDtoReponse> getMarcas();

	@GetMapping("/marcas/{codigoMarca}/modelos")
	public ModeloDtoResponse getDadosAnoModelo(@PathVariable String codigoMarca);
	
}
