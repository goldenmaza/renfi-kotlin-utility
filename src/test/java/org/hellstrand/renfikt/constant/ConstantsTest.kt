package org.hellstrand.renfikt.constant

/**
 * @author (Mats Richard Hellstrand)
 * @version (6th of December, 2025)
 */
object ConstantsTest {
    // Application flags for handling files...
    const val HYPHEN_HELP_FLAG = "-h"
    const val INVALID_HYPHEN_FLAG = "-x"

    // Logging variables...
    const val ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED = "Displaying that the allowed flag has been fetched and logged from their respective index"
    const val ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_FLOW_INDEX = "Invalid use of application where the FLOW flag is either misspelled or missing: -x"
    const val ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_BRANCH_INDEX = "Invalid use of application where the BRANCH flag is either misspelled or missing: -x"
    const val ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_RESOURCE_INDEX = "Invalid use of application where the RESOURCE flag is either misspelled or missing: -x"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETER = "Asserting that the formatMessage function is working as expected with a single template and parameter: {}"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETERS = "Asserting that the formatMessage function is working as expected with a single template and multiple parameters: {} {}"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_AND_PARAMETER = "Asserting that the formatMessage function is working as expected with a single template and parameter: -f"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_AND_PARAMETERS = "Asserting that the formatMessage function is working as expected with a single template and multiple parameters: -f -d"
}
