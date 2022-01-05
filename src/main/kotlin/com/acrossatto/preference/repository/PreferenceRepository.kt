package com.acrossatto.preference.repository

import com.acrossatto.preference.domain.Preference
import com.acrossatto.preference.domain.PreferenceItem
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PreferenceRepository: MongoRepository<Preference, String>{

    fun findAllPreferencesByKey(key: String): Set<PreferenceItem>

    fun findByKey(key: String): Optional<Preference>

}