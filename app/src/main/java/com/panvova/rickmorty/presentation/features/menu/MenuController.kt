package com.panvova.rickmorty.presentation.features.menu

import android.view.View
import com.panvova.rickmorty.databinding.MenuControllerBinding
import com.panvova.rickmorty.presentation.base.BaseController
import com.panvova.rickmorty.presentation.navigation.MenuNavigation

class MenuController : BaseController<MenuControllerBinding>(MenuControllerBinding::inflate) {

    override fun onAttach(view: View) {
        super.onAttach(view)

        with(binding) {
            characters.setOnClickListener {
                (activity as MenuNavigation).navigateToCharacters()
            }

            episodes.setOnClickListener {
                (activity as MenuNavigation).navigateToEpisodes()
            }

            locations.setOnClickListener {
                (activity as MenuNavigation).navigateToLocations()
            }
        }
    }
}