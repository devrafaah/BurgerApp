package com.example.burgersapp.presenter.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.burgersapp.data.model.ErrorResponse
import com.example.burgersapp.domain.usecase.GetBurgersByIdUseCase
import com.example.burgersapp.util.StateView
import com.example.burgersapp.util.getErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getBurgersByIdUseCase: GetBurgersByIdUseCase
) : ViewModel() {

    fun getBurgersById(burgerId : Int) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())

            val burgers = getBurgersByIdUseCase.invoke(burgerId)

            emit(StateView.Success(burgers))
        }catch (ex: HttpException) {
            ex.printStackTrace()
            val error = ex.getErrorResponse<ErrorResponse>()
            emit(StateView.Error(message = error?.message))
        } catch (ex: Exception) {
            ex.printStackTrace()
            emit(StateView.Error(message = ex.message))
        }
    }
}