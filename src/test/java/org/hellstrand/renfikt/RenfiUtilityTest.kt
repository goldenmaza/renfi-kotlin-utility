package org.hellstrand.renfikt

import io.mockk.verify
import org.hellstrand.renfikt.constant.Constants.MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_BOUNDARY_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_BRANCH_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_FLOW_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_FROM_EXTENSION_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_PROJECT_DIRECTORY
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_RESOURCE_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_TIMESTAMP_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_TO_EXTENSION_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_X_AXIS_INDEX
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_MAIN_METHOD_INVALID_Y_AXIS_INDEX
import org.hellstrand.renfikt.exception.DirectoryUnavailableException
import org.hellstrand.renfikt.exception.DisplayHelpGuideException
import org.hellstrand.renfikt.exception.InvalidUseException
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getDefaultArgumentsForDataAndJavaProcessingOfImages
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getDefaultArgumentsForFileAndCompareProcessingOfImages
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getEmptyArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getHelpArgument
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidBoundaryArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidBranchArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidDirectoryPathArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidFlowArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidFromIndexArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidResourceArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidTimestampArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidToIndexArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidUpperLeftXAxisArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.getInvalidUpperLeftYAxisArguments
import org.hellstrand.renfikt.mock.RenfiUtilityMock.mockUtilObjects
import org.hellstrand.renfikt.mock.RenfiUtilityMock.verifyConstantExtractionUtilWasCalledWithCompareProcessingParameter
import org.hellstrand.renfikt.mock.RenfiUtilityMock.verifyConstantExtractionUtilWasCalledWithDataProcessingParameter
import org.hellstrand.renfikt.mock.RenfiUtilityMock.verifyConstantExtractionUtilWasCalledWithFileProcessingParameter
import org.hellstrand.renfikt.mock.RenfiUtilityMock.verifyConstantExtractionUtilWasCalledWithImageProcessingParameter
import org.hellstrand.renfikt.mock.RenfiUtilityMock.verifyConstantExtractionUtilWasCalledWithJavaProcessingParameter
import org.hellstrand.renfikt.mock.RenfiUtilityMock.verifyFileProcessingUtilWasCalledWithPathParameter
import org.hellstrand.renfikt.mock.RenfiUtilityMock.verifyHelpGuideUtilWasCalledWithoutParameters
import org.hellstrand.renfikt.util.ConstantExtractionUtil
import org.hellstrand.renfikt.util.FileProcessingUtil
import org.hellstrand.renfikt.util.HelpGuideUtil
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

/**
 * @author (Mats Richard Hellstrand)
 * @version (15th of December, 2025)
 */
