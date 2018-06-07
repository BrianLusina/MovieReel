package com.moviereel.presentation.factory

import java.util.*

/**
 * @author lusinabrian on 27/04/18.
 * @Notes Factory class for data instances
 */

private fun ClosedRange<Int>.randomInt() =
        Random().nextInt(endInclusive - start) + start

private fun ClosedRange<Int>.randomLong() =
        Random().nextLong() + endInclusive - start

private fun ClosedRange<Char>.randomString(length: Int) =
        (1..length)
                .map { (Random().nextInt(endInclusive.toInt() - start.toInt()) + start.toInt()).toChar() }
                .joinToString("")

private fun <E> List<E>.getRandomElement() = this[Random().nextInt(this.size)]

private fun randomIntNumber(length: Int = 100) = (1..length).randomInt()
private fun randomLongNumber() = (1..10).randomLong()

private fun randBetween(start: Int, end: Int): Int {
    return start + Math.round(Math.random() * (end - start)).toInt()
}

fun randomUuid(): String {
    return java.util.UUID.randomUUID().toString()
}

fun randomId() = randomLongNumber()

fun randomVoteCount() = randomIntNumber()

fun randomBoolean(): Boolean {
    val list = listOf(true, false)
    return list.getRandomElement()
}

fun randomVoteAverage() = Random().nextFloat()

fun randomPopularity() = Random().nextFloat()

fun randomTitle() = ('a'..'z').randomString(randomIntNumber()).capitalize()

fun randomPosterPath() = "\\/${randomUuid()}.jpg"

fun randomBackdropPath() = "\\/${randomUuid()}.jpg"

fun randomOriginalLang(): String {
    val list = listOf("en-US", "en-GB")
    return list.getRandomElement()
}

fun randomOverview(length: Int) = ('a'..'z').randomString(randomIntNumber(length)).capitalize()

fun randomGenreIds(count: Int = 5): List<Int> {
    val list = mutableListOf<Int>()

    repeat(count) {
        val randomGenreId = randomIntNumber()
        list.add(randomGenreId)
    }

    return list
}

fun randomReleaseDate(): String {
    val year = randBetween(1900, 2018)
    val month = randBetween(1, 12)
    val day = randBetween(1, 31)
    return "$year-$month-$day"
}
