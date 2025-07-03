package projeto.consulta.fipe.model;

import java.util.List;

public record ModelosAnosResponse(
        List<DadosVeiculo> modelos,
        List<DadosVeiculo> anos
) {}