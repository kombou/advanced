package org.orion.app.validator.implement;

import org.orion.app.model.RegistrationModel;

public class RegistrationValidator extends ModelValidator<RegistrationModel> {

    @Override
    public void validate(RegistrationModel model) {
        if(model.getName() == null){
            addErrors("nom","Le nom est requis");
        }
    }
}
