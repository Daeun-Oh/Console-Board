package org.koreait.board.validators;

import org.koreait.board.controllers.CreateForm;
import org.koreait.global.validators.IdValidator;
import org.koreait.global.validators.Validator;

public class BoardIdValidator implements Validator<CreateForm>, IdValidator {
    @Override
    public void check(CreateForm form) {
        //stringToId(form.getWriterId())
    }
}
