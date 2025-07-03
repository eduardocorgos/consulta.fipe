package projeto.consulta.fipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class DataConversor implements IdataConversor{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T processDataConversor(String json, Class<T> classe) {
        try{
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public <T> List<T> processListDataConversor(String json, TypeReference<List<T>> typeRef) {
        try {
            return mapper.readValue(json, typeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
