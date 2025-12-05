package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.ConstantExtractionUtil
import org.hellstrand.renfikt.constant.Constants.BRANCH_FLAGS
import org.hellstrand.renfikt.constant.Constants.BRANCH_INDEX
import org.hellstrand.renfikt.constant.Constants.FLOW_FLAGS
import org.hellstrand.renfikt.constant.Constants.FLOW_INDEX
import org.hellstrand.renfikt.constant.Constants.HELP_FLAGS
import org.hellstrand.renfikt.constant.Constants.MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_BRANCH_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_INVALID_FLOW_INDEX
import org.hellstrand.renfikt.constant.Constants.MESSAGE_PROCESSING_TASK
import org.hellstrand.renfikt.constant.HelpGuideUtil.displayHelpGuide
import org.hellstrand.renfikt.constant.LoggingUtil.formatMessage
import org.hellstrand.renfikt.exception.DisplayHelpGuideException
import org.hellstrand.renfikt.exception.InvalidUseException
import org.slf4j.LoggerFactory

/**
 * @author (Mats Richard Hellstrand)
 * @version (5th of December, 2025)
 */
object RenfiUtility {
    private val logger = LoggerFactory.getLogger(RenfiUtility::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 2 || HELP_FLAGS.contains(args[0])) {
            displayHelpGuide()
            throw DisplayHelpGuideException(MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION)
        }

        // Fetch the application's arguments...
        val flow = args[FLOW_INDEX]
        val branch = args[BRANCH_INDEX]

        // Evaluate the application's arguments...
        if (!FLOW_FLAGS.contains(flow)) {
            logger.error(MESSAGE_INVALID_FLOW_INDEX, flow)
            throw InvalidUseException(formatMessage(MESSAGE_INVALID_FLOW_INDEX, flow))
        }

        if (!BRANCH_FLAGS.contains(branch)) {
            logger.error(MESSAGE_INVALID_BRANCH_INDEX, branch)
            throw InvalidUseException(formatMessage(MESSAGE_INVALID_BRANCH_INDEX, branch))
        }

        // Fetch the tasks from the extraction utility...
        val flowTask = ConstantExtractionUtil.extractFlowTask(flow)
        val branchTask = ConstantExtractionUtil.extractBranchTask(branch)

        // Present the application's execution and ask for input...
        logger.info(MESSAGE_PROCESSING_TASK, flowTask, branchTask)
    }
}
