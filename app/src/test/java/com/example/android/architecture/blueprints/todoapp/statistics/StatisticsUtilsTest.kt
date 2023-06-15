package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{
    @Test
    fun getActiveAndCompletedStats_oneNotCompletedTask_returnsHundredZero(){
        //when
        val tasks = listOf<Task>(
                Task("test", "test", false)
        )

        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f,result.activeTasksPercent)
    }
    @Test
    fun getActiveAndCompletedStats_oneCompletedTask_returnsZeroHundred(){
        //when
        val tasks = listOf<Task>(
                Task("test", "test", true)
        )

        //given
        val result = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(100f, result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)
    }
    @Test
    fun getActiveAndCompletedStats_twoCompletedTask_3Activetask_returnsZeroHundred(){
        //when
        val tasks = listOf<Task>(
                Task("test", "test", true),
                Task("test", "test", true),
                Task("test", "test", false),
                Task("test", "test", false),
                Task("test", "test", false)
        )


        //given
        val result = getActiveAndCompletedStats(tasks)
        val result1 = getActiveAndCompletedStats(tasks)
        //then
        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f,result1.activeTasksPercent)
    }
    @Test
    fun getActiveAndCompletedStatsreturnsZeroZero(){
        //given
        val result = getActiveAndCompletedStats(emptyList())
        //then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)

    }
    @Test
    fun getActiveAndCompletedZeroZero(){
        //given
        val result = getActiveAndCompletedStats(null)
        //then
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f,result.activeTasksPercent)

    }
}