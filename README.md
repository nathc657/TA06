# Running the App
The app can be run by building and running the app via Gradle and the Android Studio interface. The app could also be simply run from a downloadable app (.APK) once packaged.

# Navigating the App
## Google Maps Screen
The map interface can be located at all times on the upper half of the screen.

<img width="270" height="600" alt="image" src="https://github.com/user-attachments/assets/8e6b3032-1c17-45a3-88b2-655c5845f108" />

This map utilizes the Google Maps API to provide an alternative way to search for nearby hospitals. On this map, every nearby, documented hospital in the system is marked. Clicking on any of these markers will similarly bring you to the details menu for that hospital, where you can then route to said hospital. 

Due to the use of the Google Maps API, **the map may not be usable without a Google Maps API key saved within local.properties**. For grading purposes, please contact the group if access to the API key is needed.

Once a Google Maps API key is obtained, it must be inserted into the project in *Gradle Scripts/local.properties*:
```bash
MAPS_API_KEY=******
```
