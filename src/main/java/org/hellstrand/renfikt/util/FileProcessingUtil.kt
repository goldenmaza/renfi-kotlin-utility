package org.hellstrand.renfikt.util

import java.io.File

/**
 * @author (Mats Richard Hellstrand)
 * @version (6th of December, 2025)
 */
object FileProcessingUtil {
    fun validateTarget(target: String): Boolean {
        return File(target).exists()
    }
}
