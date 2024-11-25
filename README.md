# Skycast - A Simple Java Weather Application 🌤️

**Skycast** is a lightweight Java application that fetches and displays real-time weather data for a given city. It leverages the [OpenWeatherMap API](https://openweathermap.org/api) and asynchronous programming with Java's modern `HttpClient`. With Skycast, you can easily check the current temperature, humidity, wind speed, and weather conditions in a user-friendly format.

## Features 🚀
- **Real-Time Weather Data**: Fetches live weather updates using the OpenWeatherMap API.
- **Asynchronous Requests**: Uses `CompletableFuture` for non-blocking HTTP requests.
- **Readable Output**: Displays temperature, humidity, wind speed, and weather conditions in a clean, console-based format.
- **Lightweight and Extendable**: Designed for simplicity, making it easy to add new features or integrate into larger projects.

## Technologies Used 🛠️
- **Java 11+**: Core language for the application.
- **HttpClient**: Modern HTTP library for making API calls.
- **Gson**: Library for parsing and mapping JSON responses into Java objects.
- **OpenWeatherMap API**: Reliable weather API for fetching real-time data.

## How to Use 🏗️

1.  **Clone the Repository:**
    
    ```
    git clone https://github.com/om1cael/skycast.git
    cd skycast
    ```
    
2.  **Set Up Your API Key:**
    *   Obtain a free API key from [OpenWeatherMap](https://openweathermap.org/api).
    *   Set the API key as an environment variable:
        
        ```
        export OPENWEATHERMAP_API=your_api_key
        ```
        
3.  **Build and Run with Gradle:**
    *   Ensure you have [Gradle](https://gradle.org/install/) installed on your machine.
    *   Build the project with Gradle:
        
        ```
        gradle build
        ```
        
    *   Run the application:
        
        ```
        gradle run
        ```
        
4.  **Example:**
    
    ```
    gradle run
    > City: New York
    ```
    
    Example Output:
    
    ```
    
    Weather in New York:
     - Temperature: 15.0ºC
     - Feels like: 14.5ºC
     - Humidity: 60%
     - Wind speed: 5.2 m/s
     - Condition: Clear
     - Condition Description: clear sky
    ```

## Contributing 🤝
Contributions are welcome! Feel free to fork the repository and submit a pull request with your improvements or new features.

## License 📜
This project is licensed under the [MIT License](LICENSE). 

## Acknowledgments 💡
- OpenWeatherMap for providing the weather API.
- Gson for JSON parsing.
