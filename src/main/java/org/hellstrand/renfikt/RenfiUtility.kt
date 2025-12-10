package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.Constants.BRANCH_FLAGS
import org.hellstrand.renfikt.constant.Constants.BRANCH_INDEX
import org.hellstrand.renfikt.constant.Constants.FLOW_FLAGS
import org.hellstrand.renfikt.constant.Constants.FLOW_INDEX
import org.hellstrand.renfikt.constant.Constants.FROM_INDEX
import org.hellstrand.renfikt.constant.Constants.HELP_FLAGS
import org.hellstrand.renfikt.constant.Constants.MEDIA_SUPPORT
import org.hellstrand.renfikt.constant.Constants.MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_BRANCH_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_EXTENSION_RANGES
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_FLOW_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_RESOURCE_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_LEFT_AXES
import org.hellstrand.renfikt.constant.Constants.MESSAGE_PROCESSING_ATTRIBUTES
import org.hellstrand.renfikt.constant.Constants.MESSAGE_PROCESSING_TASK
import org.hellstrand.renfikt.constant.Constants.MESSAGE_PROJECT_DIRECTORY_UNAVAILABLE
import org.hellstrand.renfikt.constant.Constants.PATH_INDEX
import org.hellstrand.renfikt.constant.Constants.RESOURCE_INDEX
import org.hellstrand.renfikt.constant.Constants.TO_INDEX
import org.hellstrand.renfikt.constant.Constants.LEFT_X_AXIS
import org.hellstrand.renfikt.constant.Constants.LEFT_Y_AXIS
import org.hellstrand.renfikt.exception.DirectoryUnavailableException
import org.hellstrand.renfikt.exception.DisplayHelpGuideException
import org.hellstrand.renfikt.exception.InvalidUseException
import org.hellstrand.renfikt.util.ConstantExtractionUtil
import org.hellstrand.renfikt.util.FileProcessingUtil.validateTarget
import org.hellstrand.renfikt.util.HelpGuideUtil.displayHelpGuide
import org.hellstrand.renfikt.util.LoggingUtil.formatMessage
import org.slf4j.LoggerFactory

/**
 * @author (Mats Richard Hellstrand)
 * @version (10th of December, 2025)
 */
object RenfiUtility {
    private val logger = LoggerFactory.getLogger(RenfiUtility::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 8 || HELP_FLAGS.contains(args[0])) {
            displayHelpGuide()
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

        // Evaluate the application's arguments...
        if (!FLOW_FLAGS.contains(flow)) {
            logger.error(MESSAGE_INVALID_FLOW_INDEX, flow)
            throw InvalidUseException(formatMessage(MESSAGE_INVALID_FLOW_INDEX, flow))
        }

        if (!BRANCH_FLAGS.contains(branch)) {
            logger.error(MESSAGE_INVALID_BRANCH_INDEX, branch)
            throw InvalidUseException(formatMessage(MESSAGE_INVALID_BRANCH_INDEX, branch))
        }

        if (!MEDIA_SUPPORT.containsKey(resource)) {
            logger.error(MESSAGE_INVALID_RESOURCE_INDEX, resource)
            throw InvalidUseException(formatMessage(MESSAGE_INVALID_RESOURCE_INDEX, resource))
        }

        if (!validateTarget(path)) {
            logger.error(MESSAGE_PROJECT_DIRECTORY_UNAVAILABLE, path)
            throw DirectoryUnavailableException(formatMessage(MESSAGE_PROJECT_DIRECTORY_UNAVAILABLE, path))
        }

        val selectedExtensions = MEDIA_SUPPORT[resource]
        val extensionFromIndex = Integer.parseInt(fromIndex)
        val extensionToIndex = Integer.parseInt(toIndex)
        if (extensionFromIndex < 0 || extensionToIndex >= selectedExtensions!!.size) {
            logger.error(MESSAGE_INVALID_EXTENSION_RANGES, fromIndex, toIndex)
            throw InvalidUseException(formatMessage(MESSAGE_INVALID_EXTENSION_RANGES, fromIndex, toIndex))
        }

        if (Integer.parseInt(leftYAxis) < 0 || Integer.parseInt(leftXAxis) < 0) {
            logger.error(MESSAGE_INVALID_LEFT_AXES, leftYAxis, leftXAxis)
            throw InvalidUseException(formatMessage(MESSAGE_INVALID_LEFT_AXES, leftYAxis, leftXAxis))
        }

        // Fetch the tasks from the extraction utility...
        val flowTask = ConstantExtractionUtil.extractFlowTask(flow)
        val branchTask = ConstantExtractionUtil.extractBranchTask(branch)
        val resourceTask = ConstantExtractionUtil.extractResourceTask(resource)
        val fromExtension = selectedExtensions[extensionFromIndex]
        val toExtension = selectedExtensions[extensionToIndex]

        // Present the application's execution and ask for input...
        logger.info(MESSAGE_PROCESSING_TASK, flowTask, branchTask, resourceTask, path)
        logger.info(
            MESSAGE_PROCESSING_ATTRIBUTES,
            fromExtension.substring(1), toExtension.substring(1), leftYAxis, leftXAxis
        )
    }
}
