package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.Constants.HELP_FLAGS
import org.hellstrand.renfikt.constant.Constants.MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION
import org.hellstrand.renfikt.constant.HelpGuideUtil.displayHelpGuide
import org.hellstrand.renfikt.exception.DisplayHelpGuideException

/**
 * @author (Mats Richard Hellstrand)
 * @version (4th of December, 2025)
 */
object RenfiUtility {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 1 || HELP_FLAGS.contains(args[0])) {
            displayHelpGuide()
            throw DisplayHelpGuideException(MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION)
        }
    }
}
