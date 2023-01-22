package com.example.cryptoapp.domain.usecase

import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.entity.CoinPriceInfo
import com.example.cryptoapp.domain.repository.CoinRepository

class GetCoinListInfo(private val repository: CoinRepository) {

    operator fun invoke():LiveData<List<CoinPriceInfo>>{
        return repository.getCoinListInfo()
    }
}