package br.com.acrossatto.poc.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message) {
}