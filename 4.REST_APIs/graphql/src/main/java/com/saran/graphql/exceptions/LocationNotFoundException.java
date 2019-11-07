package com.saran.graphql.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extension = new HashMap<>();

    public LocationNotFoundException(String message, Long invalidLocationId){
        super(message);
        extension.put("invalidLocationId", invalidLocationId);
    }
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extension;
    }
}
