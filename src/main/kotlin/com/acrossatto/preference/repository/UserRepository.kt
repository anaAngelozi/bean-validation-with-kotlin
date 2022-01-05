package com.acrossatto.preference.repository

import com.acrossatto.preference.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: MongoRepository<User, String>{

    fun findByUserIdAndKey(key: String?, userId: String?): Optional<User>

}