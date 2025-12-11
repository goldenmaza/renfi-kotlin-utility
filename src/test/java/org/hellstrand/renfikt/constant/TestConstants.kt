package org.hellstrand.renfikt.constant

/**
 * @author (Mats Richard Hellstrand)
 * @version (11th of December, 2025)
 */
object TestConstants {
    // Application flags for handling files...
    const val DEFAULT_INTEGER_VALUE = "0"
    const val IRRELEVANT_NEGATIVE_INTEGER_VALUE = "-3"
    const val IRRELEVANT_POSITIVE_INTEGER_VALUE = "3"
    const val INVALID_NEGATIVE_INDEX_VALUE = "-5"
    const val INVALID_POSITIVE_INDEX_VALUE = "13"
    const val MAX_INTEGER_VALUE = "100"
    const val HYPHEN_HELP_FLAG = "-h"
    const val INVALID_HYPHEN_FLAG = "-x"
    const val IRRELEVANT_HYPHEN_FLAG = "-y"
    const val INVALID_RESOURCES_PATH_SUFFIX = "/src/main/resXurces"
    const val VALID_RESOURCES_PATH_SUFFIX = "/src/main/resources"

    // Logging variables...
    const val ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED = "Displaying that the allowed flag has been fetched and logged from their respective index"
    const val ASSERT_MAIN_METHOD_INVALID_FLOW_INDEX = "Invalid use of the application where the FLOW flag is either misspelled or missing: -x"
    const val ASSERT_MAIN_METHOD_INVALID_BRANCH_INDEX = "Invalid use of the application where the BRANCH flag is either misspelled or missing: -x"
    const val ASSERT_MAIN_METHOD_INVALID_RESOURCE_INDEX = "Invalid use of the application where the RESOURCE flag is either misspelled or missing: -x"
    const val ASSERT_MAIN_METHOD_INVALID_PROJECT_DIRECTORY = "Invalid use of the application where the project directory was NOT found with the stated path: /src/main/resXurces"
    const val ASSERT_MAIN_METHOD_INVALID_FROM_EXTENSION_INDEX = "Invalid use of the application where at least one of the EXTENSIONS are either missing or invalid: -5 & 3"
    const val ASSERT_MAIN_METHOD_INVALID_TO_EXTENSION_INDEX = "Invalid use of the application where at least one of the EXTENSIONS are either missing or invalid: 0 & 13"
    const val ASSERT_MAIN_METHOD_INVALID_Y_AXIS_INDEX = "Invalid use of the application where at least one of the AXES are either missing or invalid: -5 & 3"
    const val ASSERT_MAIN_METHOD_INVALID_X_AXIS_INDEX = "Invalid use of the application where at least one of the AXES are either missing or invalid: 0 & -5"
    const val ASSERT_MAIN_METHOD_INVALID_TIMESTAMP_INDEX = "Invalid use of the application where the TIMESTAMP flag is either misspelled or missing: -x"
    const val ASSERT_MAIN_METHOD_INVALID_BOUNDARY_INDEX = "Invalid use of the application where the BOUNDARY flag is either misspelled or missing: -3"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETER = "Asserting that the formatMessage function is working as expected with a single template and parameter: {}"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETERS = "Asserting that the formatMessage function is working as expected with a single template and multiple parameters: {} {}"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_WITH_PARAMETER = "Asserting that the formatMessage function is working as expected with a single template and parameter: -f"
    const val ASSERT_FORMAT_MESSAGE_TEMPLATE_WITH_PARAMETERS = "Asserting that the formatMessage function is working as expected with a single template and multiple parameters: -f -d"
    const val ASSERT_EXPECTED_PATH_TO_FAILURE = "Asserting that the validateTarget function is working as expected with an invalid path"
    const val ASSERT_EXPECTED_PATH_TO_SUCCESS = "Asserting that the validateTarget function is working as expected with a valid path"
}
