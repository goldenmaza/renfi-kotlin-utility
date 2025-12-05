package org.hellstrand.renfikt.constant

import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_UNKNOWN_EXECUTION

/**
 * @author (Mats Richard Hellstrand)
 * @version (5th of December, 2025)
 */
object ConstantExtractionUtil {
    fun extractFlowTask(flowTask: String): String {
        return when (flowTask) {
            FILE_PROCESSING -> LABEL_FILE_PROCESSING
            DATA_PROCESSING -> LABEL_DATA_PROCESSING
            else -> LABEL_UNKNOWN_EXECUTION
        }
    }
}
