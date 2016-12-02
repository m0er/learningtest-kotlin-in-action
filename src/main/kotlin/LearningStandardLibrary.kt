/**
 * Created by AidenChoi on 2016. 12. 2..
 */
data class Config(var buildType: String, var version: String)

val map = hashMapOf<String, Config>()

fun configurationFor(id: String) = map[id]?.let { config ->
    config.apply {
        buildType = "DEBUG"
        version = "1.2"
    }
}

fun configurationFor2(id: String) = map[id]?.apply {
    buildType = "DEBUG"
    version = "1.2"
}