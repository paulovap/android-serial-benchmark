package com.paulovap.benchmark

import com.google.flatbuffers.FlexBuffers
import com.google.flatbuffers.FlexBuffers.FBT_VECTOR
import com.google.flatbuffers.FlexBuffersBuilder
import java.nio.ByteBuffer
import java.nio.ByteOrder

class FlexBufferAdapter {
    fun deserialize(data: ByteArray): Asteroids {
        val buffer = ByteBuffer.wrap(data)
        buffer.order(ByteOrder.LITTLE_ENDIAN)

        val root = FlexBuffers.getRoot(buffer)
        val asteroidList = root.asMap().get("asteroids").asVector()

        val asteroids = Array(asteroidList.size()) {
            val map = asteroidList[it].asMap()
            val geo = map["geolocation"].asMap()
            val coord = geo["coordinates"].asVector()

            val vec = map.values()
            Asteroid(name = map["name"].asString(),
                fall = vec[0].asString(),
                id = map["id"].asInt(),
                mass = map["mass"].asFloat(),
                nametype = map["nametype"].asString(),
                recclass = map["recclass"].asString(),
                reclat = map["reclat"].asFloat(),
                reclong = map["reclong"].asFloat(),
                year = map["year"].asString(),
                geolocation = GeoLocation(
                    type= geo["type"].asString(),
                    coordinates = doubleArrayOf(10.0, 10.0)
                )
                )
        }
        return Asteroids(asteroids = asteroids)
    }
}