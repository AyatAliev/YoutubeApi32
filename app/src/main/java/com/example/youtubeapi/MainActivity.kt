package com.example.youtubeapi

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.core.BaseActivity
import com.example.youtubeapi.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewModel: MainViewModel

    override fun setUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun setupLiveData() {
        viewModel.getPlayList().observe(this) { response ->

            Log.d("ololo",response.items.size.toString())
            Toast.makeText(this,response.items.size.toString(),Toast.LENGTH_SHORT).show()
        }
    }

    override fun initClickListener() {

    }

    override fun checkInternet() {

    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    /*Дз.
 1. Создать свой ApiKey и ознакомиться с документацией
 2. Добавить в класс playlist поле "items", отрисовать первых 2 экрана из фигмы (Проверка на интернет, и список всех PlayList)
 3. Cделать переход на новую активити и передаете туда id и её отображаете тостом

Также прочитайте про корутины желательно

Доп: в PlayListActivity попробуйте реализовать пагинацию с помощью ViewType с RecyclerView
*/
}