# ElasticsearchWebApp
DraftApp

Usage:

1) Install Java 1.8 (any latest version) 

2) Install elasticsearch which is compatible to spring boot i.e, < 5.x.x 
   For this demo elasticsearch-2.4.1 was installed.
   
3) Start Elastic Search from bin directory of installed path of elasticsearch-2.4.1

4) Start the java applciation, here it is MainApplicationController as the main class.
   NOTE : Update file application.properties to set cluster name as per your Elastiseach cluster.
   
          spring.data.elasticsearch.cluster-name=my-application
   
5) Submit REST requests as below. 

==================================================================================================

A) Request Method: GET

Requirement : To get all the tasks

http://localhost:8080/healthcare/findAllTasks


B) Request Method: POST

Requirement : To save a task

http://localhost:8080/healthcare/saveTask

POSTData
{
"taskId":"100",
"taskTitle":"Diabatic",
"taskDueDate":"2015/12/12",
"taskStatus":"Diagnosis",
"taskSubStatus":"Pathalogy",
"taskHealthGoal":"Admitted",
"taskAssignedToRole":"Test Role"
}

C) Request Method: DELETE

Requirement : To delete all tasks

http://localhost:8080/healthcare/deleteAllTasks

D) Request Method: POST

Requirement : To update task

http://localhost:8080/healthcare/updateTask

POSTData

{
"taskId":"100",
"taskTitle":"Diabatic",
"taskDueDate":"2015/12/12",
"taskStatus":"Diagnosis",
"taskSubStatus":"Pathalogy",
"taskHealthGoal":"Admitted",
"taskAssignedToRole":"Test Role"
}


E) Request Method: DELETE

Requirement : To delete a particular task

http://localhost:8080/healthcare/deleteTask?id=100

F) Request Method: GET

Requirement : To get tasks as per page and number of tasks per page

http://localhost:8080/healthcare/getPageRequest?taskName=Diagnosis&pageIdx=0&recordCount=3

==================================================================================================


6) The details on Elastic Search can be queried as well to check if these are available.

==================================================================================================

POST 
http://localhost:9200/healthcare/task/_search

PostBody
{
"query":
{
"match_all":{}
}
}

==================================================================================================











