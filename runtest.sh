#!/bin/bash

adb shell timeout 100 am instrument -w -r    -e debug false -e class 'com.paulovap.benchmark.AsteroidTest' com.paulovap.benchmark.test/androidx.benchmark.junit4.AndroidBenchmarkRunner | grep android.studio.display.benchmark
