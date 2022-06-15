package com.example.gallery1.model

import java.io.Serializable

data class AllPhotos(
    var total: Int,
    var total_pages: Int,
    var results: List<ResultPhoto>
) : Serializable