package com.paulovap.benchmark

import android.content.Context
import android.util.Log
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.GsonBuilder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import com.squareup.moshi.Moshi
import org.junit.Assert.assertEquals


@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class AsteroidTest {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun testDeserializeMoshi() {
        val moshi = Moshi.Builder().build()
        val data = String(context.resources.assets.open("asteroids.json").readBytes())
        val jsonAdapter = moshi.adapter<Asteroids>(Asteroids::class.java)

        benchmarkRule.measureRepeated {
            val asteroids = jsonAdapter.fromJson(data)
            assertEquals(asteroids!!.asteroids.size, 1000)
        }
    }

    @Test
    fun testDeserializeGson() {
        val gson = GsonBuilder().create()
        val data = String(context.resources.assets.open("asteroids.json").readBytes())

        benchmarkRule.measureRepeated {
            val asteroids = gson.fromJson(data, Asteroids::class.java)
            assertEquals(asteroids!!.asteroids.size, 1000)
        }
    }

    @Test
    fun testDeserializeFlexBuffer() {
        val adapter = FlexBufferAdapter()
        val data = context.resources.assets.open("asteroids.bin").readBytes()
        benchmarkRule.measureRepeated {
            val asteroids = adapter.deserialize(data)
            assertEquals(1000, asteroids.asteroids.size)
        }
    }
}