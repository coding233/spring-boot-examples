package com.neo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NeoProperties {
	
	@Value("${com.neo.title}")
	private String title;
	@Value("${com.neo.description}")
	private String description;

	@Value("${com.neo.hdfsUrl}")
	private String hdfsUrl;

	@Value("${com.neo.hdfsName}")
	private String hdfsName;

	public String getHdfsUrl() {
		return hdfsUrl;
	}

	public void setHdfsUrl(String hdfsUrl) {
		this.hdfsUrl = hdfsUrl;
	}

	public String getHdfsName() {
		return hdfsName;
	}

	public void setHdfsName(String hdfsName) {
		this.hdfsName = hdfsName;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
