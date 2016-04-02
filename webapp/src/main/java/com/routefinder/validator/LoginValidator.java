package com.routefinder.validator;

import com.routefinder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;

/**
 * Created by karpukdm on 02.04.16.
 */
@FacesValidator("login")
@Component
public class LoginValidator implements Validator{

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        if(o.toString().length() < 4){
            throw new ValidatorException(new FacesMessage("Very small length"));
        }
        if(Character.isDigit(o.toString().toCharArray()[0])){
            throw new ValidatorException(new FacesMessage("Login is not valid"));
        }

    }
}
