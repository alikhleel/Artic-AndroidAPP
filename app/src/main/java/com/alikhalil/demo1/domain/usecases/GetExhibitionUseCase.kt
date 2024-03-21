package com.alikhalil.demo1.domain.usecases

import com.alikhalil.demo1.data.repo.ExhibitionRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetExhibitionUseCase @Inject constructor(private val exhibitionRepository: ExhibitionRepository) {
    suspend operator fun invoke() = exhibitionRepository.getExhibition()
}