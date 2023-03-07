# tested-request-4840

<h1 align="center">Course Management System</h1>


Helps in keeping track of parallel running courses ,batch etc. 


<img align="center" alt="Coding" width="100%" src="https://github.com/apurvs14/tested-request-4840/blob/main/ER_diagram.png">



<h3 align="left">Domain Description:</h3>


In an educational  Institute there are several courses running parallel  every day. For every course there are several batches at same/different time. Every course has a session wise/day wise schedule. It will be difficult for the Faculty Head to know the status of every batch i.e what is the session taught at each day in a batch.
So the Automated Course Monitoring System will keep the records of all the courses,batches,faculties and the daywise update for every batch. It will also help the Faculty Head to maintain the course plan .



<h3 align="left">Types of users:</h3>

•	Administrator.

•	Faculty


<h3 align="left">Role of Administrator:</h3>

•	Login to his account

•	 Create, Update, View Course.

•	Create, Update, View Batch. A batch is related to a course. 

•	Create, Update, View Faculty.

•	Allocate faculty to a batch.

•	Create, Update, View Course plan.

•	View the Day wise update of every batch.

•	 Generate Report for every batch.


<h3 align="left">Role of Faculty:</h3>

•	Login to his/her account

•	View the Course Plan

•	Fill up the day wise planner.

•	Update his/her password.



<h2 align="left">Tables:</h2>


<h3 align="left">Admin:</h3>

•	username

•	password:


<h3 align="left">Faculty:</h3>


•	facultyid

•	facultyname

•	facultyaddress

•	mobile

•	email 

•	username

•	password


<h3 align="left">Course:</h3>

•	coursed

•	courseName

•	fee

•	courseDescription


<h3 align="left">Batch:</h3>

•	batchId:

•	courseId:

•	facultyId:

•	numberofStudents;

•	batchstartDate

•	duration 


<h3 align="left">CoursePlan:</h3>

•	planId

•	batchId

•	daynumber

•	topic

•	status: completed/pending

