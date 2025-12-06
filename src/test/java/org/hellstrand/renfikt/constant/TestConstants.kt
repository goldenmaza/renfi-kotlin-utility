package org.hellstrand.renfikt.constant

/**
 * @author (Mats Richard Hellstrand)
 * @version (6th of December, 2025)
 */
object TestConstants {
    // Application flags for handling files...
    const val DEFAULT_INDEX = "0"
    const val HYPHEN_HELP_FLAG = "-h"
    const val INVALID_HYPHEN_FLAG = "-x"
    const val INVALID_RESOURCES_DIRECTORY_PATH = "/src/main/resXurces"
    const val VALID_RESOURCES_DIRECTORY_PATH = "/src/main/resources"

    // Logging variables...
    const val ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED = "Displaying that the allowed flag has been fetched and logged from their respective index"
    const val ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_FLOW_INDEX = "Invalid use of application where the FLOW flag is either misspelled or missing: -x"
    const val ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_BRANCH_INDEX = "Invalid use of application where the BRANCH flag is either misspelled or missing: -x"
    const val ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_RESOURCE_INDEX = "Invalid use of application where the RESOURCE flag is either misspelled or missing: -x"
    const val ASSERT_PROJECT_DIRECTORY_UNAVAILABLE = "No project directory was found with the stated path: {}"
    const val ASSERT_MESSAGE_INVALID_EXTENSION_RANGES = "Invalid use of application where the EXTENSIONS are either missing or out of bounds: {} & {}"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETER = "Asserting that the formatMessage function is working as expected with a single template and parameter: {}"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETERS = "Asserting that the formatMessage function is working as expected with a single template and multiple parameters: {} {}"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_AND_PARAMETER = "Asserting that the formatMessage function is working as expected with a single template and parameter: -f"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_AND_PARAMETERS = "Asserting that the formatMessage function is working as expected with a single template and multiple parameters: -f -d"
    const val ASSERT_EXPECTED_PATH_TO_FAILURE = "Asserting that the validateTarget function is working as expected with an invalid path"
    const val ASSERT_EXPECTED_PATH_TO_SUCCESS = "Asserting that the validateTarget function is working as expected with a valid path"
}
