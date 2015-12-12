drop database assignment6;
CREATE DATABASE assignment6 CHARACTER SET utf8 COLLATE utf8_bin;
use assignment6;

CREATE TABLE programs
(
	programId INT(3) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	programCode varchar(25) NOT NULL,
	programName varchar(25) NOT NULL
);

CREATE TABLE students
(
	studentId INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	password varchar(25) NOT NULL,
	firstName varchar(50) NOT NULL,
	lastName varchar(50) NOT NULL,
	sex varchar(1),
	programId INT(3),

	CONSTRAINT FK_STUDENTS_PROGRAMID FOREIGN KEY (ProgramId) REFERENCES programs(ProgramId)

) AUTO_INCREMENT = 1500000;

CREATE TABLE courses
(
	courseId INT(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	courseCode varchar(12) NOT NULL,
	courseName varchar(25) NOT NULL,
	teacherName varchar(50),
	room varchar(15) 
);

CREATE TABLE assignments
(
	assignmentId INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	assignmentName varchar(25) NOT NULL,
	assignmentWorth int(3), 
	courseId INT(4) NOT NULL,
	dueDate DateTime,

	CONSTRAINT FK_ASSIGNMENTS_COURSEID FOREIGN KEY (CourseId) REFERENCES courses(CourseId) 
);

CREATE TABLE enrollment
(
	enrollmentId INT(12) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	studentId INT(8),
	courseId INT(4),

	CONSTRAINT FK_ENROLLMENT_STUDENTID FOREIGN KEY (studentId) REFERENCES students(StudentId),
	CONSTRAINT FK_ENROLLMENT_COURSEID FOREIGN KEY (courseId) REFERENCES courses(CourseId)
);

CREATE TABLE studentAssignments
(
	studentAssignmentId INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	studentId INT(8),
	assignmentId INT(8),
	timeSpent INT(3),
	goal INT(3),
	CONSTRAINT FK_STUDENTASSIGNMENT_STUDENTID FOREIGN KEY (StudentId) REFERENCES students(StudentId),
	CONSTRAINT FK_STUDENTASSIGNMENT_ASSIGNMENTID FOREIGN KEY (AssignmentId) REFERENCES assignments(AssignmentId)

);












