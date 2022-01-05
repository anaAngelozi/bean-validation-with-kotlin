package com.acrossatto.preference.exception

import com.acrossatto.preference.enum.Message

class InvalidKeyFormatException(message: Message) : RuntimeException(message.name){

}