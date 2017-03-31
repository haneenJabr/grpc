/**
 * 
 */
package com.progressoft.jpa.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author u538
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentBean {
	private String name;
	@XmlAttribute(name = "dept-id")
	private String deptNo;

	public DepartmentBean() {
	}

	public DepartmentBean(String name, String id) {
		this.name = name;
		this.deptNo = id;
	}

	public void setId(String id) {
		this.deptNo = id;
	}

	public String getId() {
		return deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
