package org.hellstrand.renfikt.util

import org.hellstrand.renfikt.constant.Constants.COMPARE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.CONVERT_PROCESSING
import org.hellstrand.renfikt.constant.Constants.CROP_PROCESSING
import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.DETECT_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.IMAGE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.JAVA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_COMPARE
import org.hellstrand.renfikt.constant.Constants.LABEL_CONVERT
import org.hellstrand.renfikt.constant.Constants.LABEL_CROP
import org.hellstrand.renfikt.constant.Constants.LABEL_DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_DETECT
import org.hellstrand.renfikt.constant.Constants.LABEL_FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_IMAGES
import org.hellstrand.renfikt.constant.Constants.LABEL_JAVA
import org.hellstrand.renfikt.constant.Constants.LABEL_LIST
import org.hellstrand.renfikt.constant.Constants.LABEL_ORIGIN
import org.hellstrand.renfikt.constant.Constants.LABEL_SOURCE
import org.hellstrand.renfikt.constant.Constants.LABEL_UNKNOWN_EXECUTION
import org.hellstrand.renfikt.constant.Constants.LABEL_VIDEOS
import org.hellstrand.renfikt.constant.Constants.LIST_PROCESSING
import org.hellstrand.renfikt.constant.Constants.ORIGIN_PROCESSING
import org.hellstrand.renfikt.constant.Constants.SOURCE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.VIDEO_PROCESSING
import org.hellstrand.renfikt.constant.TestConstants.INVALID_HYPHEN_FLAG
import org.hellstrand.renfikt.util.ConstantExtractionUtil.extractBranchTask
import org.hellstrand.renfikt.util.ConstantExtractionUtil.extractFlowTask
import org.hellstrand.renfikt.util.ConstantExtractionUtil.extractResourceTask
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConstantExtractionUtilTest {
    @Test
    @DisplayName("Verifying that the extractFlowTask function works as expected, meaning unlisted flag will return 'UnknownProcessingLabel'")
    fun extractFlowTaskFunctionTest_UnlistedFlagReturnsUnknownProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_UNKNOWN_EXECUTION, extractFlowTask(INVALID_HYPHEN_FLAG))
    }

    @Test
    @DisplayName("Verifying that the extractFlowTask function works as expected, meaning 'FileProcessing' flag will return 'FileProcessingLabel'")
    fun extractFlowTaskFunctionTest_FileProcessingFlagReturnsFileProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_FILE_PROCESSING, extractFlowTask(FILE_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractFlowTask function works as expected, meaning 'DataProcessing' flag will return 'DataProcessingLabel'")
    fun extractFlowTaskFunctionTest_DataProcessingFlagReturnsDataProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_DATA_PROCESSING, extractFlowTask(DATA_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning unlisted flag will return 'UnknownProcessingLabel'")
    fun extractBranchTaskFunctionTest_UnlistedFlagReturnsUnknownProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_UNKNOWN_EXECUTION, extractBranchTask(INVALID_HYPHEN_FLAG))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning 'CompareProcessing' flag will return 'CompareLabel'")
    fun extractBranchTaskFunctionTest_CompareProcessingFlagReturnsCompareProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_COMPARE, extractBranchTask(COMPARE_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning 'CropProcessing' flag will return 'CropLabel'")
    fun extractBranchTaskFunctionTest_CropProcessingFlagReturnsCropProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_CROP, extractBranchTask(CROP_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning 'ConvertProcessing' flag will return 'ConvertLabel'")
    fun extractBranchTaskFunctionTest_ConvertProcessingFlagReturnsConvertProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_CONVERT, extractBranchTask(CONVERT_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning 'DetectProcessing' flag will return 'DetectLabel'")
    fun extractBranchTaskFunctionTest_DetectProcessingFlagReturnsDetectProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_DETECT, extractBranchTask(DETECT_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning 'SourceProcessing' flag will return 'SourceLabel'")
    fun extractBranchTaskFunctionTest_SourceProcessingFlagReturnsSourceProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_SOURCE, extractBranchTask(SOURCE_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning 'JavaProcessing' flag will return 'JavaLabel'")
    fun extractBranchTaskFunctionTest_JavaProcessingFlagReturnsJavaProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_JAVA, extractBranchTask(JAVA_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning 'OriginProcessing' flag will return 'OriginLabel'")
    fun extractBranchTaskFunctionTest_OriginProcessingFlagReturnsOriginProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_ORIGIN, extractBranchTask(ORIGIN_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractBranchTask function works as expected, meaning 'ListProcessing' flag will return 'ListLabel'")
    fun extractBranchTaskFunctionTest_ListProcessingFlagReturnsListProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_LIST, extractBranchTask(LIST_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractResourceTask function works as expected, meaning unlisted flag will return 'UnknownProcessingLabel'")
    fun extractResourceTaskFunctionTest_UnlistedFlagReturnsUnknownProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_UNKNOWN_EXECUTION, extractResourceTask(INVALID_HYPHEN_FLAG))
    }

    @Test
    @DisplayName("Verifying that the extractResourceTask function works as expected, meaning 'ImageProcessing' flag will return 'ImagesLabel'")
    fun extractResourceTaskFunctionTest_ImageProcessingFlagReturnsImageProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_IMAGES, extractResourceTask(IMAGE_PROCESSING))
    }

    @Test
    @DisplayName("Verifying that the extractResourceTask function works as expected, meaning 'VideoProcessing' flag will return 'VideosLabel'")
    fun extractResourceTaskFunctionTest_VideoProcessingFlagReturnsVideoProcessingLabel() {
        // Execute & Assert
        assertEquals(LABEL_VIDEOS, extractResourceTask(VIDEO_PROCESSING))
    }
}
