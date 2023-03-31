package com.gbs.domain.usecase

import com.gbs.data.repository.GAuthRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(private val gAuthRepository: GAuthRepository) {
    operator fun invoke() = gAuthRepository.getToken()
}