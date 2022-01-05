package com.acrossatto.preference.validation

import java.lang.annotation.ElementType
import javax.validation.Constraint
import javax.validation.Payload
import java.lang.annotation.Target;
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [KeyValidator::class])
@Target(ElementType.PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class KeyValid(

    val message: String = "{SearchInvalidKey}",
    val groups: Array<KClass<out Any>> = [],
    val payload: Array<KClass<out Payload>> = []

)