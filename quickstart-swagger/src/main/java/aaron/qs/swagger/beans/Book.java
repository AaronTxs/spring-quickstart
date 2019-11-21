package aaron.qs.swagger.beans;

import lombok.Data;
import java.util.Date;

@Data
public class Book {
	private Long id;
	private String name;
	private Integer price;
	private String author;
	private Date publishDate;
}