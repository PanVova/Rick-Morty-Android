package com.panvova.rickmorty.presentation.features.menu

import android.view.View
import com.panvova.rickmorty.databinding.MenuControllerBinding
import com.panvova.rickmorty.presentation.base.BaseController
import com.panvova.rickmorty.presentation.navigation.MenuNavigator

class MenuController : BaseController<MenuControllerBinding>(MenuControllerBinding::inflate) {

    override fun onAttach(view: View) {
        super.onAttach(view)

        with(binding) {
            characters.setOnClickListener {
                (activity as MenuNavigator).navigateToCharacters()
            }

            episodes.setOnClickListener {
                (activity as MenuNavigator).navigateToEpisodes()
            }

            locations.setOnClickListener {
                (activity as MenuNavigator).navigateToLocations()
            }
        }
    }
}