package com.paulovap.benchmark;

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Asteroids(val asteroids: Array<Asteroid>)

@JsonClass(generateAdapter = true)
class Asteroid(val name: String,
                    val id: Int,
                    val nametype: String,
                    val recclass: String,
                    val mass: Double?,
                    val fall: String,
                    val year: String?,
                    val reclat: Double?,
                    val reclong: Double?,
                    val geolocation: GeoLocation?
                    )
@JsonClass(generateAdapter = true)
class GeoLocation(val type: String, val coordinates: DoubleArray)