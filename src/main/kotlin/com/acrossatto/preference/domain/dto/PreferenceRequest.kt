package com.acrossatto.preference.domain.dto

import com.acrossatto.preference.domain.Preference
import com.acrossatto.preference.domain.PreferenceItem
import com.acrossatto.preference.enum.Message
import com.acrossatto.preference.validation.KeyValid
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.validation.annotation.Validated
import java.io.Serializable
import java.lang.reflect.Constructor
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class PreferenceRequest(

    @field:KeyValid
    var key: String?,

    @field:NotNull(message = "UserId can not be null")
    @field:NotBlank
    var userId: String?,

    @field:Size(max = 4, message= "Invalid max quantity")
    var preferences: MutableSet<String>?
    
) : Serializable
