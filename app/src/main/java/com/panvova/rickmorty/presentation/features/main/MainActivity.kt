package com.panvova.rickmorty.presentation.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor.attachRouter
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.panvova.rickmorty.App
import com.panvova.rickmorty.databinding.ActivityMainBinding
import com.panvova.rickmorty.presentation.features.characters.CharactersController
import com.panvova.rickmorty.presentation.features.episodes.EpisodeController
import com.panvova.rickmorty.presentation.features.locations.LocationController
import com.panvova.rickmorty.presentation.features.menu.MenuController
import com.panvova.rickmorty.presentation.navigation.MenuNavigation


class MainActivity : AppCompatActivity(), MenuNavigation {

    private lateinit var router: Router
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        attachRouter(savedInstanceState)
    }

    private fun attachRouter(savedInstanceState: Bundle?) {
        router = attachRouter(this, binding.controllerContainer, savedInstanceState).apply {
            setRoot(RouterTransaction.with(MenuController()))
        }
    }

    override fun onBackPressed() {
        if (router.handleBack()) return
        super.onBackPressed()
    }

    override fun navigateToCharacters() {
        router.pushController(RouterTransaction.with(CharactersController()))
    }

    override fun navigateToLocations() {
        router.pushController(RouterTransaction.with(LocationController()))
    }

    override fun navigateToEpisodes() {
        router.pushController(RouterTransaction.with(EpisodeController()))
    }
}