package com.atdevsoft.apps.toword.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atdevsoft.apps.toword.common.ui.BaseFragment
import com.atdevsoft.apps.toword.features.home.databinding.FrHomeBinding

class HomeFragment : BaseFragment<FrHomeBinding, HomeViewModel>() {

    /*
    private val navGraphIds = listOf(
        R.navigation.navigation_characters_list_graph,
        R.navigation.navigation_characters_favorites_graph
    )
    */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onInitDependencyInjection() {

    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): FrHomeBinding {
        return FrHomeBinding.inflate(inflater, container, false)
    }

    private fun setupBottomNavigationBar() {
        /*
        val navController = viewBinding?.bottomNavigation?.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.nav_host_container,
            intent = requireActivity().intent
        )

        navController.observe(viewLifecycleOwner, Observer {
            viewModel.navigationControllerChanged(it)
            setupActionBarWithNavController(requireCompatActivity(), it)
        })

         */
    }
}
