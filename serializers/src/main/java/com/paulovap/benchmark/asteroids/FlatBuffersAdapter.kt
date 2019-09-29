package com.paulovap.benchmark.asteroids

import com.google.flatbuffers.FlatBufferBuilder
import com.paulovap.asteroids.flatbuffers.IAsteroid
import com.paulovap.asteroids.flatbuffers.IAsteroids
import com.paulovap.asteroids.flatbuffers.ICoordinates
import com.paulovap.asteroids.flatbuffers.IGeoLocation
import java.nio.ByteBuffer
import java.nio.ByteOrder

class FlatBufferAdapter {

    companion object {
        val EMPTY_COORD = doubleArrayOf(0.0, 0.0)
    }

    @ExperimentalUnsignedTypes
    fun deserialize(data: ByteArray): IAsteroids {
        val buffer = ByteBuffer.wrap(data)
        buffer.order(ByteOrder.LITTLE_ENDIAN)
        return IAsteroids.getRootAsIAsteroids(buffer)
    }

    @ExperimentalUnsignedTypes
    fun deserializeToAsteroid(data: ByteArray): Asteroids {

        val buffer = ByteBuffer.wrap(data)
        buffer.order(ByteOrder.LITTLE_ENDIAN)
        val iasteroids = IAsteroids.getRootAsIAsteroids(buffer)
        //return ImmutableAsteroids.getRootAsImmutableAsteroids(buffer)
        val asteroids = Array(iasteroids.asteroidsLength()) {
            val iasteroid = iasteroids.asteroids(it)!!
            val coordinates = if (iasteroid.geolocation() != null) {
                doubleArrayOf(
                    iasteroid.geolocation()?.coordinates()!!.lat(),
                    iasteroid.geolocation()?.coordinates()!!.lon()
                )
            } else {
                EMPTY_COORD
            }
            Asteroid(
                name = iasteroid.name()!!,
                fall = iasteroid.fall()!!,
                id = iasteroid.id(),
                mass = iasteroid.mass(),
                nametype = iasteroid.nametype()!!,
                recclass = iasteroid.recclass()!!,
                reclat = iasteroid.reclat(),
                reclong = iasteroid.reclat(),
                year = iasteroid.year() ?: "",
                geolocation = GeoLocation(
                    type = iasteroid.geolocation()?.type() ?: "",
                    coordinates = coordinates
                )
            )
        }

        return Asteroids(asteroids = asteroids)
    }

    @ExperimentalUnsignedTypes
    fun serializeFromAsteroid(asteroids: Asteroids): ByteArray {
        // 200kb should do it
        val b = FlatBufferBuilder(
            ByteBuffer.allocate(200 * 1024)
                .order(ByteOrder.LITTLE_ENDIAN)
        )

        //end iAsteroids
        b.finish(
            IAsteroids.createIAsteroids(b,
                IAsteroids.createAsteroidsVector(b,
                    IntArray(asteroids.asteroids.size) {
                        val asteroid = asteroids.asteroids[it]
                        val geolocation = asteroid.geolocation!!

                        //name
                        return@IntArray IAsteroid.createIAsteroid(b,
                                b.createString(asteroid.name),
                                asteroid.id,
                                b.createString(asteroid.nametype),
                                b.createString(asteroid.recclass),
                                asteroid.mass!!,
                                b.createString(asteroid.fall),
                                b.createString(asteroid.year),
                                asteroid.reclat!!,
                                asteroid.reclong!!,
                                IGeoLocation.createIGeoLocation(b,
                                    b.createString(geolocation.type),
                                    ICoordinates.createICoordinates(b,
                                        geolocation.coordinates[0],
                                        geolocation.coordinates[1]
                                    )
                                )
                            )
                    }
                )))
        return b.sizedByteArray()
    }

    @ExperimentalUnsignedTypes
    fun serialize(asteroids: IAsteroids): ByteArray {
        return asteroids.byteBuffer.array()
    }
}
