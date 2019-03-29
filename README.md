# WeatherSim

This applicaiton is the toy weather simulator. 
The  weather simulator is designed as a micro service using spring-boot. The applicaiton is designed as a highly configuratble one. the configurations are kept in the application.properties file. 
- The supported configurations are:
  - Locations and positions
  - The weather model (climatic conditions and envirnments factors).
The model configuration is build based on the climatic conditions and each climatic condition would have the predified environments like temperature, pressure, humidity. Currently the applicaiton supports three climatic conditions like sunny, rain and snow and this can be extended for more climatic conditions. We can add more locaitons,position. 
The simulator also has a mode configuration.If the mode is 'mixed' then the the mixed climatic conditions are generated. There is also possible to generate "mono" climatic condition but that can be handled as a futher enhacement.


# Build Instructions
*Pre-requisite:
 - Ensure Java and Maven are installed. 
 - Ensure JAVA_HOME and M2_HOME environemnt variables are set
Build:
1. Download https://github.com/kaarun007/WeatherSim in terminal
2. Change the directory to the project directory(WeatherSim)
3. Build the project using the below command
   - mvn clean package
   - (eg: C:\ARUN\WeatherSim\target>mvn clean package)
4. run the application using the below commands
  - mvn spring-boot:run
  -    (or)
  - java jar target\WeatherSim-0.0.1-SNAPSHOT.jar
   
  - The above commands would start the weathersim microservice. The service will be listend in 8080 port
5. Open any browser and type localhost:8080/weather to see the simulator output.   
    
  
