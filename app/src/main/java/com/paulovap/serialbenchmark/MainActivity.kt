package com.paulovap.serialbenchmark

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.flatbuffers.FlexBuffers
import com.google.flatbuffers.FlexBuffersBuilder
import com.google.flatbuffers.FlexBuffersReadBuf
import com.paulovap.benchmark.asteroids.FlexBufferReadBufAdapter
import kotlinx.android.synthetic.main.activity_main.*


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
//        Debug.startMethodTracing("flexbuffers_base")
//        val asteroids = adapter.deserialize(data)
//        Debug.stopMethodTracing()
        val builder = FlexBuffersBuilder()
        builder.putInt(10)
        val b = builder.finish()
        val s = FlexBuffersReadBuf.getRoot(b).asInt()
        Log.d("PV", "PV $s")
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
