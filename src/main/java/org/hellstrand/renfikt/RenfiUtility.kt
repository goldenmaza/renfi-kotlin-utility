package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.Constants.BOUNDARY_INDEX
import org.hellstrand.renfikt.constant.Constants.BRANCH_FLAGS
import org.hellstrand.renfikt.constant.Constants.BRANCH_INDEX
import org.hellstrand.renfikt.constant.Constants.FLOW_FLAGS
import org.hellstrand.renfikt.constant.Constants.FLOW_INDEX
import org.hellstrand.renfikt.constant.Constants.FROM_INDEX
import org.hellstrand.renfikt.constant.Constants.HELP_FLAGS
import org.hellstrand.renfikt.constant.Constants.LEFT_X_AXIS
import org.hellstrand.renfikt.constant.Constants.LEFT_Y_AXIS
import org.hellstrand.renfikt.constant.Constants.MEDIA_SUPPORT
import org.hellstrand.renfikt.constant.Constants.MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_AXIS_INDEXES
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_BOUNDARY_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_BRANCH_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_EXTENSION_INDEXES
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_FLOW_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_PROJECT_DIRECTORY
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_RESOURCE_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_TIMESTAMP_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_PROCESSING_ATTRIBUTES
import org.hellstrand.renfikt.constant.Constants.MESSAGE_PROCESSING_TASK
import org.hellstrand.renfikt.constant.Constants.PATH_INDEX
import org.hellstrand.renfikt.constant.Constants.RESOURCE_INDEX
import org.hellstrand.renfikt.constant.Constants.TIMESTAMP_FLAGS
import org.hellstrand.renfikt.constant.Constants.TIMESTAMP_INDEX
import org.hellstrand.renfikt.constant.Constants.TO_INDEX
import org.hellstrand.renfikt.exception.DirectoryUnavailableException
import org.hellstrand.renfikt.exception.DisplayHelpGuideException
import org.hellstrand.renfikt.exception.InvalidUseException
import org.hellstrand.renfikt.util.ConstantExtractionUtil
import org.hellstrand.renfikt.util.FileProcessingUtil
import org.hellstrand.renfikt.util.HelpGuideUtil
import org.hellstrand.renfikt.util.LoggingUtil
import org.slf4j.LoggerFactory

/**
 * @author (Mats Richard Hellstrand)
 * @version (22nd of December, 2025)
 */
object RenfiUtility {
    private val logger = LoggerFactory.getLogger(RenfiUtility::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 10 || HELP_FLAGS.contains(args[0])) {
            HelpGuideUtil.displayHelpGuide()
            throw DisplayHelpGuideException(MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION)
        }

        // Fetch the application's arguments...
        val flow = args[FLOW_INDEX]
        val branch = args[BRANCH_INDEX]
        val resource = args[RESOURCE_INDEX]
        val path = args[PATH_INDEX]
        val fromIndex = args[FROM_INDEX]
        val toIndex = args[TO_INDEX]
        val leftYAxis = args[LEFT_Y_AXIS]
        val leftXAxis = args[LEFT_X_AXIS]
        val timestamp = args[TIMESTAMP_INDEX]
        val boundary = args[BOUNDARY_INDEX]

        // Evaluate the application's arguments...
        if (!FLOW_FLAGS.contains(flow)) {
            val formattedMessage = LoggingUtil.formatMessage(MESSAGE_INVALID_FLOW_INDEX, flow)
            logger.error(formattedMessage)
            throw InvalidUseException(formattedMessage)
        }

        if (!BRANCH_FLAGS.contains(branch)) {
            val formattedMessage = LoggingUtil.formatMessage(MESSAGE_INVALID_BRANCH_INDEX, branch)
            logger.error(formattedMessage)
            throw InvalidUseException(formattedMessage)
        }

        if (!MEDIA_SUPPORT.containsKey(resource)) {
            val formattedMessage = LoggingUtil.formatMessage(MESSAGE_INVALID_RESOURCE_INDEX, resource)
            logger.error(formattedMessage)
            throw InvalidUseException(formattedMessage)
        }

        if (!FileProcessingUtil.validateTarget(path)) {
            val formattedMessage = LoggingUtil.formatMessage(MESSAGE_INVALID_PROJECT_DIRECTORY, path)
            logger.error(formattedMessage)
            throw DirectoryUnavailableException(formattedMessage)
        }

        val selectedExtensions = MEDIA_SUPPORT[resource]
        val extensionFromIndex = Integer.parseInt(fromIndex)
        val extensionToIndex = Integer.parseInt(toIndex)
        if (extensionFromIndex < 0 || extensionToIndex >= selectedExtensions!!.size) {
            val formattedMessage = LoggingUtil.formatMessage(MESSAGE_INVALID_EXTENSION_INDEXES, fromIndex, toIndex)
            logger.error(formattedMessage)
            throw InvalidUseException(formattedMessage)
        }

        val yAxis = Integer.parseInt(leftYAxis)
        val xAxis = Integer.parseInt(leftXAxis)
        if (yAxis < 0 || xAxis < 0) {
            val formattedMessage = LoggingUtil.formatMessage(MESSAGE_INVALID_AXIS_INDEXES, leftYAxis, leftXAxis)
            logger.error(formattedMessage)
            throw InvalidUseException(formattedMessage)
        }

        if (!TIMESTAMP_FLAGS.contains(timestamp)) {
            val formattedMessage = LoggingUtil.formatMessage(MESSAGE_INVALID_TIMESTAMP_INDEX, timestamp)
            logger.error(formattedMessage)
            throw InvalidUseException(formattedMessage)
        }

        val percentage = Integer.parseInt(boundary)
        if (percentage < 1 || percentage > 100) {
            val formattedMessage = LoggingUtil.formatMessage(MESSAGE_INVALID_BOUNDARY_INDEX, boundary)
            logger.error(formattedMessage)
            throw InvalidUseException(formattedMessage)
        }

        // Fetch the tasks from the extraction utility...
        val flowTask = ConstantExtractionUtil.extractFlowTask(flow)
        val branchTask = ConstantExtractionUtil.extractBranchTask(branch)
        val resourceTask = ConstantExtractionUtil.extractResourceTask(resource)
        val fromExtension = selectedExtensions[extensionFromIndex]
        val toExtension = selectedExtensions[extensionToIndex]

        // Present the application's execution and ask for input...
        logger.info(MESSAGE_PROCESSING_TASK, flowTask, branchTask, resourceTask, boundary, path)
        logger.info(
            MESSAGE_PROCESSING_ATTRIBUTES,
            fromExtension.substring(1), toExtension.substring(1), leftYAxis, leftXAxis, timestamp
        )
    }
}
