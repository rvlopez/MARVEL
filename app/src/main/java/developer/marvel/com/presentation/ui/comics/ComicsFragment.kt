package developer.marvel.com.presentation.ui.comics

import android.os.Bundle
import android.view.View
import developer.marvel.com.R
import developer.marvel.com.presentation.extensions.observe
import developer.marvel.com.presentation.extensions.viewModel
import developer.marvel.com.presentation.ui.base.BaseFragment
import developer.marvel.com.presentation.ui.entity.ComicsMapper

class ComicsFragment : BaseFragment() {

    companion object {
        fun getFragment(): BaseFragment = ComicsFragment()
    }

    override var fragmentLayout: Int = R.layout.fragment_comics

    private lateinit var comicsViewModel: ComicsViewModel

    private val comicsAdapter: ComicsAdapter by lazy {
        ComicsAdapter {
            //TODO: Implement onClick
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpVieWModel()
    }

    private fun setUpVieWModel() {
        comicsViewModel = viewModel(viewModelFactory.get()) {

            observe(ldLoading) {

            }

            observe(ldComics) { comicData ->
                val comicList = comicData.comics
                comicsAdapter.addItemsToList(comicList.map { comic -> ComicsMapper().mapToUI(comic) })
            }

        }
    }

}