package com.panvova.rickmorty.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.panvova.rickmorty.databinding.MenuControllerBinding

class MenuController : Controller() {
    private var _binding: MenuControllerBinding? = null
    private val binding: MenuControllerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        _binding = MenuControllerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView(view: View) {
        _binding = null
        super.onDestroyView(view)
    }
}