package com.example.studentManagement.entity;


import javax.persistence.*;

 

import java.util.Date;

@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FeedbackID")
    private int feedbackID;

    @ManyToOne
    @JoinColumn(name = "StudentID") 
    private Student student;   // here multiple feedback entries can be linked to a single student

    @Column(name = "Date")
    private Date date;

    @Column(name = "InstructorName")
    private String instructorName;

    @Column(name = "Feedback")
    private String feedback;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int feedbackID, Student student, Date date, String instructorName, String feedback) {
		super();
		this.feedbackID = feedbackID;
		this.student = student;
		this.date = date;
		this.instructorName = instructorName;
		this.feedback = feedback;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackID=" + feedbackID + ", student=" + student + ", "
				+ "date=" + date + ", instructorName="
				+ instructorName + ", feedback=" + feedback + "]";
	}

    
}


