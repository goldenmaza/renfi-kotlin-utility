package org.hellstrand.renfikt.util

import org.hellstrand.renfikt.constant.TestConstants.ASSERT_EXPECTED_PATH_TO_FAILURE
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_EXPECTED_PATH_TO_SUCCESS
import org.hellstrand.renfikt.constant.TestConstants.INVALID_RESOURCES_DIRECTORY_PATH
import org.hellstrand.renfikt.constant.TestConstants.VALID_RESOURCES_DIRECTORY_PATH
import org.hellstrand.renfikt.util.FileProcessingUtil.validateTarget
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.nio.file.Paths

class FileProcessingUtilTest {
    @Test
    @DisplayName("Verifying that the validateTarget validates the provided directory and act accordingly when it is used incorrectly")
    fun validateTargetTest_InvalidTargetDirectoryPath_LogDirectoryFoundFailure() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val invalidDirectoryPath = Paths.get(projectAbsolutePath, INVALID_RESOURCES_DIRECTORY_PATH).toString()

        // Execute & Assert
        assertFalse(validateTarget(invalidDirectoryPath), ASSERT_EXPECTED_PATH_TO_FAILURE)
    }

    @Test
    @DisplayName("Verifying that the validateTarget validates the provided directory and act accordingly when it is used correctly")
    fun validateTargetTest_ValidTargetDirectoryPath_LogDirectoryFoundSuccess() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val validDirectoryPath = Paths.get(projectAbsolutePath, VALID_RESOURCES_DIRECTORY_PATH).toString()

        // Execute & Assert
        assertTrue(validateTarget(validDirectoryPath), ASSERT_EXPECTED_PATH_TO_SUCCESS)
    }
}
