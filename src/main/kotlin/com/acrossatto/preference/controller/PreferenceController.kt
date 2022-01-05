package com.acrossatto.preference.controller

import com.acrossatto.preference.domain.dto.PreferenceRequest
import com.acrossatto.preference.domain.dto.PreferenceResponse
import com.acrossatto.preference.service.PreferenceService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Size

@RestController
@RequestMapping("/preferences")
class PreferenceController (private val preferenceService: PreferenceService){

    val logger: Logger = LoggerFactory.getLogger(PreferenceController::class.java)

    @GetMapping
    fun getAllPreferencesByKey(@RequestHeader(name = "key") key: String): ResponseEntity<MutableSet<String>> {

        logger.info("getAllPreferencesByKey = $key")

        return ResponseEntity.ok(preferenceService.getPreferencesByKey(key))
    }

    @PatchMapping("/users/{userId}")
    fun setPreferences(@RequestHeader("key") key: String,
        @PathVariable("userId") userId: String,
        @RequestBody preferences: MutableSet<String>
    ): ResponseEntity<PreferenceResponse> {

        var preferenceRequest = PreferenceRequest(key, userId, preferences as MutableSet<String>)

        logger.info("setPreferences by key = $key, userId= $userId")

        return ResponseEntity.ok(preferenceService.setPreferences(preferenceRequest))
    }

    @PatchMapping("/test")
    fun test(@RequestHeader("key") key: String, @RequestBody @Valid preferenceRequest: PreferenceRequest): ResponseEntity<PreferenceResponse> {

        logger.info("test by key = $key")

        return ResponseEntity.ok(preferenceService.setPreferences(preferenceRequest))
    }

}