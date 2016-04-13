package com.routefinder.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by offsp on 13.04.2016.
 */
@FacesValidator("points")
public class PointsValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if(o.toString().isEmpty()){
            throw new ValidatorException(new FacesMessage("Very small length"));
        }
    }
}
