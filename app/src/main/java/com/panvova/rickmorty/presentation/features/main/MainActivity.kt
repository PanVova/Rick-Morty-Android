package com.panvova.rickmorty.presentation.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor.attachRouter
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.panvova.rickmorty.App
import com.panvova.rickmorty.databinding.ActivityMainBinding
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.presentation.features.characterDetails.CharacterDetailsController
import com.panvova.rickmorty.presentation.features.characters.CharactersController
import com.panvova.rickmorty.presentation.features.episodes.EpisodeController
import com.panvova.rickmorty.presentation.features.locations.LocationController
import com.panvova.rickmorty.presentation.features.menu.MenuController
import com.panvova.rickmorty.presentation.navigation.Navigation
import com.panvova.rickmorty.utils.CHARACTER
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class MainActivity : AppCompatActivity(), Navigation {

    private lateinit var router: Router
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var controller: Controller = MenuController()
        if (intent.action == "android.intent.action.LOCATION") {
            controller = LocationController()
        }

        setContentView(binding.root)
        attachRouter(savedInstanceState, controller)
    }

    private fun attachRouter(savedInstanceState: Bundle?, controller: Controller) {
        router = attachRouter(this, binding.controllerContainer, savedInstanceState).apply {
            setRoot(RouterTransaction.with(controller))
        }
    }

    override fun onBackPressed() {
        if (router.handleBack()) return
        super.onBackPressed()
    }

    override fun navigateToCharacterDetails(character: Character) {
        val bundle = Bundle().apply {
            putSerializable(CHARACTER, Json.encodeToString(character))
        }
        router.pushController(
            navigateToController(CharacterDetailsController(bundle))
        )
    }

    override fun navigateToCharacters() {
        router.pushController(
            navigateToController(CharactersController())
        )
    }

    override fun navigateToLocations() {
        router.pushController(
            navigateToController(LocationController())
        )
    }

    override fun navigateToEpisodes() {
        router.pushController(
            navigateToController(EpisodeController())
        )
    }

    private fun navigateToController(controller: Controller): RouterTransaction {
        return RouterTransaction.with(controller)
            .pushChangeHandler(FadeChangeHandler())
            .popChangeHandler(FadeChangeHandler())
    }
}