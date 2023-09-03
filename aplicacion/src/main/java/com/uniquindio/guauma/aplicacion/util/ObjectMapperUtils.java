package com.uniquindio.guauma.aplicacion.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapperUtils {
    private static final ModelMapper modelMapper = new ModelMapper();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private ObjectMapperUtils() {
    }

    public static <D, T> D map(T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    public static <D, T> List<D> mapAll(Collection<T> entityList, Class<D> outCLass) {
        return (List)entityList.stream().map((entity) -> {
            return map(entity, outCLass);
        }).collect(Collectors.toList());
    }

    public static <S, D> D map(S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }

    public static <T> T deserialize(byte[] bytes, Class<T> klass) throws IOException {
        return OBJECT_MAPPER.readValue(bytes, klass);
    }

    public static <T> T deserialize(String str, Class<T> klass) throws IOException {
        return OBJECT_MAPPER.readValue(str, klass);
    }

    public static <T> byte[] serialize(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsBytes(obj);
    }

    public static <T> String serializeToString(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    static {
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STRICT);
    }
}