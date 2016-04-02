package com.routefinder.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by karpukdm on 02.04.16.
 */
@FacesValidator("button")
public class AllFieldsValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String prefix = facesContext.getExternalContext().getRequestParameterMap().values().iterator().next();
        String password = facesContext.getExternalContext().getRequestParameterMap().get(prefix.concat(":password"));
        String login = facesContext.getExternalContext().getRequestParameterMap().get(prefix.concat(":login"));
        String repeatedPassword = facesContext.getExternalContext().getRequestParameterMap().get(prefix.concat(":repeatedPassword"));
        if(password.equals("")){
            throw new ValidatorException(new FacesMessage("Fill in the password field"));
        }
        if(repeatedPassword.equals("")){
            throw new ValidatorException(new FacesMessage("Fill in the password field of repetition"));
        }
        if(login.equals("")){
            throw new ValidatorException(new FacesMessage("Fill in the login field"));
        }

    }
}
