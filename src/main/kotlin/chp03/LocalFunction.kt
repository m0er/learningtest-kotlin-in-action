package chp03

/**
 * Created by AidenChoi on 2016. 12. 2..
 */
data class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String,
                 fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cannot save user $id: $fieldName is empty")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()

    // Save user to database
}