package extensions

fun String.createSuccessResponse(): String = "Success: $this"

fun String.createErrorResponse(): String = "Error: $this"
