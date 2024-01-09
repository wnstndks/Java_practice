package pack.controller.review;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReviewBean {
	private String review_id, customer_id,rating, comment, review_date, rimage;
	private int product_id;
	private MultipartFile rimagePath;
	public void setReview_date() {
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		this.review_date = year + "-" + month + "-" + day;
	}
}
