package com.acrossatto.preference.exception

import com.acrossatto.preference.enum.Message

class KeyNotFoundException(message: Message) : RuntimeException(message.name){

}