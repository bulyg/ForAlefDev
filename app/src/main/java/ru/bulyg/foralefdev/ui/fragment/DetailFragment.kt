package ru.bulyg.foralefdev.ui.fragment

import kotlinx.android.synthetic.main.fragment_detail.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.bulyg.foralefdev.R
import ru.bulyg.foralefdev.mvp.presenter.DetailPresenter
import ru.bulyg.foralefdev.mvp.view.DetailView
import ru.bulyg.foralefdev.ui.App
import ru.bulyg.foralefdev.util.loadPictures

class DetailFragment : MvpAppCompatFragment(R.layout.fragment_detail), DetailView {
    companion object {
        fun newInstance() = DetailFragment()
    }

    @InjectPresenter
    lateinit var presenter: DetailPresenter

    @ProvidePresenter
    fun providePresenter() = DetailPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    override fun init(url: String) {
        loadPictures(url, iv_detail)
    }
}