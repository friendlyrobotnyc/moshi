package com.squareup.moshi.sample

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Complaint (
    val id: String,
    val description: String,
    val createdAt: Long,
    val owner: Owner
)
@JsonClass(generateAdapter = true)
data class Owner (
    val id: String,
    val displayName: String,
    val flags: List<String>?
)