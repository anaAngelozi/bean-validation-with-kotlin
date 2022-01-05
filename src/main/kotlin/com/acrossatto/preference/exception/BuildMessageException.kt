package com.acrossatto.preference.exception

import com.acrossatto.preference.enum.Message
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder

class BuildMessageException (message: String) : RuntimeException(message){

}