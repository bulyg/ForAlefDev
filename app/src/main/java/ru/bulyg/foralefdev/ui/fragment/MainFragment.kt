package ru.bulyg.foralefdev.ui.fragment

import android.content.res.Configuration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.bulyg.foralefdev.R
import ru.bulyg.foralefdev.mvp.presenter.MainFragPresenter
import ru.bulyg.foralefdev.mvp.view.MainFragView
import ru.bulyg.foralefdev.ui.App
import ru.bulyg.foralefdev.ui.adapter.MainRVAdapter


class MainFragment : MvpAppCompatFragment(R.layout.fragment_main), MainFragView {
    companion object {
        fun newInstance() = MainFragment()
    }

    @InjectPresenter
    lateinit var presenter: MainFragPresenter

    @ProvidePresenter
    fun providePresenter() = MainFragPresenter().apply {
        App.instance.appComponent.inject(this)
    }

    private var adapter: MainRVAdapter? = null

    override fun init() {
        initRV()
        layout_refresh.setOnRefreshListener {
            presenter.load()
        }
    }

    fun initRV() {
        adapter = MainRVAdapter(presenter.listPresenter)
        rv_main.adapter = adapter
        val displayMetrics = this.resources.displayMetrics
        val dpHeight = displayMetrics.heightPixels / displayMetrics.density
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        // Проверка планшет это или телефон, исходил из того, что планшет с экраном 7 дюймов имеет минимальную ширину 600 dp
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (dpWidth <= 600) rv_main.layoutManager = GridLayoutManager(context, 2)
            else rv_main.layoutManager = GridLayoutManager(context, 3)
        } else {
            if (dpHeight <= 600) rv_main.layoutManager = GridLayoutManager(context, 2)
            else rv_main.layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun update() {
        adapter?.notifyDataSetChanged()
    }

    override fun setRefreshing(isRefreshing: Boolean) {
        layout_refresh.isRefreshing = isRefreshing
    }
}