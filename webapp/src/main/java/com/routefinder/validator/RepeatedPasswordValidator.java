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
@FacesValidator("repeatedPassword")
@Component
public class RepeatedPasswordValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String prefix = facesContext.getExternalContext().getRequestParameterMap().values().iterator().next();
        String password = facesContext.getExternalContext().getRequestParameterMap().get(prefix.concat(":password"));
        if(!o.toString().equals(password)){
            throw new ValidatorException(new FacesMessage("Password is not equals"));
        }
    }
}
