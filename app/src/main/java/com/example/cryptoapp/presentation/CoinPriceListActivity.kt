package com.example.cryptoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.R
import com.example.cryptoapp.presentation.adapters.CoinInfoAdapter
import com.example.cryptoapp.data.network.model.CoinInfoDto
import com.example.cryptoapp.databinding.ActivityCoinPrceListBinding
import com.example.cryptoapp.domain.entity.CoinPriceInfo

class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCoinPrceListBinding

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCoinPrceListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {

            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                if (binding.fragmentContainer==null){
                    launchDetailActivity(coinPriceInfo.fromSymbol)
                }
                else{
                    launchDetailFragment(coinPriceInfo.fromSymbol)
                }
            }
        }
        binding.rvCoinPriceList.adapter = adapter
        viewModel=ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.invoke().observe(this){
            adapter.submitList(it)
        }

    }
    private fun launchDetailFragment(fSym:String){
        supportFragmentManager.popBackStack()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,CoinDetailFragment.newInstance(fSym))
            .addToBackStack(null)
            .commit()
    }

    private fun launchDetailActivity(fSym: String){
        val intent = CoinDetailActivity.newIntent(
            this@CoinPriceListActivity,
            fSym
        )
        startActivity(intent)
    }
}
