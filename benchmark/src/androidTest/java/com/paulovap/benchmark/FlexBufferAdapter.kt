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
            val coordinates = if(coord.isEmpty) doubleArrayOf(0.0, 0.0) else doubleArrayOf(coord.get(0).asFloat(), coord.get(1).asFloat())
            Asteroid(name = map["name"].asString(),
                fall = map["fall"].asString(),
                id = map["id"].asInt(),
                mass = map["mass"].asFloat(),
                nametype = map["nametype"].asString(),
                recclass = map["recclass"].asString(),
                reclat = map["reclat"].asFloat(),
                reclong = map["reclong"].asFloat(),
                year = map["year"].asString(),
                geolocation = GeoLocation(
                    type= geo["type"].asString(),
                    coordinates = coordinates
                )
                )
        }
        return Asteroids(asteroids = asteroids)
    }
}