package projeto.consulta.fipe.main;

import com.fasterxml.jackson.core.type.TypeReference;
import projeto.consulta.fipe.model.DadosVeiculo;
import projeto.consulta.fipe.model.DetalhesVeiculo;
import projeto.consulta.fipe.model.ModelosAnosResponse;
import projeto.consulta.fipe.service.ApiConsumer;
import projeto.consulta.fipe.service.DataConversor;

import java.util.List;
import java.util.Scanner;

public class MainCode {
    private Scanner scanner = new Scanner(System.in);
    private ApiConsumer apiConsumer = new ApiConsumer();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1";
    private DataConversor dataConversor = new DataConversor();

    public void runApplication(){
        System.out.println("Você quer ver a Tabela para Carros, Motos ou Caminhões?");
        var tipo = scanner.nextLine();
        var jsonMarca = apiConsumer.processData(ENDERECO+"/" + tipo.toLowerCase() + "/marcas");
        List<DadosVeiculo> marcas = dataConversor.processListDataConversor(jsonMarca, new TypeReference<List<DadosVeiculo>>() {});
        System.out.println("Marcas encontradas:");
        for(DadosVeiculo marca : marcas){
            System.out.println("Código: " + marca.code() + " - Nome:" + marca.name());

        }
        System.out.println("Digite o código da marca que deseja buscar:");
        var codMarca = scanner.nextInt();
        scanner.nextLine();
        var jsonModelo = apiConsumer.processData(ENDERECO+"/" + tipo + "/marcas" +"/" +codMarca + "/modelos");
        ModelosAnosResponse modelosAnosResponse = dataConversor.processDataConversor(jsonModelo, ModelosAnosResponse.class);
        System.out.println("Modelos encontrados:");
        for(DadosVeiculo modelo : modelosAnosResponse.modelos()) {
            System.out.println("Código: " + modelo.code() + " - Nome: " + modelo.name());
        }
        System.out.println("Digite o nome do veículo para consulta:");
        var nomeVeiculo = scanner.nextLine();
        modelosAnosResponse.modelos().stream()
                .filter(c -> c.name().toLowerCase().contains(nomeVeiculo))
                .forEach(c -> System.out.println("Código: " + c.code() + " - Nome: " + c.name()));

        System.out.println("Digite o código do veículo para consulta de valores:");
        var codVeiculo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Valores por ano:");
        var jsonAnos = apiConsumer.processData(ENDERECO+"/" + tipo + "/marcas" +"/" +codMarca + "/modelos/" + codVeiculo + "/anos" );
        System.out.println(jsonAnos);
        List<DadosVeiculo> anosDisponiveis = dataConversor.processListDataConversor(jsonAnos, new TypeReference<>() {});
        for(DadosVeiculo ano : anosDisponiveis){
            String codigoAno = ano.code();
            String urlDetalhes = ENDERECO + "/" + tipo + "/marcas/" + codMarca + "/modelos/" + codVeiculo + "/anos/" + codigoAno;
            String jsonDetalhes = apiConsumer.processData(urlDetalhes);
            DetalhesVeiculo detalhes = dataConversor.processDataConversor(jsonDetalhes, DetalhesVeiculo.class);
            System.out.println("\nAno: " + detalhes.anoModelo());
            System.out.println("Modelo: " + detalhes.modelo());
            System.out.println("Valor: " + detalhes.valor());
            System.out.println("Combustível: " + detalhes.combustivel());
            System.out.println("Referência: " + detalhes.mesReferencia());
            System.out.println("--------------------------------");

        }
//
    }
}
