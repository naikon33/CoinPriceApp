package com.example.cryptoapp.data.database.dbModel

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "full_price_list")
data class CoinInfoDB(
    @PrimaryKey
    val fromSymbol: String,
    val toSymbol: String?,
    val price: String?,
    val lastUpdate: Long?,
    val highDay: String?,
    val lowDay: String?,
    val lastMarket: String?,
    val imageUrl: String
)