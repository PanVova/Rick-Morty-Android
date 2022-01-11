package com.panvova.rickmorty.presentation.menu

import android.view.View
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.panvova.rickmorty.databinding.MenuControllerBinding
import com.panvova.rickmorty.presentation.base.BaseController
import com.panvova.rickmorty.presentation.characters.CharactersController
import com.panvova.rickmorty.presentation.episodes.EpisodeController
import com.panvova.rickmorty.presentation.locations.LocationController

class MenuController : BaseController<MenuControllerBinding>(MenuControllerBinding::inflate) {

    override fun onAttach(view: View) {
        super.onAttach(view)

        with(binding) {
            characters.setOnClickListener {
                moveToController(CharactersController())
            }

            episodes.setOnClickListener {
                moveToController(EpisodeController())
            }

            locations.setOnClickListener {
                moveToController(LocationController())
            }
        }
    }

    private fun moveToController(controller: Controller) {
        router.pushController(RouterTransaction.with(controller))
    }
}