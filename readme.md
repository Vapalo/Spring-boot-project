# Project for Haaga-Helia course SWD4TA020-3005

## What is it?

It is a Spring boot project with thymeleaf frontend.

It uses h2 database to store albums and genres. Full CRUD functionality with user input validation.

Login with two possible users: user and admin. Passwords are salasana and adminsalasana. Passwords are hashed with bcrypt.

Regular user cant add, delete or update any info.

## Where can I find it?

The project is deployed to Heroku and can be found from [this link](https://springbootalbumlist.herokuapp.com/).

## Docker

Build the project using the provided dockerfile with 

```bash
$ docker build -t <desired-tag-name> .
```

Run the container

```bash
$ docker run --rm -p 8080:8080 <the-same-desired-tag-name>
```

Then navigate to localhost:8080 to test the project locally
