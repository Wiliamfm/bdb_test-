# Point 3

## This instruccions are for a development deploy

### Download the postgres image:

1. You need to have docker installed.
2. run the command: docker run -dp 5432:5432 wfonsecamfm/db-postgres-test

### Get the spring app:

1. Clone this repository: git clone https://github.com/Wiliamfm/bdb_test-.
2. Go to the spring app root folder: cd bdb_test-/point3/test/
3. Initialize the spring app: ./gradlew bootRun

### Get the angular app:

1. Go to the angular app root folder: cd ../test_views/
2. Initialize the app: ng serve --open

### Test the app:

1. In the browser go to: http://localhost/4200
