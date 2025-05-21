import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUserApiResponse(
    @SerialName("results")
    val results: List<RandomUser> = emptyList()
)
@Serializable
data class RandomUser(
    @SerialName("cell")
    val cell: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("gender")
    val gender: String? = null,
    @SerialName("id")
    val id: Id? = null,
    @SerialName("location")
    val location: Location? = null,
    @SerialName("name")
    val name: Name? = null,
    @SerialName("nat")
    val nat: String? = null,
    @SerialName("phone")
    val phone: String? = null,
    @SerialName("picture")
    val picture: Picture? = null,
    @SerialName("registered")
    val registered: Registered? = null
)
@Serializable
data class Name(
    @SerialName("first")
    val first: String? = null,
    @SerialName("last")
    val last: String? = null,
    @SerialName("title")
    val title: String? = null
)
@Serializable
data class Picture(
    @SerialName("large")
    val large: String? = null,
    @SerialName("medium")
    val medium: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null
)
@Serializable
data class Street(
    @SerialName("name")
    val name: String? = null,
    @SerialName("number")
    val number: Int? = null
)
@Serializable
data class Location(
    @SerialName("city")
    val city: String? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("state")
    val state: String? = null,
    @SerialName("street")
    val street: Street? = null,
)
@Serializable
data class Id(
    @SerialName("name")
    val name: String? = null,
    @SerialName("value")
    val value: String? = null
)
@Serializable
data class Registered(
    @SerialName("age")
    val age: Int? = null,
    @SerialName("date")
    val date: String? = null
)