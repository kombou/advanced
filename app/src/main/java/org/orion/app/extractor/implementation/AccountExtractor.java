package org.orion.app.extractor.implementation;

import org.orion.app.entity.Account;
import org.orion.app.extractor.contract.IExtractor;
import org.orion.app.model.RegistrationModel;

import java.util.Map;

public class AccountExtractor implements IExtractor<RegistrationModel> {
    @Override
    public RegistrationModel getModel(Map<String, String[]> parameters) {

        RegistrationModel model = new RegistrationModel();

        model.setName(parameters.get("nom")[0]);
        model.setSurname(parameters.get("prenom")[0]);
        model.setEmail(parameters.get("email")[0]);
        model.setPassword(parameters.get("password")[0]);
        model.setpasswordMatcher(parameters.get("passwordMatcher")[0]);

        return  model;
    }
}
