package com.paulovap.benchmark.asteroids

import com.google.flatbuffers.FlexBuffers
import com.google.flatbuffers.FlexBuffersBuilder
import com.google.flatbuffers.FlexBuffersBuilder.BUILDER_FLAG_SHARE_ALL
import java.nio.ByteBuffer
import java.nio.ByteOrder

class FlexBufferAdapter {

    companion object {
        val EMPTY_COORD = doubleArrayOf(0.0, 0.0)
    }

    fun deserialize(data: ByteArray): Asteroids {
        val buffer = ByteBuffer.wrap(data)
        buffer.order(ByteOrder.LITTLE_ENDIAN)

        val root = FlexBuffers.getRoot(buffer)
        val asteroidList = root.asMap().get("asteroids").asVector()

        val asteroids = Array(asteroidList.size()) {
            val map = asteroidList[it].asMap()
            val geo = map["geolocation"].asMap()
            var coordinates = EMPTY_COORD
            var type = ""
            if (geo.size() == 2) {
                val coord = geo["coordinates"].asVector()
                type = geo["type"].asString()
                coordinates = doubleArrayOf(coord.get(0).asFloat(), coord.get(1).asFloat())
            }
            Asteroid(
                name = map["name"].asString(),
                fall = map["fall"].asString(),
                id = map["id"].asInt(),
                mass = map["mass"].asFloat(),
                nametype = map["nametype"].asString(),
                recclass = map["recclass"].asString(),
                reclat = map["reclat"].asFloat(),
                reclong = map["reclong"].asFloat(),
                year = map["year"].asString(),
                geolocation = GeoLocation(
                    type = type,
                    coordinates = coordinates
                )
            )
        }
        return Asteroids(asteroids = asteroids)
    }

    fun serialize(asteroids: Asteroids): ByteArray {
        val builder = FlexBuffersBuilder(ByteBuffer.allocate(260*1024), BUILDER_FLAG_SHARE_ALL)
        val startAsteroidsMap = builder.startMap()
        val startAsteroidVector = builder.startVector()

        for (asteroid in asteroids.asteroids) {
            // Asteroid
            val aMap = builder.startMap()
            builder.putString("name", asteroid.name)
            builder.putString("fall", asteroid.fall)
            builder.putInt("id", asteroid.id)
            builder.putFloat("mass", asteroid.mass!!)
            builder.putString("nametype", asteroid.nametype)
            builder.putString("recclass", asteroid.recclass)
            builder.putFloat("reclat", asteroid.reclat!!)
            builder.putFloat("reclong", asteroid.reclong!!)
            builder.putString("year", asteroid.year)
            // Geolocation
            val geoIdx = builder.startMap()
            builder.putString("type", asteroid.geolocation!!.type)
            // Coordinate
            val coordIdx = builder.startVector()
            builder.putFloat(asteroid.geolocation.coordinates[0])
            builder.putFloat(asteroid.geolocation.coordinates[1])
            builder.endVector("coordinates", coordIdx, false, true)
            builder.endMap("geolocation", geoIdx)

            builder.endMap(null, aMap)
        }

        builder.endVector("asteroids", startAsteroidVector, false, false)
        builder.endMap(null, startAsteroidsMap)
        return builder.finish().array()
    }
}
