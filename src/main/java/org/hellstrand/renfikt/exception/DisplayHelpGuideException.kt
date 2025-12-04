package org.hellstrand.renfikt.exception

/**
 * @author (Mats Richard Hellstrand)
 * @version (4th of December, 2025)
 */
class DisplayHelpGuideException : ExpectedRuntimeException {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writeableStackTrace: Boolean) : super(
        message, cause, enableSuppression, writeableStackTrace
    )
}
