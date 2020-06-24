package com.example.form;

/**
 * 記事情報を受け取るフォームクラス.
 * 
 * @author hikaru.tsuda
 *
 */
public class ArticleForm {
	
	/**	投稿者名 */
	private String name;
	/**	投稿内容 */
	private String contents;
	
	@Override
	public String toString() {
		return "ArticleForm [name=" + name + ", contents=" + contents + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	

}
