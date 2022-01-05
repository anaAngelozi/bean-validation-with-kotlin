package com.acrossatto.preference.domain.dto

import com.acrossatto.preference.domain.User


class PreferenceResponse(
    val key: String?,
    val userId: String?,
    val preferences: MutableSet<String>?
)
{
    constructor(user: User) : this(user.key, user.userId, user.preferences)

}