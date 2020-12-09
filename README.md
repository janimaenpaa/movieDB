# movieDB

![img](moviedb.gif)

movieDB is a fullstack application made with Java Spring Boot and React.js and AWS S3. The app works as a database for movies where they can be rated by users. 
Movies can be viewed, added, deleted and updated from admin. In the frontend users can view the movies and review them.

## Demo

Frontend: https://swd20-moviedb-frontend.herokuapp.com

Admin: https://swd20-moviedb-backend.herokuapp.com

> Note: The app goes to sleep after 30 mins. After that it takes up to 1 minute to wake up.

## Project setup

In application.properties the AWS environment variables must be set.
```
aws.access_key_id=<YOUR_OWN_AWS_ACCESS_KEY_ID>
aws.secret_access_key=<YOUR_OWN_AWS_SECRET_ACCESS_KEY>
aws.s3.bucket=<YOUR_OWN_S3_BUCKETNAME>
```

Start the Java server

```bash 
maven spring-boot:run
```

Start the Frontend server
```bash
cd .\src\main\frontend\
npm install
npm start
```

## Author
[@janimaenpaa](https://github.com/janimaenpaa)


