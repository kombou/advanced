package org.orion.app.validator.contract;

import java.util.Map;

public interface IModelValidator<T> {
    Map<String , String> getErrors();

    void validate(T model);

    boolean isValid();

    void addErrors(String key, String message);
}
