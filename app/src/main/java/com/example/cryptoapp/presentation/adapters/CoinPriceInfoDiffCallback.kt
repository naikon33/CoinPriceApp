package com.example.cryptoapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.domain.entity.CoinPriceInfo

class CoinPriceInfoDiffCallback:DiffUtil.ItemCallback<CoinPriceInfo>() {
    override fun areItemsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem.fromSymbol==newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem==newItem
    }
}