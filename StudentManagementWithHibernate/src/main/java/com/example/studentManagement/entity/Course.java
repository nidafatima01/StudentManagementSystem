package com.example.studentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
  CourseID (Primary Key)
   CourseTitle
   Credits
 */

@Entity
@Table(name = "Course")
public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private int id;

	@Column(name = "CourseTitle")
    private String title;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Column(name = "Credits")
    private int credit;

	public Course(  String title, int credit) {
		super();
		this.title = title;
		this.credit = credit;
	}

    @Override
	public String toString() {
		return "Course [title=" + title + ", credit=" + credit + "]";
	}
}
