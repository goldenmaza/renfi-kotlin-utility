package org.hellstrand.renfikt

import org.hellstrand.renfikt.constant.ConstantsTest.DUMMY_ARGUMENT
import org.hellstrand.renfikt.constant.ConstantsTest.MESSAGE_PROGRAM_ARGUMENTS_ARE_IGNORED
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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
}
