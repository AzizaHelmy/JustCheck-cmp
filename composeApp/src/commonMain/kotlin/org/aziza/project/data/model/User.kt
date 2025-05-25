import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUserApiResponse(
    @SerialName("users")
    val results: List<RandomUser> = emptyList()
)

@Serializable
data class RandomUser(
    @SerialName("id")
    val id: Int? = null,
    @SerialName("firstName")
    val firstName: String? = null,
    @SerialName("lastName")
    val lastName: String? = null,
    @SerialName("maidenName")
    val maidenName: String? = null,
    @SerialName("age")
    val age: Int? = null,
    @SerialName("gender")
    val gender: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("phone")
    val phone: String? = null,
    @SerialName("birthDate")
    val birthDate: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("address")
    val address: Address? = null,
    @SerialName("company")
    val company: Company? = null,
    @SerialName("bank")
    val bank: Bank? = null,
    @SerialName("crypto")
    val crypto: Crypto? = null
)

@Serializable
data class Address(
    @SerialName("address")
    val address: String? = null,
    @SerialName("city")
    val city: String? = null,
    @SerialName("state")
    val state: String? = null,
    @SerialName("stateCode")
    val stateCode: String? = null,
    @SerialName("postalCode")
    val postalCode: String? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("coordinates")
    val coordinates: Coordinates? = null
)

@Serializable
data class Coordinates(
    @SerialName("lat")
    val lat: Double? = null,
    @SerialName("lng")
    val lng: Double? = null
)

@Serializable
data class Company(
    @SerialName("department")
    val department: String? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("address")
    val address: Address? = null
)

@Serializable
data class Bank(
    @SerialName("cardExpire")
    val cardExpire: String? = null,
    @SerialName("cardNumber")
    val cardNumber: String? = null,
    @SerialName("cardType")
    val cardType: String? = null,
    @SerialName("currency")
    val currency: String? = null,
    @SerialName("iban")
    val iban: String? = null
)

@Serializable
data class Crypto(
    @SerialName("coin")
    val coin: String? = null,
    @SerialName("wallet")
    val wallet: String? = null,
    @SerialName("network")
    val network: String? = null
)
