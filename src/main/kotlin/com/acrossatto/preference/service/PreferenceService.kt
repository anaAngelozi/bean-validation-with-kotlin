package com.acrossatto.preference.service

import com.acrossatto.preference.controller.PreferenceController
import com.acrossatto.preference.domain.Preference
import com.acrossatto.preference.domain.PreferenceItem
import com.acrossatto.preference.domain.dto.PreferenceRequest
import com.acrossatto.preference.domain.dto.PreferenceResponse
import com.acrossatto.preference.enum.Message
import com.acrossatto.preference.exception.KeyNotFoundException
import com.acrossatto.preference.exception.UserNotFoundException
import com.acrossatto.preference.repository.PreferenceRepository
import com.acrossatto.preference.repository.UserRepository
import com.acrossatto.preference.validation.KeyValid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated
import java.util.stream.Collectors
import javax.validation.Valid

@Validated
@Service("PreferenceService")
class PreferenceService (private val preferenceRepository: PreferenceRepository,
                         private val userRepository: UserRepository) {

   val logger: Logger = LoggerFactory.getLogger(PreferenceController::class.java)

    fun getPreferencesByKey(@Valid @KeyValid key: String): MutableSet<String> {

        logger.info("getPreferencesByKey = $key")

        val preference : Preference = preferenceRepository.findByKey(key).orElseThrow { KeyNotFoundException (Message.KEY_NOT_FOUND) }

        return preference.preferences.stream().map(PreferenceItem::name).collect(Collectors.toSet())

    }

    fun setPreferences(@Valid preferenceRequest: PreferenceRequest) : PreferenceResponse {

        logger.info("setPreferences by key = $preferenceRequest.key and userId= $preferenceRequest.userId")

        if (preferenceRequest.preferences.isNullOrEmpty().not()){

            val user = userRepository.findByUserIdAndKey(preferenceRequest.userId, preferenceRequest.key).orElseThrow { UserNotFoundException (Message.USER_NOT_FOUND) }
            user.preferences = preferenceRequest.preferences!!

            userRepository.save(user)
        }

        return PreferenceResponse(preferenceRequest.key, preferenceRequest.userId, preferenceRequest.preferences)
    }

}