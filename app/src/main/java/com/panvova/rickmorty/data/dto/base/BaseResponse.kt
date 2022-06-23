package com.panvova.rickmorty.data.dto.base

data class BaseResponse<T>(
    val info: Info,
    val results: List<T>
)