package com.paulovap.serialbenchmark

import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.paulovap.benchmark.asteroids.FlexBufferAdapter
import com.paulovap.benchmark.asteroids.FlexBufferReadBufAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        testFlexBuffers()
    }

    private fun testFlexBuffers() {
        val adapter = FlexBufferReadBufAdapter()
        val data = baseContext.resources.openRawResource(R.raw.asteroids).readBytes()
        Debug.startMethodTracing("flexbuffers_base")
        val asteroids = adapter.deserialize(data)
        Debug.stopMethodTracing()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
