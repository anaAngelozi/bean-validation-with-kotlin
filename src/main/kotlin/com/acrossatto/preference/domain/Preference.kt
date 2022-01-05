package com.acrossatto.preference.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "preference")
class Preference(
    val key: String,
    val preferences: MutableSet<PreferenceItem>
) {
    @Id
    var id: String? = null
}

class PreferenceItem(
    val name: String
)