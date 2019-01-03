Structure

![structure](structure.PNG "Structure")

Idea: Weather data station, which gattern weather data. Different displays, which want to listen to weather data and get notified.

- Abstract Observer --> Observer.java
- Concrete Observer --> CurrentConditionsDisplay.java, ForecastDisplay.java, StatisticsDisplay.java
- Abstract Subject --> Subject.java
- Concrete Subject --> WeatherData.java