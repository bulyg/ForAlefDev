package ru.bulyg.foralefdev.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiService {
    @GET("task-m-001/list.php")
    fun getPictures(): Single<List<String>>
}