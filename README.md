mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://www.saucedemo.com/"

mvn clean test "-DsuiteXmlFile=testng.xml"   