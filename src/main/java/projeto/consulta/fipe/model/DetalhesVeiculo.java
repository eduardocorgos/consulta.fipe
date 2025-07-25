package projeto.consulta.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DetalhesVeiculo(
        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") int anoModelo,
        @JsonAlias("Combustivel") String combustivel,
        @JsonAlias("CodigoFipe") String codigoFipe,
        @JsonAlias("MesReferencia") String mesReferencia,
        @JsonAlias("SiglaCombustivel") String siglaCombustivel
) {}