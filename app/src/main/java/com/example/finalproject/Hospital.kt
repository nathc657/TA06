package com.example.finalproject

data class Hospital(
    val name: String,
    val address: String,
    val services: List<String>,
    val phone: String,
    val website: String,
    val lat: Double,
    val lng: Double,
    val distanceInMeters: Int
)

fun sampleHospitalData(): List<Hospital> {
    return listOf(
        Hospital(
            name = "Nemours Children's Hospital",
            address = "1600 Rockland Rd, Wilmington, DE 19803",
            services = listOf("Children", "Cancer", "Emergency"),
            phone = "(800) 416-4441",
            website = "https://www.nemours.org",
            lat = 39.7767,
            lng = -75.5471,
            distanceInMeters = 8000
        ),
        Hospital(
            name = "ChristianaCare Christiana Hospital",
            address = "4755 Ogletown Stanton Rd, Newark, DE 19718",
            services = listOf("Emergency", "Heart", "Cancer"),
            phone = "(302) 733-1000",
            website = "https://christianacare.org/us/en/facilities/",
            lat = 39.6836,
            lng = -75.6566,
            distanceInMeters = 5000
        ),
        Hospital(
            name = "ChristianaCare Wilmington Hospital",
            address = "501 W 14th St, Wilmington, DE 19801",
            services = listOf("Emergency", "Primary", "Ortho"),
            phone = "(302) 733-1000",
            website = "https://christianacare.org/us/en/facilities/",
            lat = 39.7470,
            lng = -75.5535,
            distanceInMeters = 9500
        ),
        Hospital(
            name = "Saint Francis Hospital",
            address = "701 N Clayton St, Wilmington, DE 19805",
            services = listOf("Emergency", "Heart", "Cancer"),
            phone = "(302) 421-4100",
            website = "https://www.trinityhealthma.org/location/saint-francis-hospital",
            lat = 39.7464,
            lng = -75.5750,
            distanceInMeters = 8500
        ),
        Hospital(
            name = "Newark Urgent Care",
            address = "324 E Main St, Newark, DE 19711",
            services = listOf("Urgent", "Injury", "Illness"),
            phone = "(302) 738-4300",
            website = "https://newarkurgentcare.org/",
            lat = 39.6837,
            lng = -75.7497,
            distanceInMeters = 2500
        )
    )
}
