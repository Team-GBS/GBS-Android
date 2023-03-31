package com.gbs.domain.usecase

import com.gbs.data.repository.GAuthRepository
import javax.inject.Inject

class SetTokenUseCase @Inject constructor(private val gAuthRepository: GAuthRepository) {
    suspend operator fun invoke(token: String) {
        gAuthRepository.setToken(token)
    }
}