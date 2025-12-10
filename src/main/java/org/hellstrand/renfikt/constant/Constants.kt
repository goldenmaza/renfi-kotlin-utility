package org.hellstrand.renfikt.constant

/**
 * @author (Mats Richard Hellstrand)
 * @version (11th of December, 2025)
 */
object Constants {
    // Application states, actions, attributes...
    const val FLOW_INDEX = 0
    const val BRANCH_INDEX = 1
    const val RESOURCE_INDEX = 2
    const val PATH_INDEX = 3
    const val FROM_INDEX = 4
    const val TO_INDEX = 5
    const val LEFT_Y_AXIS = 6
    const val LEFT_X_AXIS = 7
    const val TIMESTAMP_INDEX = 8

    // Application flags for handling files...
    const val FILE_PROCESSING = "-f"
    const val DATA_PROCESSING = "-d"
    val FLOW_FLAGS = listOf(
        FILE_PROCESSING,
        DATA_PROCESSING
    )
    const val COMPARE_PROCESSING = "-vs"
    const val CROP_PROCESSING = "-crop"
    const val CONVERT_PROCESSING = "-con"
    const val DETECT_PROCESSING = "-bor"
    const val SOURCE_PROCESSING = "-s"
    const val JAVA_PROCESSING = "-j"
    const val ORIGIN_PROCESSING = "-o"
    const val LIST_PROCESSING = "-l"
    val BRANCH_FLAGS = listOf(
        COMPARE_PROCESSING,
        CROP_PROCESSING,
        CONVERT_PROCESSING,
        DETECT_PROCESSING,
        SOURCE_PROCESSING,
        JAVA_PROCESSING,
        ORIGIN_PROCESSING,
        LIST_PROCESSING
    )
    const val IMAGE_PROCESSING = "-i"
    const val VIDEO_PROCESSING = "-v"
    val RESOURCE_FLAGS = listOf(
        IMAGE_PROCESSING,
        VIDEO_PROCESSING
    )
    const val CREATION_TIME_FLAG = "-ct"
    const val LAST_MODIFIED_TIME_FLAG = "-lmt"
    const val LAST_ACCESS_TIME_FLAG = "-lat"
    val TIMESTAMP_FLAGS = listOf(
        CREATION_TIME_FLAG,
        LAST_MODIFIED_TIME_FLAG,
        LAST_ACCESS_TIME_FLAG
    )
    private const val HYPHEN_HELP_FLAG = "-h"
    private const val HYPHEN_FULL_HELP_FLAG = "-help"
    val HELP_FLAGS = listOf(
        HYPHEN_HELP_FLAG,
        HYPHEN_FULL_HELP_FLAG
    )

    // Filenames and supported extensions for manipulation...
    const val EXTENSION_JPG = ".jpg"
    const val EXTENSION_JPEG = ".jpeg"
    const val EXTENSION_PNG = ".png"
    const val EXTENSION_BMP = ".bmp"
    const val EXTENSION_AVI = ".avi"
    const val EXTENSION_MP4 = ".mp4"
    const val EXTENSION_MOV = ".mov"
    const val EXTENSION_MPG = ".mpg"//java+7 only
    const val EXTENSION_WMV = ".wmv"//java+7 only
    const val EXTENSION_MKV = ".mkv"//java+7 only
    val MEDIA_SUPPORT = mapOf(
        IMAGE_PROCESSING to listOf(
            EXTENSION_JPG,
            EXTENSION_JPEG,
            EXTENSION_PNG,
            EXTENSION_BMP),
        VIDEO_PROCESSING to listOf(
            EXTENSION_AVI,
            EXTENSION_MP4,
            EXTENSION_MOV,
            EXTENSION_MPG,
            EXTENSION_WMV,
            EXTENSION_MKV)
    )

    // Labels used by the application...
    const val LABEL_FILE_PROCESSING = "File handling"
    const val LABEL_COMPARE = "Compare resources"
    const val LABEL_CROP = "Crop resources"
    const val LABEL_CONVERT = "Convert resources"
    const val LABEL_DETECT = "Detect black borders"
    const val LABEL_SOURCE = "Save Filenames"
    const val LABEL_DATA_PROCESSING = "Data handling"
    const val LABEL_JAVA = "Using Java +7"
    const val LABEL_ORIGIN = "Using Drew Noakes's extractor"
    const val LABEL_LIST = "Using a File as resource"
    const val LABEL_IMAGES = "Images"
    const val LABEL_VIDEOS = "Videos"
    const val LABEL_UNKNOWN_EXECUTION = "UNKNOWN"

    // Message variables used for displaying states, or actions, in the application...
    const val MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION = "Displaying the Help Guide as you might have used the application incorrectly"
    const val MESSAGE_INVALID_FLOW_INDEX = "Invalid use of application where the FLOW flag is either misspelled or missing: {}"
    const val MESSAGE_INVALID_BRANCH_INDEX = "Invalid use of application where the BRANCH flag is either misspelled or missing: {}"
    const val MESSAGE_INVALID_RESOURCE_INDEX = "Invalid use of application where the RESOURCE flag is either misspelled or missing: {}"
    const val MESSAGE_PROJECT_DIRECTORY_UNAVAILABLE = "No project directory was found with the stated path: {}"
    const val MESSAGE_INVALID_EXTENSION_RANGES = "Invalid use of application where the EXTENSIONS are either missing or out of bounds: {} & {}"
    const val MESSAGE_INVALID_LEFT_AXES = "Invalid use of application where at least one of the LEFT AXES are either missing or invalid: {} & {}"
    const val MESSAGE_INVALID_TIMESTAMP_INDEX = "Invalid use of application where the TIMESTAMP flag is either misspelled or missing: {}"
    const val MESSAGE_PROCESSING_TASK = "The task you have selected is: '{}' by '{}' of '{}' under the following path: '{}'"
    const val MESSAGE_PROCESSING_ATTRIBUTES = "The following attributes are also selected: '{}' to '{}' format, Y='{}' & X='{}' axes values, and '{}' timestamp flag"
}
