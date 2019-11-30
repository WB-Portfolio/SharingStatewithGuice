# SharingStatewithGuice
Simple project using frameworks Cucumber+Junit+state sharing with Guice dependencies

I wanted to share this little example to show how it is useful to use the google guice dependencie to inject the driver object onto every test. 
Using the Bonigarcia dependecie, this simple project runs on Linux with chrome browser.

Feature 1
Step 1 : Opening "www.google.com"
Step 2 : Navigating to "www.LDLC.com"
Step 3 : Searching for the term "TV" in the search barre
Step 4 : Asserting that the search page is displayed
