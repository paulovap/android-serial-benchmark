package com.paulovap.benchmark;

class Asteroids(val asteroids: Array<Asteroid>)

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

class GeoLocation(val type: String, val coordinates: DoubleArray)