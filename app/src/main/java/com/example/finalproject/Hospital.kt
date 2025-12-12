package com.example.finalproject

data class Hospital(
    val name: String,
    val address: String,
    val services: List<String>,
    val phone: String,
    val website: String,
    val distanceInMeters: Int //yall use this for distance from current point?
)

fun sampleHospitalData(): List<Hospital> {
    return listOf(
        Hospital(
            name = "Nemours Children's Hospital",
            address = "1600 Rockland Rd, Wilmington, DE 19803",
            services = listOf("Children", "Cancer", "Emergency"),
            phone = "(800) 416-4441",
            website = "https://www.nemours.org",
            distanceInMeters = 8000
        ),
        Hospital(
            name = "ChristianaCare Christiana Hospital",
            address = "4755 Ogletown Stanton Rd, Newark, DE 19718",
            services = listOf("Emergency", "Heart", "Cancer"),
            phone = "(302) 733-1000",
            website = "https://christianacare.org/us/en/facilities/",
            distanceInMeters = 5000
        ),
        Hospital(
            name = "ChristianaCare Wilmington Hospital",
            address = "501 W 14th St, Wilmington, DE 19801",
            services = listOf("Emergency", "Primary", "Ortho"),
            phone = "(302) 733-1000",
            website = "https://christianacare.org/us/en/facilities/",
            distanceInMeters = 9500
        ),
        Hospital(
            name = "ChristianaCare Hospital Emergency Department",
            address = "4755 Ogletown Stanton Rd, Newark, DE 19718",
            services = listOf("Emergency", "Trauma", "Stroke"),
            phone = "(302) 733-1000",
            website = "https://christianacare.org/us/en/emergency",
            distanceInMeters = 5100 // Slightly different to distinguish
        ),
        Hospital(
            name = "Saint Francis Hospital",
            address = "701 N Clayton St, Wilmington, DE 19805",
            services = listOf("Emergency", "Heart", "Cancer"),
            phone = "(302) 421-4100",
            website = "https://www.trinityhealthma.org/location/saint-francis-hospital",
            distanceInMeters = 8500
        ),
        Hospital(
            name = "ChristianaCare Union Hospital",
            address = "106 Bow St, Elkton, MD 21921",
            services = listOf("Emergency", "Heart", "Cancer"),
            phone = "(410) 398-4000",
            website = "https://www.uhcc.com/",
            distanceInMeters = 15000
        ),
        Hospital(
            name = "Wilmington VA Medical Center",
            address = "1601 Kirkwood Hwy, Wilmington, DE 19805",
            services = listOf("Primary", "Cancer", "Mental"),
            phone = "(800) 461-8262",
            website = "https://www.va.gov/wilmington-health-care/",
            distanceInMeters = 7000
        ),
        Hospital(
            name = "ChristianaCare-GoHealth Urgent Care",
            address = "550 S College Ave Suite 115, Newark, DE 19713",
            services = listOf("Urgent", "Injury", "Illness"),
            phone = "(302) 273-0727",
            website = "https://www.gohealthuc.com/christianacare/locations/star-campus",
            distanceInMeters = 1200
        ),
        Hospital(
            name = "ChristianaCare-GoHealth Urgent Care 2",
            address = "360 Buckley Ml Rd suite b, Greenville, DE 19807",
            services = listOf("Urgent", "Injury", "Illness"),
            phone = "(302) 504-0253",
            website = "https://www.gohealthuc.com/christianacare/locations/greenville",
            distanceInMeters = 6000
        ),
        Hospital(
            name = "Newark Urgent Care",
            address = "324 E Main St, Newark, DE 19711",
            services = listOf("Urgent", "Injury", "Illness"),
            phone = "(302) 738-4300",
            website = "https://newarkurgentcare.org/",
            distanceInMeters = 2500
        )
    )
}