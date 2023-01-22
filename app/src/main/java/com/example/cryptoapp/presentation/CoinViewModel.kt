package com.example.cryptoapp.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.network.model.CoinInfoDto
import com.example.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.usecase.GetCoinInfo
import com.example.cryptoapp.domain.usecase.GetCoinListInfo
import com.example.cryptoapp.domain.usecase.LoadData
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository=CoinRepositoryImpl(application)
    private val getCoinInfoUseCase=GetCoinInfo(repository)
    private val getCoinListInfoUseCase= GetCoinListInfo(repository)
    private val loadDataUseCase=LoadData(repository)

    val priceList = getCoinListInfoUseCase

    fun getDetailInfo(fSym: String)=getCoinInfoUseCase(fSym)

    init {
        viewModelScope.launch {
            loadDataUseCase
        }
    }

}