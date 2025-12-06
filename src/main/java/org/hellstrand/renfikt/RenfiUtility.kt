package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.Constants.BRANCH_FLAGS
import org.hellstrand.renfikt.constant.Constants.BRANCH_INDEX
import org.hellstrand.renfikt.constant.Constants.FLOW_FLAGS
import org.hellstrand.renfikt.constant.Constants.FLOW_INDEX
import org.hellstrand.renfikt.constant.Constants.HELP_FLAGS
import org.hellstrand.renfikt.constant.Constants.MEDIA_SUPPORT
import org.hellstrand.renfikt.constant.Constants.MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_BRANCH_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_FLOW_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_RESOURCE_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_PROCESSING_TASK
import org.hellstrand.renfikt.constant.Constants.RESOURCE_INDEX
import org.hellstrand.renfikt.exception.DisplayHelpGuideException
import org.hellstrand.renfikt.exception.InvalidUseException
import org.hellstrand.renfikt.util.ConstantExtractionUtil
import org.hellstrand.renfikt.util.HelpGuideUtil.displayHelpGuide
import org.hellstrand.renfikt.util.LoggingUtil.formatMessage
import org.slf4j.LoggerFactory

/**
 * @author (Mats Richard Hellstrand)
 * @version (6th of December, 2025)
 */
object RenfiUtility {
    private val logger = LoggerFactory.getLogger(RenfiUtility::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 3 || HELP_FLAGS.contains(args[0])) {
            displayHelpGuide()
            throw DisplayHelpGuideException(MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION)
        }

        // Fetch the application's arguments...
        val flow = args[FLOW_INDEX]
        val branch = args[BRANCH_INDEX]
        val resource = args[RESOURCE_INDEX]

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

        // Fetch the tasks from the extraction utility...
        val flowTask = ConstantExtractionUtil.extractFlowTask(flow)
        val branchTask = ConstantExtractionUtil.extractBranchTask(branch)
        val resourceTask = ConstantExtractionUtil.extractResourceTask(resource)

        // Present the application's execution and ask for input...
        logger.info(MESSAGE_PROCESSING_TASK, flowTask, branchTask, resourceTask)
    }
}
