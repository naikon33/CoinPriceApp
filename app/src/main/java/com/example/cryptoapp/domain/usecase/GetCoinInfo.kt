package com.example.cryptoapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.entity.CoinPriceInfo
import com.example.cryptoapp.domain.repository.CoinRepository

class GetCoinInfo(private val repository: CoinRepository) {

    operator fun invoke(fromSymbol:String):LiveData<CoinPriceInfo>{
        return repository.getCoinInfo(fromSymbol)
    }
}