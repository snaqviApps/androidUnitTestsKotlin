package com.psdemo.todo

import com.psdemo.todo.data.Todo
import com.psdemo.todo.data.TodoRepository
import com.psdemo.todo.list.ListViewModel
import com.psdemo.todo.util.TodoTestRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class ListViewModelTest {

    lateinit var repository: TodoRepository

    @Before
    fun setup(){
        val now = System.currentTimeMillis()
        val day = 1000 * 60 * 60 * 24
        val todos = arrayListOf(
            Todo("1", "Todo 1", null, false, now),
            Todo("2", "Todo 2", now + day, false, now),
            Todo("3", "Todo 3", now + day, false, now),
            Todo("4", "Todo 4", now + day, false, now),
            Todo("5", "Todo 5", now - day, false, now)
        )

        repository = TodoTestRepository(todos)
    }

    @Test
    fun test_allTodos(){
        val expected = 5
        val model = ListViewModel(repository)
        val todos = model.allTodos.value

        assertNotNull(todos)
        assertEquals(expected, todos?.size)
    }

    @Test
    fun test_upcomingTodoCount(){
        val expected = 3                        // tests not completed, due-Data is not 'null', test is from future
        val model = ListViewModel(repository)
        val todoActualCount = model.upcomingTodosCount.value

        assertNotNull(todoActualCount)
        assertEquals(expected, todoActualCount)
    }
}