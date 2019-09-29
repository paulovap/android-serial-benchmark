package com.paulovap.benchmark.asteroids

import com.paulovap.asteroids.proto.IAsteroid
import com.paulovap.asteroids.proto.IAsteroids
import com.paulovap.asteroids.proto.IGeolocation

class ProtoAdapter {

    companion object {
        val EMPTY_COORD = doubleArrayOf(0.0, 0.0)
    }

    fun serialize(asteroids: IAsteroids): ByteArray {
        return asteroids.toByteArray()
    }

    fun serializeFromAsteroids(asteroids: Asteroids): ByteArray {

        return IAsteroids.newBuilder()
            .addAllAsteroids(MutableList(asteroids.asteroids.size) {
                val asteroid = asteroids.asteroids[it]
                IAsteroid.newBuilder()
                    .setName(asteroid.name)
                    .setFall(asteroid.fall)
                    .setId(asteroid.id)
                    .setMass(asteroid.mass!!)
                    .setNametype(asteroid.nametype)
                    .setRecclass(asteroid.recclass)
                    .setReclat(asteroid.reclat!!)
                    .setReclong(asteroid.reclong!!)
                    .setYear(asteroid.year)
                    .setGeolocation(IGeolocation.newBuilder()
                        .setType(asteroid.geolocation!!.type)
                        .addCoordinates(asteroid.geolocation.coordinates[0])
                        .addCoordinates(asteroid.geolocation.coordinates[0])
                        .build())
                    .build()})
            .build().toByteArray()
    }

    fun deserialize(data: ByteArray): IAsteroids {
        val builder = IAsteroids.newBuilder()
        return builder.mergeFrom(data).build()
    }

    fun deserializeToAsteroid(data: ByteArray): Asteroids {
        val builder = IAsteroids.newBuilder()
        //return builder.mergeFrom(data).build()
        val iAsteroids = builder.mergeFrom(data).build()
        val asteroids = Array(iAsteroids.asteroidsCount) {
            val iasteroid = iAsteroids.getAsteroids(it)!!
            val coordinates = if (iasteroid.hasGeolocation() && iasteroid.geolocation.coordinatesCount == 2) {
                doubleArrayOf(iasteroid.geolocation.getCoordinates(0),
                    iasteroid.geolocation.getCoordinates(1))
            } else {
                EMPTY_COORD
            }
            Asteroid(
                name = iasteroid.name!!,
                fall = iasteroid.fall!!,
                id = iasteroid.id,
                mass = iasteroid.mass,
                nametype = iasteroid.nametype!!,
                recclass = iasteroid.recclass!!,
                reclat = iasteroid.reclat,
                reclong = iasteroid.reclat,
                year = iasteroid.year ?: "",
                geolocation = GeoLocation(
                    type = iasteroid.geolocation?.type?: "",
                    coordinates = coordinates
                )
            )
        }

        return Asteroids(asteroids = asteroids)
    }
}
