# WeatherSim


#Build Instructions
Prerequisite:
-Ensure Java and Maven are installed. 
-Ensure JAVA_HOME and M2_HOME environemnt variables are set
Build:
*Download https://github.com/kaarun007/WeatherSim in terminal
*Change the directory to the project directory(WeatherSim)
*Build the project using the below command
   -mvn clean package
   -(eg: C:\ARUN\WeatherSim\target>mvn clean package)
*run the application using the below commands
  - mvn spring-boot:run
  - (or)
  - java jar target\WeatherSim-0.0.1-SNAPSHOT.jar
   
   -The above commands would start the weathersim microservice. The service will be listend in 8080 port
* Open any browser and type localhost:8080/weather to see the simulator output.   
    
  
