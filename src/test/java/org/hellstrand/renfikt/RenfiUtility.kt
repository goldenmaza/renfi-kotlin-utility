package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.Constants.COMPARE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.Constants.JAVA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.MESSAGE_DISPLAY_HELP_GUIDE_EXCEPTION
import org.hellstrand.renfikt.constant.ConstantsTest.ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED
import org.hellstrand.renfikt.constant.ConstantsTest.ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_BRANCH_INDEX
import org.hellstrand.renfikt.constant.ConstantsTest.ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_FLOW_INDEX
import org.hellstrand.renfikt.constant.ConstantsTest.HYPHEN_HELP_FLAG
import org.hellstrand.renfikt.constant.ConstantsTest.INVALID_HYPHEN_FLAG
import org.hellstrand.renfikt.exception.DisplayHelpGuideException
import org.hellstrand.renfikt.exception.InvalidUseException
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

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
        val args = arrayOf(INVALID_HYPHEN_FLAG, INVALID_HYPHEN_FLAG)

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
        val args = arrayOf(FILE_PROCESSING, INVALID_HYPHEN_FLAG)

        // Execute
        val executable = Executable { RenfiUtility.main(args) }

        // Assert
        val exception = assertThrows(InvalidUseException::class.java, executable)
        assertEquals(ASSERT_FORMAT_MESSAGE_FUNCTION_TEST_INVALID_BRANCH_INDEX, exception.message)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the FLOW argument (FileProcessing) and act accordingly when it is used correctly")
    fun mainMethodEntryTest_ValidFlowAndBranchArguments_DisplayFileProcessingLogging() {
        // Prepare
        val args = arrayOf(FILE_PROCESSING, COMPARE_PROCESSING)

        // Execute
        RenfiUtility.main(args)

        // Assert
        assertTrue(true, ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED)
    }

    @Test
    @DisplayName("Verifying that the main method fetches the FLOW argument (DataProcessing) and act accordingly when it is used correctly")
    fun mainMethodEntryTest_ValidFlowAndBranchArguments_DisplayDataProcessingLogging() {
        // Prepare
        val args = arrayOf(DATA_PROCESSING, JAVA_PROCESSING)

        // Execute
        RenfiUtility.main(args)

        // Assert
        assertTrue(true, ASSERT_ALLOWED_ARGUMENT_IS_USED_AND_LOGGED)
    }
}
