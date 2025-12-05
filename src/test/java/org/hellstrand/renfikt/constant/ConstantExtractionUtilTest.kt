package org.hellstrand.renfikt.constant

import org.hellstrand.renfikt.constant.ConstantExtractionUtil.extractFlowTask
import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.LABEL_UNKNOWN_EXECUTION
import org.hellstrand.renfikt.constant.ConstantsTest.INVALID_HYPHEN_FLAG
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
}
