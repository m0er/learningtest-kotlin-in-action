package chp03

/**
 * Created by AidenChoi on 2016. 12. 1..
 */
fun parsePath(path: String): Triple<String, String, String> {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    return Triple(directory, fileName, extension)
}