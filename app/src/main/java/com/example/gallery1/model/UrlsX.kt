package com.example.gallery1.model

import java.io.Serializable

data class UrlsX(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val small_s3: String,
    val thumb: String
): Serializable
