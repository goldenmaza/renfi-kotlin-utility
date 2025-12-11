package org.hellstrand.renfikt.mock

import org.hellstrand.renfikt.constant.Constants.COMPARE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.CREATION_TIME_FLAG
import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.IMAGE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.JAVA_PROCESSING
import org.hellstrand.renfikt.constant.TestConstants.DEFAULT_INTEGER_VALUE
import org.hellstrand.renfikt.constant.TestConstants.HYPHEN_HELP_FLAG
import org.hellstrand.renfikt.constant.TestConstants.INVALID_HYPHEN_FLAG
import org.hellstrand.renfikt.constant.TestConstants.INVALID_NEGATIVE_INDEX_VALUE
import org.hellstrand.renfikt.constant.TestConstants.INVALID_POSITIVE_INDEX_VALUE
import org.hellstrand.renfikt.constant.TestConstants.INVALID_RESOURCES_PATH_SUFFIX
import org.hellstrand.renfikt.constant.TestConstants.IRRELEVANT_HYPHEN_FLAG
import org.hellstrand.renfikt.constant.TestConstants.IRRELEVANT_NEGATIVE_INTEGER_VALUE
import org.hellstrand.renfikt.constant.TestConstants.IRRELEVANT_POSITIVE_INTEGER_VALUE
import org.hellstrand.renfikt.constant.TestConstants.MAX_INTEGER_VALUE
import org.hellstrand.renfikt.constant.TestConstants.VALID_RESOURCES_PATH_SUFFIX
import java.nio.file.Paths

/**
 * @author (Mats Richard Hellstrand)
 * @version (11th of December, 2025)
 */
object RenfiUtilityMock {
    private val PROJECT_ABSOLUTE_PATH = Paths.get("").toAbsolutePath().toString()
    val INVALID_DIRECTORY_PATH = Paths.get(PROJECT_ABSOLUTE_PATH, INVALID_RESOURCES_PATH_SUFFIX).toString()
    val VALID_DIRECTORY_PATH = Paths.get(PROJECT_ABSOLUTE_PATH, VALID_RESOURCES_PATH_SUFFIX).toString()

    fun getEmptyArguments(): Array<String> {
        return arrayOf()
    }

    fun getHelpArgument(): Array<String> {
        return arrayOf(HYPHEN_HELP_FLAG)
    }

    fun getInvalidFlowArguments(): Array<String> {
        val flow = INVALID_HYPHEN_FLAG
        val branch = IRRELEVANT_HYPHEN_FLAG
        val resource = IRRELEVANT_HYPHEN_FLAG
        val from = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val to = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val yAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val xAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val timestamp = IRRELEVANT_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, INVALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidBranchArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = INVALID_HYPHEN_FLAG
        val resource = IRRELEVANT_HYPHEN_FLAG
        val from = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val to = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val yAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val xAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val timestamp = IRRELEVANT_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, INVALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidResourceArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = INVALID_HYPHEN_FLAG
        val from = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val to = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val yAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val xAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val timestamp = IRRELEVANT_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, INVALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidDirectoryPathArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val to = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val yAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val xAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val timestamp = IRRELEVANT_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, INVALID_RESOURCES_PATH_SUFFIX, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidFromIndexArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = INVALID_NEGATIVE_INDEX_VALUE
        val to = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val yAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val xAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val timestamp = IRRELEVANT_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, VALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidToIndexArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = DEFAULT_INTEGER_VALUE
        val to = INVALID_POSITIVE_INDEX_VALUE
        val yAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val xAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val timestamp = IRRELEVANT_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, VALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidUpperLeftYAxisArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = DEFAULT_INTEGER_VALUE
        val to = DEFAULT_INTEGER_VALUE
        val yAxis = INVALID_NEGATIVE_INDEX_VALUE
        val xAxis = IRRELEVANT_POSITIVE_INTEGER_VALUE
        val timestamp = IRRELEVANT_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, VALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidUpperLeftXAxisArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = DEFAULT_INTEGER_VALUE
        val to = DEFAULT_INTEGER_VALUE
        val yAxis = DEFAULT_INTEGER_VALUE
        val xAxis = INVALID_NEGATIVE_INDEX_VALUE
        val timestamp = IRRELEVANT_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, VALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidTimestampArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = DEFAULT_INTEGER_VALUE
        val to = DEFAULT_INTEGER_VALUE
        val yAxis = DEFAULT_INTEGER_VALUE
        val xAxis = DEFAULT_INTEGER_VALUE
        val timestamp = INVALID_HYPHEN_FLAG
        val boundary = IRRELEVANT_POSITIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, VALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getInvalidBoundaryArguments(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = DEFAULT_INTEGER_VALUE
        val to = DEFAULT_INTEGER_VALUE
        val yAxis = DEFAULT_INTEGER_VALUE
        val xAxis = DEFAULT_INTEGER_VALUE
        val timestamp = CREATION_TIME_FLAG
        val boundary = IRRELEVANT_NEGATIVE_INTEGER_VALUE
        return arrayOf(flow, branch, resource, VALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getDefaultArgumentsForFileAndCompareProcessingOfImages(): Array<String> {
        val flow = FILE_PROCESSING
        val branch = COMPARE_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = DEFAULT_INTEGER_VALUE
        val to = DEFAULT_INTEGER_VALUE
        val yAxis = DEFAULT_INTEGER_VALUE
        val xAxis = DEFAULT_INTEGER_VALUE
        val timestamp = CREATION_TIME_FLAG
        val boundary = MAX_INTEGER_VALUE
        return arrayOf(flow, branch, resource, VALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }

    fun getDefaultArgumentsForDataAndJavaProcessingOfImages(): Array<String> {
        val flow = DATA_PROCESSING
        val branch = JAVA_PROCESSING
        val resource = IMAGE_PROCESSING
        val from = DEFAULT_INTEGER_VALUE
        val to = DEFAULT_INTEGER_VALUE
        val yAxis = DEFAULT_INTEGER_VALUE
        val xAxis = DEFAULT_INTEGER_VALUE
        val timestamp = CREATION_TIME_FLAG
        val boundary = MAX_INTEGER_VALUE
        return arrayOf(flow, branch, resource, VALID_DIRECTORY_PATH, from, to, yAxis, xAxis, timestamp, boundary)
    }
}
