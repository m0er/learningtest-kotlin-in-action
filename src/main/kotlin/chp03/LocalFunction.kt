package chp03

/**
 * Created by AidenChoi on 2016. 12. 2..
 */
data class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Cannot save user ${user.id}: Name is empty")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Cannot save user ${user.id}: Address is empty")
    }

    // Save user to database
}