package projeto.consulta.fipe.service;

public interface IdataConversor {
    <T> T processDataConversor(String json, Class<T> classe);
}
