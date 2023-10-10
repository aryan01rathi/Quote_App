package com.example.quoteapp

//import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

//import org.junit.jupiter.api.Assertions.assertEquals
//import org.junit.jupiter.api.Test

/**
 * Instrumented test, which will execute on an Android device.
 * run
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.quoteapp", appContext.packageName)
    }
}