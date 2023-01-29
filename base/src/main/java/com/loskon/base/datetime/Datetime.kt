package com.loskon.base.datetime

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.toFormatString() = format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))