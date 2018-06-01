# Comments automated tests
This repo provides a sample set of automated tests for [http://commentssprintone.azurewebsites.net]() application.



# Usage
1. Clone the repo
2. Package tests  with `mvn clean package` (a JAR file is located under `target` directory and is named like `comments-at-x.x.x-jar-with-dependencies.jar` , where `x.x.x` is a `version` property from [pom.xml](pom.xml)).
3. Run tests with `java -jar comments-at-x.x.x-jar-with-dependencies.jar`

The tests are going to connect to a remote driver. It can be either a WebDriver run as a 
 standalone process ([a sample for `ChromeDriver`](https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver#running-chromedriver-as-a-standalone-process)) or [Selenium Grid](https://www.seleniumhq.org/docs/07_selenium_grid.jsp).

The [Allure](http://allure.qatools.ru) report will be stored to `allure-results` directory within the directory where you run the tests. Just run `allure serve` to see the Allure HTML report.

## Configuration options
There are a couple of system properties for tests configuration.

System property | Options | Default value | Description
---|---|---|---
`browser` | `chrome` or `firefox` | `chrome` | A browser for testing
`selenium-url` | Any remote URL | `http://localhost:9515` (`ChromeDriver`) | An URL to remove driver or Selenium Grid


`java -Dbrowser=firefox -Dselenium-url=http://127.0.0.1:4444 -jar comments-at-x.x.x-jar-with-dependencies.jar` runs tests on Firefox browser using started `geckodriver` on `4444` port.

# Application pages
## Main screen
![](docs/pages/main-page.png)

## Actions panel on main screen
![](docs/pages/actions-panel.png)

## Comment screen
![](docs/pages/comment.png)
