import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.regex.Pattern


// YYYY
val yyyyDate = Regex("e\\s[0-9]{4}.")

// YYYY.
val yyyyDatePeriod = Regex("[0-9]{4}.")

// YYYY - YYYY.
val yyyy_yyyyDate = Regex("$yyyyDate\\s-\\s$yyyyDate")

// YYYY - YYYY.
val yyyy_yyyyDatePeriod = Regex("$yyyyDate\\s-\\s$yyyyDate.")

val currYear = getCurrentYear()

val tofibStatement =
    "/**\n" +
            "* Copyright Tandem Diabetes Care 2018 - 2020.  All rights reserved.\n" +
            "* ParsingRules.kt\n" +
            "* TODO: SUMMARY\n" +
            "* @author Mitch Thornton May 08, 2020\n" +
            "*"

fun main(args: Array<String>) {
    println("TOFIB STATEMENT: $tofibStatement")
    parseCopyRightStatement(tofibStatement)
}


fun parseCopyRightStatement(foundCopyRight: String): Boolean {

    //  * Copyright Tandem Diabetes Care
    val baseCopyRight = foundCopyRight.substring(0, 37)

    val tokens = foundCopyRight.split(" ")
    val lines = foundCopyRight.split("\n")

    println("TOKENS: \n")
    tokens.forEach { println("$it\n") }

    println("\n")


    println("LINES: \n")
    lines.forEach { println("$it\n") }

    println("\n")


    // Should check token size beforehand to see if we're looking for an initial date vs end date
    // Should check if there's a -
    // Not sure if 7 is right... Haven't tested

    val regex = Regex(("\\* Copyright Tandem Diabetes Care 2018 - 2020.  All rights reserved."))


//    val yyyy_yyyyDate = Pattern.compile(
//        "\\d{4}\\s\\-\\s\\d{4}."
//    )

//    val matchingRegex = Regex(tofibStatement)


    // 2018
    val foundInitialDate = tokens.get(5)

    // 2020.
    val foundEndDate = tokens.get(7)

    // Find all dates via REGEX
    val matchResults = baseCopyRight.matches(regex)

    println("TOFIB STATEMENT: \n Base Copyright:\n  ${baseCopyRight}\n Found Initial Date: ${foundInitialDate}\n Found End Date: ${foundEndDate}\n Match Results: ${matchResults}")


    // Match CopyRight

    // Ensures the base copyright portion matches
//    if (!foundCopyRight.substring(0, 33).contentEquals(baseCopyRight)) {
//        return false
//    }


    // Find YYYY - YYYY.
//    if (foundCopyRight.contains(yyyy_yyyyDate)) {
//        println("\n\n\nTOFIB YYYY - YYYY. FOUND!")
//    }
//
//
//    // Find YYYY - YYYY. & and REPLACE
//    if (foundCopyRight.contains(yyyy_yyyyDatePeriod)) {
//        println("\n\n\nTOFIB YYYY - FOUND!")
//        val updatedCopyright = foundCopyRight.replace(yyyy_yyyyDate, "REPLACED!")
//        println("\n\n\n $updatedCopyright")
//    }


    findYYYY(foundCopyRight)
//    findYYYYReplace(foundCopyRight)

//    println("\n\nUpdated InitialYearOnly:  ${updateYYYYPeriodWithCurrentYear(foundCopyRight)}")

    return true
}


// Find YYYY
fun findYYYY(foundCopyRight: String): String {
    println("\n\nFound YYYY: \n")

    var creationYear: Int? = null
    var updatedYear: Int? = null
    var updatedCopyright: String = foundCopyRight

    yyyyDate.findAll(foundCopyRight)?.let { years ->

//        if (years.count() == 1) {
//            if (years.first().value.toInt() in 2018 until currYear) {
//                println("Creation Year: ${years.first().value.toInt()}")
//                creationYear = years.first().value.toInt()
//            }
//
//        } else if (years.count() == 2) {
//            if (years.first().value.toInt() in 2018 until currYear) {
//                println("Creation Year: ${years.first().value.toInt()}")
//                creationYear = years.first().value.toInt()
//            }
//
//            if (years.last().value.toInt() in 2018..currYear) {
//                println("Updated Year: ${years.last().value.toInt()}")
//                updatedYear = years.last().value.toInt()
//            }
//        }

        println("STR REPLACE:  ${foundCopyRight.replace(yyyy_yyyyDate, "6969 - 6969")}")
//        println("STR REPLACE:  ${foundCopyRight.replace(yyyyDate, "e 6969.")}")
    }
    return "TEST"
}


fun findYYYY_YYYYReplace(foundCopyRight: CharSequence) {
    println("UPDATED:  ${yyyy_yyyyDate.replace(foundCopyRight, "1010-2020")}")
}


fun findYYYYReplace(foundCopyRight: CharSequence) {
    println("UPDATED:  ${yyyyDatePeriod.replace(foundCopyRight, "2018-2020.")}")
}


// Returns the current year
// Used to check and auto-update last changed date
fun getCurrentYear(): Int {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.BASIC_ISO_DATE
    return current.format(formatter).substring(0, 4).toInt()
}


fun copyRightMatches(copyRight: String) {
    val copyRightTDC = "\n* Copyright Tandem Diabetes Care "
    val copyRightDate = "[YYYY - YYYY]||[YYYY]."
    val allRightsReserved = "  All rights reserved."
}
