package org.hellstrand.renfikt.constant

import java.lang.String.format

/**
 * @author (Mats Richard Hellstrand)
 * @version (5th of December, 2025)
 */
object LoggingUtil {
    fun formatMessage(messageTemplate: String, vararg messageParameters: String): String {
        return format(messageTemplate.replace("{}", "%s"), *messageParameters)
    }
}
