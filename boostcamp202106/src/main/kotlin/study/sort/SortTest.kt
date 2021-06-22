package study.sort

import kotlin.system.measureTimeMillis

private fun main() {
    // Simple Test
    TestCase.testCase.forEach { testCase ->

        // Sort Test Here
        // SelectionSort(testCase).sortAsc().print()
        // BubbleSort(testCase).sortAsc().print()
        // InsertionSort(testCase).sortAsc().print()
        // ShellSort(testCase).sortAsc().print()
        // MergeSort(testCase).sortAsc().print()
    }

    // Large Size Array Test
    TestCase.testCase30000.let { testCase ->
        // Sort Test Here
        printExecuteTime("Selection Sort") { SelectionSort(testCase.copyOf()).sortAsc() }
        printExecuteTime("Bubble Sort") { BubbleSort(testCase.copyOf()).sortAsc() }
        printExecuteTime("Insertion Sort") { InsertionSort(testCase.copyOf()).sortAsc() }
        printExecuteTime("Shell Sort") { ShellSort(testCase.copyOf()).sortAsc() }
        printExecuteTime("Merge Sort") { MergeSort(testCase.copyOf()).sortAsc() }
    }
}

private fun IntArray.print() {
    this.forEach { print("$it ") }
    println()
}

private fun printExecuteTime(tag: String, work: () -> Unit) {
    println("$tag : ${measureTimeMillis { work.invoke() }}ms")
}