package com.example.cryptoapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.cryptoapp.R
import com.example.cryptoapp.data.network.ApiFactory.BASE_IMAGE_URL
import com.example.cryptoapp.data.network.model.CoinInfoDto
import com.example.cryptoapp.databinding.ItemCoinInfoBinding
import com.example.cryptoapp.domain.entity.CoinPriceInfo
import com.example.cryptoapp.utils.convertTimestampToTime
import com.squareup.picasso.Picasso

class CoinInfoAdapter(private val context: Context)
    :ListAdapter<CoinPriceInfo,CoinInfoAdapter.CoinInfoViewHolder>(CoinPriceInfoDiffCallback()) {


    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding =ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinInfoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        val binding=holder.binding
        with(holder) {
            with(coin) {
                val symbolsTemplate = context.resources.getString(R.string.symbols_template)
                val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
                binding.tvSymbols.text = String.format(symbolsTemplate, fromSymbol, toSymbol)
                binding.tvPrice.text = price
                binding.tvLastUpdate.text = String.format(
                    lastUpdateTemplate, convertTimestampToTime(lastUpdate))
                Picasso.get().load(BASE_IMAGE_URL+imageUrl).into(binding.ivLogoCoin)
                itemView.setOnClickListener {
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    class CoinInfoViewHolder(
        val binding:ItemCoinInfoBinding
    ) : RecyclerView.ViewHolder(binding.root)

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}