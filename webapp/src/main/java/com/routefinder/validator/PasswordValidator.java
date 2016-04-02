package com.routefinder.validator;

import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by karpukdm on 02.04.16.
 */
@FacesValidator("password")
@Component
public class PasswordValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        if(o.toString().length() < 4){
            throw new ValidatorException(new FacesMessage("Very small length"));
        }

    }
}
