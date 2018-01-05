Steps to Build Application

Download the source code from git repository and extract it.

Build it using "mvn install" command in terminal. Now a war file gets generated.

Steps to run Application

Enter http://localhost:8080 in browser.

Tomcat Home page will be displayed.(if any port issues found tan change the port numbers in server.xml file)

Upload the war file of the application in the specified location.

Now after uploading war file , project gets dislayed in the projects list.

Run the application

Execution Flow:

1.Test the apis in the post man

2.http://localhost:8080/events/getAllCategories

3.http://localhost:8080/events/getAllUsers

4.http://localhost:8080/events/getAllEvents

5.http://localhost:8080/events/auth ---for login

6.http://localhost:8080/events/upcomming

7.http://localhost:8080/events/addevents --- post method for adding events

8.http://localhost:8080/events/getCategoryById/{id}
