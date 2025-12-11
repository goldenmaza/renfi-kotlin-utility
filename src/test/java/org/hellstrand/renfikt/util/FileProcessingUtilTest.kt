package org.hellstrand.renfikt.util

import org.hellstrand.renfikt.constant.TestConstants.ASSERT_EXPECTED_PATH_TO_FAILURE
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_EXPECTED_PATH_TO_SUCCESS
import org.hellstrand.renfikt.mock.RenfiUtilityMock.INVALID_DIRECTORY_PATH
import org.hellstrand.renfikt.mock.RenfiUtilityMock.VALID_DIRECTORY_PATH
import org.hellstrand.renfikt.util.FileProcessingUtil.validateTarget
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author (Mats Richard Hellstrand)
 * @version (15th of December, 2025)
 */
class FileProcessingUtilTest {
    @Test
    @DisplayName("Verifying that the validateTarget validates the provided directory and act accordingly when it is used incorrectly")
    fun validateTargetTest_InvalidTargetDirectoryPath_LogDirectoryFoundFailure() {
        // Execute & Assert
        assertFalse(validateTarget(INVALID_DIRECTORY_PATH), ASSERT_EXPECTED_PATH_TO_FAILURE)
    }

    @Test
    @DisplayName("Verifying that the validateTarget validates the provided directory and act accordingly when it is used correctly")
    fun validateTargetTest_ValidTargetDirectoryPath_LogDirectoryFoundSuccess() {
        // Execute & Assert
        assertTrue(validateTarget(VALID_DIRECTORY_PATH), ASSERT_EXPECTED_PATH_TO_SUCCESS)
    }
}
