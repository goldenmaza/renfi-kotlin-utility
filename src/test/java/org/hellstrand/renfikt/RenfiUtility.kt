package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.ConstantsTest.DUMMY_ARGUMENT
import org.hellstrand.renfikt.constant.ConstantsTest.HYPHEN_HELP_FLAG
import org.hellstrand.renfikt.constant.ConstantsTest.MESSAGE_PROGRAM_ARGUMENTS_ARE_IGNORED
import org.hellstrand.renfikt.exception.DisplayHelpGuideException
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RenfiUtilityTest {
    @Test
    @DisplayName("Verifying that the main method ends successfully")
    fun mainMethodEntryTest_ProgramArgumentsAreIgnored() {
        // Prepare
        val args = arrayOf(DUMMY_ARGUMENT)

        // Execute
        RenfiUtility.main(args)

        // Assert
        assertTrue(true, MESSAGE_PROGRAM_ARGUMENTS_ARE_IGNORED)
    }

    @Test
    @DisplayName("Verifying that the main method displays the HelpGuide AND throws DisplayHelpGuideException successfully when providing no arguments")
    fun mainMethodEntryTest_NoArguments_DisplayTheHelpGuideAndThrowDisplayHelpGuideException() {
        // Prepare
        val args = arrayOf<String>()

        // Execute & Assert
        assertThrows<DisplayHelpGuideException> { RenfiUtility.main(args) }
    }

    @Test
    @DisplayName("Verifying that the main method displays the HelpGuide AND throws DisplayHelpGuideException successfully when providing a help flag")
    fun mainMethodEntryTest_HyphenHelpFlagArgument_DisplayTheHelpGuideAndThrowDisplayHelpGuideException() {
        // Prepare
        val args = arrayOf(HYPHEN_HELP_FLAG)

        // Execute & Assert
        assertThrows<DisplayHelpGuideException> { RenfiUtility.main(args) }
    }
}
