# Kata Requirements
+ A request to /api/:date? with a valid date should return a JSON object with a unix key that is a Unix timestamp of the input date in milliseconds (as type Number)
+ A request to /api/:date? with a valid date should return a JSON object with a utc key that is a string of the input date in the format: Thu, 01 Jan 1970 00:00:00 GMT
+ A request to /api/1451001600000 should return { unix: 1451001600000, utc: "Fri, 25 Dec 2015 00:00:00 GMT" }
+ Your project can handle dates that can be successfully parsed by new Date(date_string)
+ If the input date string is invalid, the api returns an object having the structure { error : "Invalid Date" }
+ An empty date parameter should return the current time in a JSON object with a unix key
+ An empty date parameter should return the current time in a JSON object with a utc key

# Plugin details
You have successfully created an Atlassian Plugin!

Here are the SDK commands you'll use immediately:

* atlas-run   -- installs this plugin into the product and starts it on localhost
* atlas-debug -- same as atlas-run, but allows a debugger to attach at port 5005
* atlas-help  -- prints description for all commands in the SDK

Full documentation is always available at:

https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK


# Resources
+ Servlet - https://developer.atlassian.com/server/jira/platform/servlet/
  + 