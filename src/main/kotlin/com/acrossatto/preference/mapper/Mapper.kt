package com.acrossatto.preference.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
