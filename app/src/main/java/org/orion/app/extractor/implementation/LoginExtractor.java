package org.orion.app.extractor.implementation;

import org.orion.app.extractor.contract.IExtractor;
import org.orion.app.model.LoginModel;

import java.util.Map;

public class LoginExtractor implements IExtractor<LoginModel> {
    @Override
    public LoginModel getModel(Map<String, String[]> parameters) {

        LoginModel model = new LoginModel();

        model.setUser(parameters.get("user")[0]);
        model.setPassword(parameters.get("password")[0]);

        return model;
    }
}
