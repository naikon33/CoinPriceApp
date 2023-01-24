package com.example.cryptoapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.entity.CoinPriceInfo

interface CoinRepository {

    fun getCoinListInfo():LiveData<List<CoinPriceInfo>>

    fun getCoinInfo(fromSymbol:String):LiveData<CoinPriceInfo>

    fun loadData()
}