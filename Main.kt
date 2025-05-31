package com.conestoga.taskmanager

// task class for task info
class Task(var id: Int, var title: String, var description: String, var isCompleted: Boolean = false) {

    // change the completed value (true or false)
    fun toggleStatus() {
        isCompleted = !isCompleted
    }

    // this will show full task info
    fun showDetails() {
        println("Task ID: $id")
        println("Title: $title")
        println("Description: $description")
        println("Completed: $isCompleted")
    }
}

// this add task to list
fun addTask(myTasks: MutableList<Task>, newTask: Task) {
    myTasks.add(newTask)
}

// get only incomplete task list
fun getIncompleteTasks(myTasks: List<Task>): List<Task> {
    return myTasks.filter { !it.isCompleted }
}

// show only the title of all tasks
fun printTaskTitles(myTasks: List<Task>) {
    myTasks.map { it.title }.forEach { println(it) }
}

fun main() {
    val myTasks = mutableListOf<Task>()

    // make 2 tasks
    val t1 = Task(1, "Anime", "AOT and One piece", false)
    val t2 = Task(2, "Assignment 1", "Complete it ASAP", true)

    // add to the list
    addTask(myTasks, t1)
    addTask(myTasks, t2)

    println("All task titles:")
    printTaskTitles(myTasks)

    println("\nOnly incomplete tasks:")
    val notDone = getIncompleteTasks(myTasks)
    for (t in notDone) {
        t.showDetails()
    }

    println("\nChange task 1 status now:")
    t1.toggleStatus()
    t1.showDetails()
}
