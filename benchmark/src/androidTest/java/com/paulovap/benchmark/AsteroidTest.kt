package com.paulovap.benchmark

import android.content.Context
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.GsonBuilder
import com.paulovap.benchmark.asteroids.*
import com.squareup.moshi.Moshi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.rules.Timeout
import org.junit.runners.MethodSorters
import java.util.concurrent.TimeUnit

/**
 * Preform benchmarks against NASA's meteorite landings on earth.
 * Data is public available in:
 * https://data.nasa.gov/resource/y77d-th95.json
 * but it was modified to covent the floats and ints
 * that were represented as "10.0" into just 10.0 (without quotes)
 */
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AsteroidTest {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @get:Rule
    var globalTimeout = Timeout.seconds(100)

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

//    @Test
//    fun testDeserializeMoshi() {
//        val moshi = Moshi.Builder().build()
//        val data = String(context.resources.assets.open("asteroids.json").readBytes())
//        val jsonAdapter = moshi.adapter<Asteroids>(Asteroids::class.java)
//
//        benchmarkRule.measureRepeated {
//            val asteroids = jsonAdapter.fromJson(data)
//            assertEquals(asteroids!!.asteroids.size, 1000)
//        }
//    }
//
//    @Test
//    fun testDeserializeGson() {
//        val gson = GsonBuilder().create()
//        val data = String(context.resources.assets.open("asteroids.json").readBytes())
//
//        benchmarkRule.measureRepeated {
//            val asteroids = gson.fromJson(data, Asteroids::class.java)
//            assertEquals(asteroids!!.asteroids.size, 1000)
//        }
//    }

    @Test
    fun testDeserializeFlexBuffer() {
        val adapter = FlexBufferAdapter()
        val data = context.resources.assets.open("asteroids.flexbin").readBytes()
        benchmarkRule.measureRepeated {
            val asteroids = adapter.deserialize(data)
            assertEquals(1000, asteroids.asteroids.size)
        }
    }

    @Test
    fun testDeserializeFlexBufferNew() {
        val adapter = FlexBufferNewAdapter()
        val data = context.resources.assets.open("asteroids.flexbin").readBytes()
        benchmarkRule.measureRepeated {
            val asteroids = adapter.deserialize(data)
            assertEquals(1000, asteroids.asteroids.size)
        }
    }

//    @ExperimentalUnsignedTypes
//    @Test
//    fun testDeserializeFlatBuffer() {
//        val adapter = FlatBufferAdapter()
//        val data = context.resources.assets.open("asteroids.bin").readBytes()
//        benchmarkRule.measureRepeated {
//            val asteroids = adapter.deserializeToAsteroid(data)
//            assertEquals(1000, asteroids.asteroids.size)
//        }
//    }
//
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testDeserializeFlatBufferNoConversion() {
//        val adapter = FlatBufferAdapter()
//        val data = context.resources.assets.open("asteroids.bin").readBytes()
//        benchmarkRule.measureRepeated {
//            val asteroids = adapter.deserialize(data)
//            assertEquals(1000, asteroids.asteroidsLength())
//        }
//    }
//
//    @Test
//    fun testDeserializeProtobuf() {
//        val adapter = ProtoAdapter()
//        val data = context.resources.assets.open("asteroids.protob").readBytes()
//        benchmarkRule.measureRepeated {
//            val asteroids = adapter.deserializeToAsteroid(data)
//            assertEquals(1000, asteroids.asteroids.size)
//        }
//    }
//
//    @Test
//    fun testDeserializeProtobufNoConversion() {
//        val adapter = ProtoAdapter()
//        val data = context.resources.assets.open("asteroids.protob").readBytes()
//        benchmarkRule.measureRepeated {
//            val asteroids = adapter.deserialize(data)
//            assertEquals(1000, asteroids.asteroidsCount)
//        }
//    }
//
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testSerializeFlexBuffer() {
//        val adapter = FlexBufferAdapter()
//        val data = context.resources.assets.open("asteroids.flexbin").readBytes()
//        val asteroids = adapter.deserialize(data)
//        benchmarkRule.measureRepeated {
//            val data = adapter.serialize(asteroids)
//            assertEquals(1000, asteroids.asteroids.size)
//        }
//    }

//    @Test
//    fun testSerializeGson() {
//        val gson = GsonBuilder().create()
//        val data = String(context.resources.assets.open("asteroids.json").readBytes())
//        val asteroids = gson.fromJson(data, Asteroids::class.java)
//        benchmarkRule.measureRepeated {
//            val data = gson.toJson(asteroids)
//            assertEquals(1000, asteroids.asteroids.size)
//        }
//    }

//    @Test
//    fun testSerializeMoshi() {
//        val moshi = Moshi.Builder().build()
//        val data = String(context.resources.assets.open("asteroids.json").readBytes())
//        val jsonAdapter = moshi.adapter<Asteroids>(Asteroids::class.java)
//        val asteroids = jsonAdapter.fromJson(data)
//        benchmarkRule.measureRepeated {
//            val data = jsonAdapter.toJson(asteroids)
//            assertEquals(1000, asteroids!!.asteroids.size)
//        }
//    }
//
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testSerializeFlatbuffer() {
//        val adapter = FlatBufferAdapter()
//        val data = context.resources.assets.open("asteroids.bin").readBytes()
//        val asteroids = adapter.deserializeToAsteroid(data)
//        assertEquals(1000, asteroids.asteroids.size)
//        benchmarkRule.measureRepeated {
//            val result = adapter.serializeFromAsteroid(asteroids)
//        }
//    }
//
//    @ExperimentalUnsignedTypes
//    @Test
//    fun testSerializeFlatbufferNoConversion() {
//        val adapter = FlatBufferAdapter()
//        val data = context.resources.assets.open("asteroids.bin").readBytes()
//        val asteroids = adapter.deserialize(data)
//        assertEquals(1000, asteroids.asteroidsLength())
//        benchmarkRule.measureRepeated {
//            val result = adapter.serialize(asteroids)
//        }
//    }
//
//    @Test
//    fun testSerializeProtobuf() {
//        val adapter = ProtoAdapter()
//        val data = context.resources.assets.open("asteroids.protob").readBytes()
//        val asteroids = adapter.deserializeToAsteroid(data)
//        assertEquals(1000, asteroids.asteroids.size)
//        benchmarkRule.measureRepeated {
//            val result = adapter.serializeFromAsteroids(asteroids)
//        }
//    }
//
//    @Test
//    fun testSerializeProtobufNoConversion() {
//        val adapter = ProtoAdapter()
//        val data = context.resources.assets.open("asteroids.protob").readBytes()
//        val asteroids = adapter.deserialize(data)
//        assertEquals(1000, asteroids.asteroidsCount)
//        benchmarkRule.measureRepeated {
//            val result = adapter.serialize(asteroids)
//        }
//    }
}
