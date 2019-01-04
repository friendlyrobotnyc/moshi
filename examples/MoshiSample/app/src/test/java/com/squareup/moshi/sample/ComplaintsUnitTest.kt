package com.squareup.moshi.sample

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.junit.Assert
import org.junit.Test


class ComplaintsUnitTest {

    @Test
    fun loadData () {

        val source = inputStream("/govt_complaints.json")
        Assert.assertNotNull(source)

        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, Complaint::class.java)
        val complaints = moshi.adapter<List<Complaint>>(listType).fromJson(source)

        Assert.assertNotNull(complaints)
        Assert.assertEquals(complaints!!.isEmpty(), false)
    }

    private fun inputStream(path: String): String {
        return ComplaintsUnitTest::class.java!!.getResource(path).readText()
    }
}
