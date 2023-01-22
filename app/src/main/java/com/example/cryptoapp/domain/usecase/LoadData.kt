package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.repository.CoinRepository

class LoadData(private val repository: CoinRepository) {

    suspend operator fun invoke()=repository.loadData()
}