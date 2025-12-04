package org.hellstrand.renfikt.constant

/**
 * @author (Mats Richard Hellstrand)
 * @version (4th of December, 2025)
 */
object Constants {
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
    val TYPE_FLAGS = listOf(
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
    const val EXTENSION_MPG = ".mpg";//java+7 only
    const val EXTENSION_WMV = ".wmv";//java+7 only
    const val EXTENSION_MKV = ".mkv";//java+7 only
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

    // Message variables used for displaying states, or actions, in the application...
    const val MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION = "Displaying the Help Guide as you might have used the application incorrectly";
}
