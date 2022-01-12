package com.panvova.rickmorty.presentation.features.characterDetails

import android.os.Bundle
import android.view.View
import com.panvova.rickmorty.databinding.CharacterDetailsControllerBinding
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.presentation.base.BaseController
import com.panvova.rickmorty.presentation.features.characterDetails.epoxy.CharacterDetailsEpoxyController
import com.panvova.rickmorty.utils.CHARACTER
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class CharacterDetailsController(private val bundle: Bundle) :
    BaseController<CharacterDetailsControllerBinding>(CharacterDetailsControllerBinding::inflate) {

    private val characterEpoxyController = CharacterDetailsEpoxyController()

    override fun onAttach(view: View) {
        super.onAttach(view)
        setupRecyclerView()
        initData()
    }

    private fun setupRecyclerView() {
        binding.characterRV.setControllerAndBuildModels(characterEpoxyController)
    }


    private fun initData() {
        val character =
            Json.decodeFromString<Character>(bundle.getSerializable(CHARACTER) as String)
        characterEpoxyController.character = character
    }
}