package ru.bulyg.foralefdev.mvp.model.repository

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.bulyg.foralefdev.mvp.model.api.ApiService

class ApiRepository(val apiService: ApiService) {
    fun getPictures(): Single<List<String>> = apiService.getPictures().subscribeOn(Schedulers.io())
}