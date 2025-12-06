package org.hellstrand.renfikt.util

import java.lang.String.format

/**
 * @author (Mats Richard Hellstrand)
 * @version (6th of December, 2025)
 */
object LoggingUtil {
    fun formatMessage(messageTemplate: String, vararg messageParameters: String): String {
        return format(messageTemplate.replace("{}", "%s"), *messageParameters)
    }
}
