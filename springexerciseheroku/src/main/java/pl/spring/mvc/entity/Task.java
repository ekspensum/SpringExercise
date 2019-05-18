package pl.spring.mvc.entity;

import java.util.Base64;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(min=2, max=20)
	@Pattern(regexp="^[^|'\":%^#~}{\\]\\[;=<>`]*$")
	private String subject;
	
	@NotNull
	@Future
//	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
	private Date dateTimeStart;
	
	@NotNull
	@Future
//	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
	private Date dateTimeEnd;
	
	@NotNull
	@Min(value=1)
	private Integer taskNo;
	
	@Size(min=0, max=100000)
	private byte[] image;
	
	@Transient
	protected String base64Image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDateTimeStart() {
		return dateTimeStart;
	}
	public void setDateTimeStart(Date dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}
	public Date getDateTimeEnd() {
		return dateTimeEnd;
	}
	public void setDateTimeEnd(Date dateTimeEnd) {
		this.dateTimeEnd = dateTimeEnd;
	}
	public Integer getTaskNo() {
		return taskNo;
	}
	public void setTaskNo(Integer taskNo) {
		this.taskNo = taskNo;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getBase64Image() {
		return Base64.getEncoder().encodeToString(this.image);
	}
}
