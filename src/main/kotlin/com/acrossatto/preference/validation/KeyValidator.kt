package com.acrossatto.preference.validation

import com.acrossatto.preference.enum.Message
import org.springframework.stereotype.Component
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Component
class KeyValidator : ConstraintValidator<KeyValid, String>{

    override fun isValid(key: String?, context: ConstraintValidatorContext): Boolean {

        val regexNumbersAndString: Regex = Regex("^[a-zA-Z0-9]{40}\$")

        if (key.isNullOrBlank() || regexNumbersAndString.matches(key).not()) {
            context.buildConstraintViolationWithTemplate(Message.KEY_INVALID_FORMAT.name).addConstraintViolation()
            return false
        }
        return true
    }

}