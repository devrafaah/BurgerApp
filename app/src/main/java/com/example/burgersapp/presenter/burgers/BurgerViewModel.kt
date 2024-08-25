package com.example.burgersapp.presenter.burgers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.burgersapp.data.model.ErrorResponse
import com.example.burgersapp.domain.usecase.GetBurgersByNameUseCase
import com.example.burgersapp.domain.usecase.GetBurgersUseCase
import com.example.burgersapp.util.StateView
import com.example.burgersapp.util.getErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class BurgerViewModel @Inject constructor(
    private val getBurgersUseCase: GetBurgersUseCase,
    private val getBurgersByNameUseCase: GetBurgersByNameUseCase
) : ViewModel() {

    fun getBurgers() = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())
            val burgers = getBurgersUseCase.invoke()

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

    fun getBurgersByName(name:String) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())

            val burgers = getBurgersByNameUseCase.invoke(name)

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