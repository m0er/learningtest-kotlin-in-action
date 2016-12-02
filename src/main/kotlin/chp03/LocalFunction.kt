package chp03

/**
 * Created by AidenChoi on 2016. 12. 2..
 */
data class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(value: String,
                 fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cannot save user ${user.id}: $fieldName is empty")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    // Save user to database
}