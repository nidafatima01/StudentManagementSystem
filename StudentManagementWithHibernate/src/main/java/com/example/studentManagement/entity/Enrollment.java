package com.example.studentManagement.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
  EnrollmentID (PK)|
   EnrollmentDate  
   StudentID(FK) 
   CourseID(FK)
   InstructorID (FK)
 */

@Entity
@Table(name = "Enrollment")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EnrollmentID")
	private int id;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "StudentID")
	private Student student;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "CourseID")
	private Course course;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "InstructorID")
	private Instructor instr;

	@Temporal(TemporalType.DATE)
	@Column(name = "EnrollmentDate")
	private java.util.Date enrlDate;
	
	public Enrollment(Student student, Course course, Instructor instr, Date enrlDate) {
		super();
		this.student = student;
		this.course = course;
		this.instr = instr;
		this.enrlDate = enrlDate;
	}

	public Enrollment() {
		super();
	}

}
