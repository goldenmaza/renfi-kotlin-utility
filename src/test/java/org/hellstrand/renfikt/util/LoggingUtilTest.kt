package org.hellstrand.renfikt.util

import org.hellstrand.renfikt.constant.Constants.DATA_PROCESSING
import org.hellstrand.renfikt.constant.Constants.FILE_PROCESSING
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETER
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETERS
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_FORMAT_MESSAGE_TEMPLATE_WITH_PARAMETER
import org.hellstrand.renfikt.constant.TestConstants.ASSERT_FORMAT_MESSAGE_TEMPLATE_WITH_PARAMETERS
import org.hellstrand.renfikt.util.LoggingUtil.formatMessage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * @author (Mats Richard Hellstrand)
 * @version (15th of December, 2025)
 */
class LoggingUtilTest {
     @Test
     @DisplayName("Verifying that the formatMessage function works as expected, with a template and a parameter, and a formatted message is returned")
     fun formatMessageFunctionTest_TemplateAndParameter_ReturningFormattedMessage() {
          // Prepare
          val messageTemplate = ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETER
          val messageParameter = FILE_PROCESSING

          // Execute
          val formattedMessage = formatMessage(messageTemplate, messageParameter)

          // Assert
          assertEquals(ASSERT_FORMAT_MESSAGE_TEMPLATE_WITH_PARAMETER, formattedMessage)
     }

     @Test
     @DisplayName("Verifying that the formatMessage function works as expected, with a template and multiple parameters, and a formatted message is returned")
     fun formatMessageFunctionTest_TemplateAndParameters_ReturningFormattedMessage() {
          // Prepare
          val messageTemplate = ASSERT_FORMAT_MESSAGE_TEMPLATE_WITHOUT_PARAMETERS
          val messageParameterFileProcessing = FILE_PROCESSING
          val messageParameterDataProcessing = DATA_PROCESSING

          // Execute
          val formattedMessage = formatMessage(messageTemplate, messageParameterFileProcessing, messageParameterDataProcessing)

          // Assert
          assertEquals(ASSERT_FORMAT_MESSAGE_TEMPLATE_WITH_PARAMETERS, formattedMessage)
     }
}
