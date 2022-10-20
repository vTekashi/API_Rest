package br.com.residencia.biblioteca.dto.imgbb;

public class Image {
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Image [fileName=" + fileName + "]";
	}
	
}
