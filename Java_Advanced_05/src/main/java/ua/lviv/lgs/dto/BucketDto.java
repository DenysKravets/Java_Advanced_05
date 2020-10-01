package ua.lviv.lgs.dto;

import java.time.LocalDateTime;

public class BucketDto {
	
	public Integer bucketId;
	public String name;
	public String description;
	public Double price;
	public LocalDateTime purchaseDate;
	
	public BucketDto(Integer bucketId, String name, String description, Double price, LocalDateTime purchaseDate) {
		this.bucketId = bucketId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.purchaseDate = purchaseDate;
	}
}
