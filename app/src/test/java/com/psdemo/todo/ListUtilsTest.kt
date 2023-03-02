package com.psdemo.todo

import com.psdemo.todo.list.determineCardColor
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ListUtilsTest {

    @Test
    fun test_determineCardColor(){
        val expected = R.color.todoDone
        val dueDate = null
        val done = true

        val actual = determineCardColor(dueDate, done)
        assertEquals(expected, actual)
    }

    @Test
    fun test_determineCardColorNotDone(){
        val expected = R.color.todoNotDue
        val done = false
        val dueDate = null

        val actual = determineCardColor(dueDate, done)
        assertEquals(expected, actual)
    }

    @Test
    fun test_determineCardColorOverDue(){
        val expected = R.color.todoOverDue
        val dueDate = Companion.now - Companion.day           // always gives 'yesterday' no matter when the test is run
        val done = false

        val actual = determineCardColor(dueDate, done)
        assertEquals(expected, actual)
    }

    companion object {
        const val day = 1000 * 60 * 60 * 24
        val now = System.currentTimeMillis()
    }

}