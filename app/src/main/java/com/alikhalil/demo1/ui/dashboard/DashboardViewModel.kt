package com.alikhalil.demo1.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alikhalil.demo1.common.UIState
import com.alikhalil.demo1.data.model.ExhibitionResponse
import com.alikhalil.demo1.domain.usecases.GetExhibitionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val getExhibitionUseCase: GetExhibitionUseCase
) : ViewModel() {

    var artWork = MutableLiveData<UIState<ExhibitionResponse>>(UIState.Loading())

    init {
        getArtWork()
    }

    private fun getArtWork() {
        viewModelScope.launch {
            when (val response = getExhibitionUseCase.invoke()) {
                is UIState.Success -> artWork.postValue(UIState.Success(response.responseData))
                is UIState.Error -> artWork.postValue(UIState.Error(response.message.orEmpty()))
                is UIState.Empty -> artWork.postValue(
                    UIState.Empty(
                        title = response.title
                    )
                )

                is UIState.Loading -> artWork.postValue(UIState.Loading())
            }
        }
    }

}