class RenfiUtilityTest {
    @Test
    @DisplayName("Verifying that the main method displays the HelpGuide AND throws DisplayHelpGuideException successfully when providing no arguments")
    fun mainMethodEntryTest_NoArguments_DisplayTheHelpGuideAndThrowDisplayHelpGuideException() {
        // Prepare
        val args = getEmptyArguments()

        // Expectation
        mockUtilObjects(arrayOf(HelpGuideUtil))

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(DisplayHelpGuideException::class.java, executable)
        verify(exactly = 1) { verifyHelpGuideUtilWasCalledWithoutParameters.invoke() }
        assertEquals(MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method displays the HelpGuide AND throws DisplayHelpGuideException successfully when providing a help flag")
    fun mainMethodEntryTest_HelpFlagArgument_DisplayTheHelpGuideAndThrowDisplayHelpGuideException() {
        // Prepare
        val args = getHelpArgument()

        // Expectation
        mockUtilObjects(arrayOf(HelpGuideUtil))

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(DisplayHelpGuideException::class.java, executable)
        verify(exactly = 1) { verifyHelpGuideUtilWasCalledWithoutParameters.invoke() }
        assertEquals(MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the FLOW argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidFlowFlagArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidFlowArguments()

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(ASSERT_MAIN_METHOD_INVALID_FLOW_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the BRANCH argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidBranchFlagArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidBranchArguments()

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(ASSERT_MAIN_METHOD_INVALID_BRANCH_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the RESOURCE argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidResourceFlagArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidResourceArguments()

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(ASSERT_MAIN_METHOD_INVALID_RESOURCE_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates a directory path and act accordingly when it is invalid")
    fun mainMethodEntryTest_InvalidDirectoryPath_LogErrorAndThrowDirectoryUnavailableException() {
        // Prepare
        val args = getInvalidDirectoryPathArguments()

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(DirectoryUnavailableException::class.java, executable)
        assertEquals(ASSERT_MAIN_METHOD_INVALID_PROJECT_DIRECTORY, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates the fromIndex argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidFromIndexArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidFromIndexArguments()

        // Expectation
        mockUtilObjects(arrayOf(FileProcessingUtil))

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        verify(exactly = 1) { verifyFileProcessingUtilWasCalledWithPathParameter.invoke() }
        assertEquals(ASSERT_MAIN_METHOD_INVALID_FROM_EXTENSION_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates the toIndex argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidToIndexArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidToIndexArguments()

        // Expectation
        mockUtilObjects(arrayOf(FileProcessingUtil))

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        verify(exactly = 1) { verifyFileProcessingUtilWasCalledWithPathParameter.invoke() }
        assertEquals(ASSERT_MAIN_METHOD_INVALID_TO_EXTENSION_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates the upper left Y axis argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidUpperLeftYAxis_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidUpperLeftYAxisArguments()

        // Expectation
        mockUtilObjects(arrayOf(FileProcessingUtil))

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        verify(exactly = 1) { verifyFileProcessingUtilWasCalledWithPathParameter.invoke() }
        assertEquals(ASSERT_MAIN_METHOD_INVALID_Y_AXIS_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method validates the upper left X axis argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidUpperLeftXAxis_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidUpperLeftXAxisArguments()

        // Expectation
        mockUtilObjects(arrayOf(FileProcessingUtil))

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        verify(exactly = 1) { verifyFileProcessingUtilWasCalledWithPathParameter.invoke() }
        assertEquals(ASSERT_MAIN_METHOD_INVALID_X_AXIS_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the TIMESTAMP argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidTimestampFlagArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidTimestampArguments()

        // Expectation
        mockUtilObjects(arrayOf(FileProcessingUtil))

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        verify(exactly = 1) { verifyFileProcessingUtilWasCalledWithPathParameter.invoke() }
        assertEquals(ASSERT_MAIN_METHOD_INVALID_TIMESTAMP_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the BOUNDARY argument and act accordingly when it is used incorrectly")
    fun mainMethodEntryTest_InvalidBoundaryFlagArgument_LogErrorAndThrowInvalidUseException() {
        // Prepare
        val args = getInvalidBoundaryArguments()

        // Expectation
        mockUtilObjects(arrayOf(FileProcessingUtil))

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        verify(exactly = 1) { verifyFileProcessingUtilWasCalledWithPathParameter.invoke() }
        assertEquals(ASSERT_MAIN_METHOD_INVALID_BOUNDARY_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the FLOW argument (FileProcessing) and act accordingly when it is used correctly")
    fun mainMethodEntryTest_ValidArgumentsForFileAndCompareProcessingOfImages_DisplayFileProcessingLogging() {
        // Prepare
        val args = getDefaultArgumentsForFileAndCompareProcessingOfImages()

        // Expectation
        mockUtilObjects(arrayOf(FileProcessingUtil, ConstantExtractionUtil))

        // Execute
        RenfiUtility.main(args)

        // Assert
        verify(exactly = 1) { verifyFileProcessingUtilWasCalledWithPathParameter.invoke() }
        verify(exactly = 1) { verifyConstantExtractionUtilWasCalledWithFileProcessingParameter.invoke() }
        verify(exactly = 1) { verifyConstantExtractionUtilWasCalledWithCompareProcessingParameter.invoke() }
        verify(exactly = 1) { verifyConstantExtractionUtilWasCalledWithImageProcessingParameter.invoke() }
        assertTrue(true, ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the FLOW argument (DataProcessing) and act accordingly when it is used correctly")
    fun mainMethodEntryTest_ValidArgumentsForDataAndJavaProcessingOfImages_DisplayDataProcessingLogging() {
        // Prepare
        val args = getDefaultArgumentsForDataAndJavaProcessingOfImages()

        // Expectation
        mockUtilObjects(arrayOf(FileProcessingUtil, ConstantExtractionUtil))

        // Execute
        RenfiUtility.main(args)

        // Assert
        verify(exactly = 1) { verifyFileProcessingUtilWasCalledWithPathParameter.invoke() }
        verify(exactly = 1) { verifyConstantExtractionUtilWasCalledWithDataProcessingParameter.invoke() }
        verify(exactly = 1) { verifyConstantExtractionUtilWasCalledWithJavaProcessingParameter.invoke() }
        verify(exactly = 1) { verifyConstantExtractionUtilWasCalledWithImageProcessingParameter.invoke() }
        assertTrue(true, ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED)
    }
}
