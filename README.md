# Comments automated tests
This repo provides a sample set of automated tests for [http://commentssprintone.azurewebsites.net]() application.

![](https://img.shields.io/github/license/extsoft/jcat.svg)
![](https://img.shields.io/docker/automated/extsoft/jcat.svg)
![](https://img.shields.io/docker/build/extsoft/jcat.svg)
![](https://travis-ci.org/extsoft/jcat.svg?branch=master)

## Used tools
- [Java 11](https://jdk.java.net/java-se-ri/11) as a programming language
- [maven](https://maven.apache.org) as a build system
- [Allure](http://allure.qatools.ru) as a reporting engine
- [Selenium](https://www.seleniumhq.org) as a WEB automation framework
- [TestNG](http://testng.org/doc/) as a tests runner
- [Sunshine](https://github.com/tatools/sunshine/) as a suite manager for TestNG
- [Docker](https://www.docker.com) as an infrastructure manager
- [SeleniumHQ/docker-selenium](https://github.com/SeleniumHQ/docker-selenium) as a [Selenium Grid](https://www.seleniumhq.org/docs/07_selenium_grid.jsp)

# Running the tests
There are two supported browsers:
- `firefox` means [Mozilla Firefox](https://www.mozilla.org)
- `chrome` means [Google Chrome](https://www.google.com/chrome/)

The tests are going to connect to a remote driver. It can be either a WebDriver run as a 
 standalone process or [Selenium Grid](https://www.seleniumhq.org/docs/07_selenium_grid.jsp).

Also, please pay attention to [configuration options](#configuration-options) and [reporting](#reporting).

## Docker
### Using docker's image
First of all, you need to run desired WebDriver (`chromedriver` or `geckodriver`) as a standalone application ([instructions](https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver#running-chromedriver-as-a-standalone-process) for `ChromeDriver`). If you have a working Selenium Grid, you can use it instead.

Then, run the following command with the correct value for `SELENIUM_URL` and `BROWSER` (see [configuration options](#configuration-options)  for the details):
```bash
docker run -it \
       --net=host \
       --env SELENIUM_URL=http://docker.for.mac.localhost:4444 \
       --env BROWSER=firefox \
       --volume $(pwd)/allure-results:/jcat/allure-results \
       extsoft/jcat:latest
```

:exclamation:As the browser driver is run on the localhost, we have to give proper URL for `SELENIUM_URL` option. Docker provides several networking features for each OS which allow binding of host machine's hostname into a container. As the result, if you bind a container to host's network with `--net=host` and want access host's resources, correct hostname is
- `docker.for.win.localhost` for Windows
- `docker.for.mac.localhost` for OSX
- `localhost` for Linux

:exclamation:If Selenium Grid is run on your local environment using docker, you have to add `--net=<Selenium Grid network>` to the command above.

### Using docker-compose
> To be able to use this type of run, you need to have Docker engine release `1.13.0+`. A simple way to check: `docker-compose -v`

First of all, you need to download a YAML file: 
```bash
curl -o docker-compose.yaml https://raw.githubusercontent.com/extsoft/jcat/master/docker-compose.yaml
```

Then, run tests: 
```bash
docker-compose up --abort-on-container-exit --timeout 120
```
:exclamation: This command runs the Selenium Grid with `firefox` and `chrome` browsers and executes the tests in parallel.  If you need one of browsers, add `jcat-on-firefox` or `jcat-on-chrome` to the end of the command.

After the tests execution, the Allure results directories are created: `allure-results-chrome` and `allure-results-firefox`. 

If you need Selenium Grid for development purposes, run `docker-compose up -d firefox60 chrome66`. As the Grid's port is mapped to a host machine, you view Grid's console on [http://localhost:4444/grid/console]().

Use `docker-compose down` to destroy the environment.

## From source code
1. Clone the repo
2. Package tests  with `mvn clean package` (a JAR file is located under `target` directory and is named like `comments-at-x.x.x-jar-with-dependencies.jar` , where `x.x.x` is a `version` property from [pom.xml](pom.xml)).
3. Run tests with `java -jar comments-at-x.x.x-jar-with-dependencies.jar`

For instance,
```bash
java -Dbrowser=firefox -Dselenium-url=http://127.0.0.1:4444 \
     -jar comments-at-0.1.0-jar-with-dependencies.jar
``` 
runs tests on Firefox browser using `geckodriver` started on `4444` port.

## Configuration options
Environment variable (Docker) | System property (Java) | Options | Default value (Docker / Java) | Description
---|---|---|---|---
`BROWSER` | `browser` | either`chrome` or `firefox` | `chrome` / `chrome` | A browser for testing
`SELENIUM_URL` | `selenium-url` |Any remote URL | `http://selenium-hub:4444/wd/hub` / `http://localhost:9515` | An URL to remove driver or Selenium Grid

## Reporting
The [Allure](http://allure.qatools.ru) files are stored to `allure-results` directory within the directory where you run the tests. Just run `allure serve` to see the Allure HTML report.

# Application pages
## Main screen
![](docs/pages/main-page.png)

## Actions panel on main screen
![](docs/pages/actions-panel.png)

## Comment screen
![](docs/pages/comment.png)
