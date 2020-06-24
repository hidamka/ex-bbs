package com.example.domain;

/**
 * commentsテーブルのドメインクラス.
 * 
 * @author hikaru.tsuda
 *
 */
public class Comment {
	
	/**	ID */
	private Integer id;
	/**	コメント者名 */
	private String name;
	/**	コメント内容 */
	private String contents;
	/**	記事ID */
	private Integer articleId;
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", contents=" + contents + ", articleId=" + articleId + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	

}
