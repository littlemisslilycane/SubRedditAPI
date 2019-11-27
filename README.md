

# SubRedditAPI - Web Exercise

This RESI API application acts like a wrapper for the /r/subreddit API call. Given a subreddit name it returns the list of articles under it as JSON object.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Framework

1)Java 1.8.0
2)SpringBoot 2.2.1
3)Apache Maven 3.6.2

### Deployment
Hosted in Amazon AWS at the URL : subredditrestapi.us-east-1.elasticbeanstalk.com


## Running it locally
Steps:
On the command line
git clone https://github.com/littlemisslilycane/SubRedditAPI.git
Inside Eclipse or STS
File -> Import -> Maven -> Existing Maven project
Then either build on the command line ./mvnw generate-resources or using the Eclipse launcher (right click on project and Run As -> Maven install) to generate the css. Run the application main method by right clicking on it and choosing Run As -> Java Application.

Inside IntelliJ IDEA
In the main menu, choose File -> Open and select the pom.xml. Click on the Open button.

Click Maven -> Generates sources and Update Folders.

A run configuration named Application should have been created for you if you're using a recent Ultimate version. Otherwise, run the application by right clicking on the Application main class and choosing Run 'Application'.


Visit http://localhost:8080/subreddit/<name> in your browser.


## How the API works

Get the list of subreddit articles:
```
subredditrestapi.us-east-1.elasticbeanstalk.com/subreddit/news
subredditrestapi.us-east-1.elasticbeanstalk.com/subreddit/news/controversial
```

