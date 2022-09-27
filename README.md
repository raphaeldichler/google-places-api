<head>
<meta name="google-site-verification" content="ZR2IA0lMyedyFv3u6WQG9o9R2qRB7U_CwH5Vf-TOgNw" />
</head>



<!--suppress ALL -->
<div align="center">

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

</div>

# google-place-api

> **Warning**
> not finished

This library streamlines the use of the Google Places API in combination with Spring Boot. So you don't have to struggle with building clever requests to the API and then painstakingly integrating that again into the Spring environment.


> :information_source: If an **error** occurs during compilation or runtime and you don't know why, you can check the following [link]() to see how to fix it.

# Getting Started

This is a step-by-step guide on how to work with this repository and what preparation is needed to generally communicate with the Google Places API. 

## First Step - Integrate the repository into your project

To work with this repository, it must be added to your project. There are several ways to do this, but the easiest way is to use a software project management and comprehension tool. You can add the library to your project via Maven or Gradle.

### Maven
```xml
<dependency>
  <groupId>net.plyse</groupId>
  <artifactId>google-places-api</artifactId>
  <version>0.1.2</version>
</dependency>
```

### Gradle

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'net.plyse:google-places-api:0.1.2'
}
```

If you use another building tool which is not listed here or *you want to use another version* you can check the [following link](https://search.maven.org/artifact/net.plyse/google-places-api/0.1.2/jar).

## Second step - Configure all important information

In order to make an API request to Google, you need an API key, which you can create [here](https://console.cloud.google.com). How exactly to create an API key is described on the [official website](https://developers.google.com/maps/documentation/javascript/get-api-key) of Google.

Once you have a valid API key, you need to add it to the project. To do this, create a file named config.properties under `/src/main/resources/` in which the API key is stored. Then you only have to add the API-Key to the file as follows (`YOUR_API_KEY` stands for your API-Key).

```
google.api.places.api-key=YOUR_API_KEY
```

> :information_source: If the API key is not valid, then Java throws an [`IllegalApiKeyException`](https://github.com/raphaeldichler/google-places-api/blob/master/src/main/java/net/plyse/google/api/place/exception/IllegalApiKeyException.java), which indicates that the specified API key is no longer valid.


## Dependencies

This library is built on top of two common libraries and also designed to
work with any HTTP service on the web:

- [Jackson](https://github.com/FasterXML/jackson)
- [OkHttp](https://github.com/square/okhttp)


# Developer Documentation

View the [javadoc](https://www.javadoc.io/doc/net.plyse/google-places-api).

- [Places API]

# Introduction to the Google Places API

# License
This repository is distributed under the terms of the Apache License Version 2.0. A complete version of the license is available in the [LICENSE](https://github.com/raphaeldichler/google-places-api/blob/master/LICENSE.md) file in this repository. Any contribution made to this project will be licensed under the Apache License Version 2.0.

[contributors-shield]: https://img.shields.io/github/contributors/AuTEraZer/GooglePlacesApi.svg?style=for-the-badge
[contributors-url]: https://github.com/AuTEraZer/GooglePlacesApi/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/AuTEraZer/GooglePlacesApi.svg?style=for-the-badge
[forks-url]: https://github.com/AuTEraZer/GooglePlacesApi/network/members
[stars-shield]: https://img.shields.io/github/stars/AuTEraZer/GooglePlacesApi.svg?style=for-the-badge
[stars-url]: https://github.com/AuTEraZer/GooglePlacesApi/stargazers
[issues-shield]: https://img.shields.io/github/issues/AuTEraZer/GooglePlacesApi.svg?style=for-the-badge
[issues-url]: https://github.com/AuTEraZer/GooglePlacesApi/issues
[license-shield]: https://img.shields.io/github/license/AuTEraZer/GooglePlacesApi.svg?style=for-the-badge
[license-url]: https://github.com/AuTEraZer/GooglePlacesApi/blob/master/LICENSE.md
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/raphael-dichler-63741b189
[product-screenshot]: images/screenshot.png
[Places API]: https://developers.google.com/places/web-service/
