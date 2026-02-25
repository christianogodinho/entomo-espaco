package com.entomo.demo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class Util {

    private static ModelMapper mapper;

    public static ModelMapper getMapper() {
        if (mapper == null) {
            mapper = getNewMapper();
        }

        return mapper;
    }

    public static ModelMapper getNewMapper() {
        var mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return mapper;
    }
}
