# `agrest-benchmark`

Used to find bottlenecks in Agrest code, as well as for relative performance testing between the releases.

## Dataset

This benchmark is using the Metropolitan Museum of Art database available from [here](https://github.com/andrus/met-data).

## Running the Test

Prerequisites:

* Install [Locust](https://locust.io/)
* Start the DB with the Met dataset
* Create a YAML file with DB connection info outside the version controlled folder. E.g. `../mysql.yml`:
```
jdbc:
  db1:
    jdbcUrl: "jdbc:mysql://127.0.0.1:8306/met?connectTimeout=0&autoReconnect=true&useSSL=false"
    username: root
    password: root
    minimumIdle: 1
    maximumPoolSize: 20
```

Build and run the benchmark:
```
mvn clean package

# use "-v" to increase log verbosity level
java -jar target/agrest-benchmark-*.jar -s -c ../mysql.yml
```
Start Locust:
```
locust -f locust/get.py
```
[Open Locust console in the browser](http://127.0.0.1:8089/) and start the test via UI.