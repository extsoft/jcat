**Comments automated tests**
============================

This repo provides a vision of an object-oriented automated tests for http://commentssprintone.azurewebsites.net 
application. The main goal is to show how to use OOP paradigm for test automation tasks.

Table of contents 
-----------------
  - [Automated tests](#automated-tests)
    - [Run](#run)
  - [Pages](#pages)
    - [Main screen](#main-screen)
    - [Actions panel on main screen](#actions-panel-on-main-screen)
    - [Comment screen](#comment-screen)
  
Automated tests
===============
Create executable application
-----------------------------
After `mvn clean package` execution you will see `comments-at-x.x.x-jar-with-dependencies.jar` jar file under `target`
directory (`x.x.x` is a `version` property from [pom.xml](pom.xml)).

Run tests
---------
1. Run ChromeDriver as a 
[standalone process](https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver#running-chromedriver-as-a-standalone-process)
2. Execute `java -jar target/comments-at-x.x.x-jar-with-dependencies.jar` command (replace `x.x.x` with a proper 
`version` from [pom.xml](pom.xml))

Pages
=====
Main screen
-----------
![](src/pages/main-page.png)

Actions panel on main screen
----------------------------
![](src/pages/actions-panel.png)

Comment screen
--------------
![](src/pages/comment.png)
