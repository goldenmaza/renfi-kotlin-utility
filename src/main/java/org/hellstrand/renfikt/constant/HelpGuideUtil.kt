package org.hellstrand.renfikt.constant

import org.hellstrand.renfikt.constant.Constants.BRANCH_FLAGS
import org.hellstrand.renfikt.constant.Constants.COMPARE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.CONVERT_PROCESSING
import org.hellstrand.renfikt.constant.Constants.CREATION_TIME_FLAG
import org.hellstrand.renfikt.constant.Constants.CROP_PROCESSING
import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.DETECT_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FLOW_FLAGS
import org.hellstrand.renfikt.constant.Constants.HELP_FLAGS
import org.hellstrand.renfikt.constant.Constants.IMAGE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.JAVA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LAST_ACCESS_TIME_FLAG
import org.hellstrand.renfikt.constant.Constants.LAST_MODIFIED_TIME_FLAG
import org.hellstrand.renfikt.constant.Constants.LIST_PROCESSING
import org.hellstrand.renfikt.constant.Constants.MEDIA_SUPPORT
import org.hellstrand.renfikt.constant.Constants.ORIGIN_PROCESSING
import org.hellstrand.renfikt.constant.Constants.RESOURCE_FLAGS
import org.hellstrand.renfikt.constant.Constants.SOURCE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.TYPE_FLAGS
import org.hellstrand.renfikt.constant.Constants.VIDEO_PROCESSING
import org.slf4j.LoggerFactory

/**
 * @author (Mats Richard Hellstrand)
 * @version (4th of December, 2025)
 */
object HelpGuideUtil {
    private val logger = LoggerFactory.getLogger(HelpGuideUtil::class.java)

    fun displayHelpGuide() {
        val imageExtensions = MEDIA_SUPPORT[IMAGE_PROCESSING]
        val videoExtensions = MEDIA_SUPPORT[VIDEO_PROCESSING]
        val helpFlags = HELP_FLAGS.toString()
            .removePrefix("[")
            .removeSuffix("]")

        val guideToDisplay = """


            === The RenfiKT's Help Guide ===

            Operational overview:
            =====================

            java -jar RenfiKT.jar <FLOW> <BRANCH> <RESOURCE_TYPE> <PATH> <FROM_EXTENSION> <TO_EXTENSION> <X_AXIS> <Y_AXIS> <DATE_TYPE> <BOUNDARY>

            (FLOW)				The desired flow of the application: {}
            (BRANCH)			The desired branch of the application: {}
            (PATH)				The directory path to where the files are located, e.g. "c:/directory/" OR "c/directory/"
            (RESOURCE_TYPE)		To focus on either resource type: {}
            (FROM_EXTENSION)	The desired file extension based on index (INTEGER). (view 'Extension legend' below)
            (TO_EXTENSION)		The desired file extension based on index (INTEGER). (view 'Extension legend' below)
            (X_AXIS)			The starting pixel on the X axis (INTEGER).
            (Y_AXIS)			The starting pixel on the Y axis (INTEGER).
            (DATE_TYPE)			The desired date type flag from file: {}
            (BOUNDARY)			The desired boundary value ranging from 1 to 100, e.g. between 1 (inclusive) and 100 percent (inclusive).


            Extension legend:
            =================

            (IMAGE)				The supported extensions and their indexes: {}
            (VIDEO)				The supported extensions and their indexes *: {}
                                * Not ALL video formats are supported by Drew Noakes's extractor, some might need Java +7 (nio) to fetch date...

            Flag legend:
            ============

            ({})				To process IMAGE files based on extension stated.
            ({})				To process VIDEO files based on extension stated.

            ({})				The File processing flow lets us manipulate the file itself or to analyze it. You can choose one of the following branches:
            ({})				To compare files, pixel by pixel, to determine if they are a duplicate or a close match.
            ({})				To crop images, based on X & Y coordinates, this will remove the borders on both sides of the image.
            ({})				To convert images from one extension to another.
            ({})				To detect black borders and to sort them into folders based on detected height. Note: Currently, only top-down is supported!
            ({})				To prepare a SOURCE FILE based on directory files.

            ({})				The Data processing flow lets us create a source file or determine date and time. You can choose one of the following branches:
            ({})				To use Java +7 (nio) to determine the date of creation.
            ({})				To prepare history conversion based on ORIGIN DATA by using Drew Noakes's extractor.
            ({})				To prepare history conversion based on SOURCE FILE.

            ({})				To use the Creation Time field for setting the date and time.
            ({})				To use the Last Modified Time field for setting the date and time.
            ({})				To use the Last Access Time field for setting the date and time.

            ({})         To display this help guide.
        """.trimIndent()

        logger.info(
            guideToDisplay,
            FLOW_FLAGS, BRANCH_FLAGS, RESOURCE_FLAGS, TYPE_FLAGS,
            prepareMediaExtensions(imageExtensions), prepareMediaExtensions(videoExtensions),
            IMAGE_PROCESSING, VIDEO_PROCESSING,
            FILE_PROCESSING, COMPARE_PROCESSING, CROP_PROCESSING, CONVERT_PROCESSING, DETECT_PROCESSING, SOURCE_PROCESSING,
            DATA_PROCESSING, JAVA_PROCESSING, ORIGIN_PROCESSING, LIST_PROCESSING,
            CREATION_TIME_FLAG, LAST_MODIFIED_TIME_FLAG, LAST_ACCESS_TIME_FLAG,
            helpFlags
        )
    }

    private fun prepareMediaExtensions(extensions: List<String>?): String {
        val sb = StringBuilder()

        for (extension in extensions!!) {
            sb.append(extension.substring(1))
                .append(" (")
                .append(extensions.indexOf(extension))
                .append("), ")
        }

        return sb.toString()
    }
}
