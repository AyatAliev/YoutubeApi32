package com.example.youtubeapi.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    protected lateinit var viewBinding: VB
    protected abstract fun inflateViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateViewBinding()
        setContentView(viewBinding.root)

        checkInternet()
        setUI()
        setupLiveData()
        initClickListener()
    }

    abstract fun setUI() // инициализация UI

    abstract fun setupLiveData() // инициализация live data

    abstract fun initClickListener() // внутри этого метода обрабатываем все клики

    abstract fun checkInternet() // внутри этого метода проверяем интернет соединение

}