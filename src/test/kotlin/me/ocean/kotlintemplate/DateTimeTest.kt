package me.ocean.kotlintemplate

import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class DateTimeTest {
    @Test
    fun test() {
        val localDate =
            LocalDate.parse("20220101", DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay()

        println(localDate)
        val localDate2 =
            YearMonth.parse("202201", DateTimeFormatter.ofPattern("yyyyMM")).atDay(1).atStartOfDay()

        println(localDate2)
    }
}