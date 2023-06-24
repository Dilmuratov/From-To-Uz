package com.example.fromtouzdemo.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fromtouzdemo.data.local.Body
import com.example.fromtouzdemo.domain.historyusecases.addbodyusecase.AddBodyUseCase
import com.example.fromtouzdemo.domain.historyusecases.deletebodyusecase.DeleteBodyUseCase
import com.example.fromtouzdemo.domain.historyusecases.getallbodiesusecase.GetAllBodiesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoryViewModel(
    private val getAllBodiesUseCase: GetAllBodiesUseCase,
    private val addBodyUseCase: AddBodyUseCase,
    private val deleteBodyUseCase: DeleteBodyUseCase
) : ViewModel() {

    private val _bodyLiveData = MutableLiveData<List<Body>>()
    val bodyLiveData: LiveData<List<Body>>
        get() = _bodyLiveData

    suspend fun getAllBodies(): Flow<List<Body>> = flow {
        getAllBodiesUseCase.execute().collect {
            emit(it)
        }
    }

    suspend fun addBody(body: Body) = addBodyUseCase.execute(body)

    suspend fun deleteBody(body: Body) = deleteBodyUseCase.execute(body)
}