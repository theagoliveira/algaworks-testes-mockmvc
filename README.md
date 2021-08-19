# Unit Testing Controllers with Spring MockMVC

Tutorial by [AlgaWorks](https://www.youtube.com/channel/UCIPQ0ZqTl5e5U2OFKENOh9g).

- [:clapper: Video on YouTube (:brazil:)](https://youtu.be/ngbKmhXDP4A)

## Table of Contents

- [Description](#description)
- [Project Summary](#project-summary)
- [API Documentation](#api-documentation)
  - [Get Movie](#get-movie)
    - [Request](#request)
    - [Sample Response (200 OK)](#sample-response-200-ok)
    - [Errors](#errors)
- [Deployment](#deployment)

## Description

From the YouTube description:

> "In this video we will teach you how to unit test Controllers using Spring.
>
> For that, we will use Rest Assured and Spring MockMVC tools together with JUnit5."

## Project Summary

- Project: Maven
- Java: 11
- Spring Boot: 2.4.5
- Dependencies
  - Spring Web
  - Spring Boot DevTools
  - Lombok
  - Spring Boot Starter Test
  - Spring MockMVC
  - Spring Security
  - Bucket4j Spring Boot Starter
  - Spring Cache Abstraction
  - Ehcache
- Plugins
  - Spring Boot Maven Plugin
  - Heroku Maven Plugin

## API Documentation

### Get Movie

Retrieves a movie.

#### Request

```http
GET /filmes/:id
```

- `id` must be between 0 and 100
- the response is the same, regardless of `id`

#### Sample Response (200 OK)

```json
{
    "codigo": 1,
    "titulo": "movie-title",
    "descricao": "movie-description"
}
```

#### Errors

| Condition  | Error           |
| :--------- | :-------------- |
| `id` < 0   | 400 BAD REQUEST |
| `id` > 100 | 404 NOT FOUND   |

## Deployment

App deployed on [Heroku](https://obscure-temple-36721.herokuapp.com/)
