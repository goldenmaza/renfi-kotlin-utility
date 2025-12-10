package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.Constants.COMPARE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.CROP_PROCESSING
import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.IMAGE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.JAVA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_BRANCH_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_FLOW_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_RESOURCE_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MESSAGE_INVALID_EXTENSION_RANGES
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MESSAGE_INVALID_LEFT_AXES
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_PROJECT_DIRECTORY_UNAVAILABLE
import org.hellstrand.renfikt.constant.TestConstants.DEFAULT_INDEX
import org.hellstrand.renfikt.constant.TestConstants.HYPHEN_HELP_FLAG
import org.hellstrand.renfikt.constant.TestConstants.INVALID_HYPHEN_FLAG
import org.hellstrand.renfikt.constant.TestConstants.INVALID_RESOURCES_DIRECTORY_PATH
import org.hellstrand.renfikt.constant.TestConstants.VALID_RESOURCES_DIRECTORY_PATH
import org.hellstrand.renfikt.exception.DirectoryUnavailableException
import org.hellstrand.renfikt.exception.DisplayHelpGuideException
import org.hellstrand.renfikt.exception.InvalidUseException
import org.hellstrand.renfikt.util.LoggingUtil.formatMessage
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.nio.file.Paths

class RenfiUtilityTest {
    @Test
    @DisplayName("Verifying that the main method displays the HelpGuide AND throws DisplayHelpGuideException successfully when providing no arguments")
    fun mainMethodEntryTest_NoArguments_DisplayTheHelpGuideAndThrowDisplayHelpGuideException() {
        // Prepare
        val args = arrayOf<String>()

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(DisplayHelpGuideException::class.java, executable)
        assertEquals(MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method displays the HelpGuide AND throws DisplayHelpGuideException successfully when providing a help flag")
    fun mainMethodEntryTest_HelpFlagArgument_DisplayTheHelpGuideAndThrowDisplayHelpGuideException() {
        // Prepare
        val args = arrayOf(HYPHEN_HELP_FLAG)

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(DisplayHelpGuideException::class.java, executable)
        assertEquals(MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the FLOW argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidFlowFlagArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = arrayOf(
            INVALID_HYPHEN_FLAG, INVALID_HYPHEN_FLAG, INVALID_HYPHEN_FLAG, INVALID_RESOURCES_DIRECTORY_PATH,
            DEFAULT_INDEX, DEFAULT_INDEX, DEFAULT_INDEX, DEFAULT_INDEX
        )

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_FLOW_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the BRANCH argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidBranchFlagArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = arrayOf(
            FILE_PROCESSING, INVALID_HYPHEN_FLAG, INVALID_HYPHEN_FLAG, INVALID_RESOURCES_DIRECTORY_PATH,
            DEFAULT_INDEX, DEFAULT_INDEX, DEFAULT_INDEX, DEFAULT_INDEX
        )

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_BRANCH_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the RESOURCE argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidResourceFlagArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = arrayOf(
            FILE_PROCESSING, COMPARE_PROCESSING, INVALID_HYPHEN_FLAG, INVALID_RESOURCES_DIRECTORY_PATH,
            DEFAULT_INDEX, DEFAULT_INDEX, DEFAULT_INDEX, DEFAULT_INDEX
        )

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_RESOURCE_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates a directory path and act accordingly when it is invalid")
    fun mainMethodEntryTest_InvalidDirectoryPath_LogErrorAndThrowDirectoryUnavailableException() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val invalidDirectoryPath = Paths.get(projectAbsolutePath, INVALID_RESOURCES_DIRECTORY_PATH).toString()
        val args = arrayOf(
            FILE_PROCESSING, COMPARE_PROCESSING, IMAGE_PROCESSING, invalidDirectoryPath,
            DEFAULT_INDEX, DEFAULT_INDEX, DEFAULT_INDEX, DEFAULT_INDEX
        )

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(DirectoryUnavailableException::class.java, executable)
        assertEquals(formatMessage(ASSERT_PROJECT_DIRECTORY_UNAVAILABLE, invalidDirectoryPath), exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates the fromIndex argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidFromIndexArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val validDirectoryPath = Paths.get(projectAbsolutePath, VALID_RESOURCES_DIRECTORY_PATH).toString()
        val fromIndex = "-5"
        val toIndex = "3"
        val leftYAxis = "0"
        val leftXAxis = "0"
        val args = arrayOf(
            FILE_PROCESSING, COMPARE_PROCESSING, IMAGE_PROCESSING, validDirectoryPath,
            fromIndex, toIndex, leftYAxis, leftXAxis
        )

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(formatMessage(ASSERT_MESSAGE_INVALID_EXTENSION_RANGES, fromIndex, toIndex), exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates the toIndex argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidToIndexArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val validDirectoryPath = Paths.get(projectAbsolutePath, VALID_RESOURCES_DIRECTORY_PATH).toString()
        val fromIndex = "0"
        val toIndex = "5"
        val leftYAxis = "0"
        val leftXAxis = "0"
        val args = arrayOf(
            FILE_PROCESSING, COMPARE_PROCESSING, IMAGE_PROCESSING, validDirectoryPath,
            fromIndex, toIndex, leftYAxis, leftXAxis
        )

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(formatMessage(ASSERT_MESSAGE_INVALID_EXTENSION_RANGES, fromIndex, toIndex), exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates the upper left Y axis argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidUpperLeftYAxis_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val validDirectoryPath = Paths.get(projectAbsolutePath, VALID_RESOURCES_DIRECTORY_PATH).toString()
        val fromIndex = "0"
        val toIndex = "3"
        val leftYAxis = "-1"
        val leftXAxis = "13"
        val args = arrayOf(
            FILE_PROCESSING, CROP_PROCESSING, IMAGE_PROCESSING, validDirectoryPath,
            fromIndex, toIndex, leftYAxis, leftXAxis
        )

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(formatMessage(ASSERT_MESSAGE_INVALID_LEFT_AXES, leftYAxis, leftXAxis), exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates the upper left X axis argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidUpperLeftXAxis_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val validDirectoryPath = Paths.get(projectAbsolutePath, VALID_RESOURCES_DIRECTORY_PATH).toString()
        val fromIndex = "0"
        val toIndex = "3"
        val leftYAxis = "13"
        val leftXAxis = "-1"
        val args = arrayOf(
            FILE_PROCESSING, CROP_PROCESSING, IMAGE_PROCESSING, validDirectoryPath,
            fromIndex, toIndex, leftYAxis, leftXAxis
        )

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(formatMessage(ASSERT_MESSAGE_INVALID_LEFT_AXES, leftYAxis, leftXAxis), exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the FLOW argument (FileProcessing) and act accordingly when it is used correctly")
    fun mainMethodEntryTest_ValidFlowAndBranchAndResourceArguments_DisplayFileProcessingLogging() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val validDirectoryPath = Paths.get(projectAbsolutePath, VALID_RESOURCES_DIRECTORY_PATH).toString()
        val fromIndex = "0"
        val toIndex = "3"
        val leftYAxis = "0"
        val leftXAxis = "0"
        val args = arrayOf(
            FILE_PROCESSING, COMPARE_PROCESSING, IMAGE_PROCESSING, validDirectoryPath,
            fromIndex, toIndex, leftYAxis, leftXAxis
        )

        // Execute
        RenfiUtility.main(args)

        // Assert
        assertTrue(true, ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the FLOW argument (DataProcessing) and act accordingly when it is used correctly")
    fun mainMethodEntryTest_ValidFlowAndBranchAndResourceArguments_DisplayDataProcessingLogging() {
        // Prepare
        val projectAbsolutePath = Paths.get("").toAbsolutePath().toString()
        val validDirectoryPath = Paths.get(projectAbsolutePath, VALID_RESOURCES_DIRECTORY_PATH).toString()
        val fromIndex = "0"
        val toIndex = "3"
        val leftYAxis = "0"
        val leftXAxis = "0"
        val args = arrayOf(
            DATA_PROCESSING, JAVA_PROCESSING, IMAGE_PROCESSING, validDirectoryPath,
            fromIndex, toIndex, leftYAxis, leftXAxis
        )

        // Execute
        RenfiUtility.main(args)

        // Assert
        assertTrue(true, ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED)
    }
}
