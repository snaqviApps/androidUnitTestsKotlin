package com.psdemo.todo

import com.psdemo.todo.list.determineCardColor
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/** Parameterization helps in keep code non-redundant */
@RunWith(Parameterized::class)
class ListUtilsTest(
    private val expected : Int,
    private val dueDate : Long?,
    private val done : Boolean,
    private val scenario : String
) {
    companion object {
        private const val day = 1000 * 60 * 60 * 24
        private val now = System.currentTimeMillis()

        @JvmStatic
        @Parameterized.Parameters(name = "test_determineCardColor: {3}")
        fun todos() = listOf(
            arrayOf(R.color.todoDone, null, true, "Done, no date"),
            arrayOf(R.color.todoNotDue, null, false, "Not Done, No date"),
            arrayOf(R.color.todoOverDue, now - day, false, "Not Done, Due yesterday")
        )
    }

    @Test
    fun test_determineCardColor(){
        val actual = determineCardColor(dueDate, done)
        assertEquals(expected, actual)
    }

}