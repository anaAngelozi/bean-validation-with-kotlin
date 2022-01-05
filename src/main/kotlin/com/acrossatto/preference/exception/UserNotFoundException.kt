package com.acrossatto.preference.exception

import com.acrossatto.preference.enum.Message

class UserNotFoundException(message: Message) : RuntimeException(message.name){

}