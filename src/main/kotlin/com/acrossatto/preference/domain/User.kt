package com.acrossatto.preference.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(

    val userId: String,
    val key: String,
    var preferences: MutableSet<String>
){
    @Id
    var id: String? = null
}