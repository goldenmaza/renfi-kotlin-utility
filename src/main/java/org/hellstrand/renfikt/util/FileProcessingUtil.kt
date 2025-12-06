package org.hellstrand.renfikt.util

import java.nio.file.Files
import java.nio.file.LinkOption
import java.nio.file.Path

/**
 * @author (Mats Richard Hellstrand)
 * @version (15th of December, 2025)
 */
object FileProcessingUtil {
    fun validateTarget(target: String): Boolean {
        return Files.exists(Path.of(target), LinkOption.NOFOLLOW_LINKS)
    }
}
