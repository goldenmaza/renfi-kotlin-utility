package org.hellstrand.renfikt.constant

import org.hellstrand.renfikt.constant.Constants.COMPARE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.CONVERT_PROCESSING
import org.hellstrand.renfikt.constant.Constants.CROP_PROCESSING
import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.DETECT_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.JAVA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_COMPARE
import org.hellstrand.renfikt.constant.Constants.LABEL_CONVERT
import org.hellstrand.renfikt.constant.Constants.LABEL_CROP
import org.hellstrand.renfikt.constant.Constants.LABEL_DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_DETECT
import org.hellstrand.renfikt.constant.Constants.LABEL_FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_JAVA
import org.hellstrand.renfikt.constant.Constants.LABEL_LIST
import org.hellstrand.renfikt.constant.Constants.LABEL_ORIGIN
import org.hellstrand.renfikt.constant.Constants.LABEL_SOURCE
import org.hellstrand.renfikt.constant.Constants.LABEL_UNKNOWN_EXECUTION
import org.hellstrand.renfikt.constant.Constants.LIST_PROCESSING
import org.hellstrand.renfikt.constant.Constants.ORIGIN_PROCESSING
import org.hellstrand.renfikt.constant.Constants.SOURCE_PROCESSING

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

    fun extractBranchTask(branchTask: String): String {
        return when (branchTask) {
            COMPARE_PROCESSING -> LABEL_COMPARE
            CROP_PROCESSING -> LABEL_CROP
            CONVERT_PROCESSING -> LABEL_CONVERT
            DETECT_PROCESSING -> LABEL_DETECT
            SOURCE_PROCESSING -> LABEL_SOURCE
            JAVA_PROCESSING -> LABEL_JAVA
            ORIGIN_PROCESSING -> LABEL_ORIGIN
            LIST_PROCESSING -> LABEL_LIST
            else -> LABEL_UNKNOWN_EXECUTION
        }
    }
}
