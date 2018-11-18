package org.orion.app.validator.implement;

import org.orion.app.validator.contract.IModelValidator;

import java.util.HashMap;
import java.util.Map;

public abstract class ModelValidator<T> implements IModelValidator<T> {

    private Map<String, String> errors = new HashMap<>();

    @Override
    public Map<String, String> getErrors() {
        return  errors;
    }

    public abstract void validate(T model);

    @Override
    public boolean isValid() {
        return errors.isEmpty();
    }

    @Override
    public void addErrors(String key, String message) {
        errors.put(key, message);
    }
}
