drop database assignment6;
CREATE DATABASE assignment6 CHARACTER SET utf8 COLLATE utf8_bin;
use assignment6;

CREATE TABLE Programs
(
	ProgramId INT(3) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ProgramCode varchar(25) NOT NULL,
	ProgramName varchar(25) NOT NULL
);

CREATE TABLE Students
(
	StudentId INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	Password varchar(25) NOT NULL,
	FirstName varchar(50) NOT NULL,
	LastName varchar(50) NOT NULL,
	Sex varchar(1),
	ProgramId INT(3),

	CONSTRAINT FK_STUDENTS_PROGRAMID FOREIGN KEY (ProgramId) REFERENCES Programs(ProgramId)

) AUTO_INCREMENT = 1500000;

CREATE TABLE Courses
(
	CourseId INT(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	CourseCode varchar(12) NOT NULL,
	CourseName varchar(25) NOT NULL,
	TeacherName varchar(50),
	Room varchar(15) 
);

CREATE TABLE Assignments
(
	AssignmentId INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	AssignmentName varchar(25) NOT NULL,
	AssignmentWorth int(3), 
	CourseId INT(4) NOT NULL,
	DueDate DateTime,

	CONSTRAINT FK_ASSIGNMENTS_COURSEID FOREIGN KEY (CourseId) REFERENCES Courses(CourseId) 
);

CREATE TABLE Enrollment
(
	EnrollmentId INT(12) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	StudentId INT(8),
	CourseId INT(4),

	CONSTRAINT FK_ENROLLMENT_STUDENTID FOREIGN KEY (StudentId) REFERENCES Students(StudentId),
	CONSTRAINT FK_ENROLLMENT_COURSEID FOREIGN KEY (CourseId) REFERENCES Courses(CourseId)
);

CREATE TABLE StudentAssignments
(
	StudentAssignmentId INT(8) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	StudentId INT(8),
	AssignmentId INT(8),
	TimeSpent INT(3),
	Goal INT(3),
	CONSTRAINT FK_STUDENTASSIGNMENT_STUDENTID FOREIGN KEY (StudentId) REFERENCES Students(StudentId),
	CONSTRAINT FK_STUDENTASSIGNMENT_ASSIGNMENTID FOREIGN KEY (AssignmentId) REFERENCES Assignments(AssignmentId)

);












