package com.example.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.form.ArticleForm;
import com.example.form.CommentForm;
import com.example.repository.ArticleRepository;
import com.example.repository.CommentRepository;

/**
 * 記事情報を操作するコントローラー.
 * 
 * @author hikaru.tsuda
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CommentRepository commentRepository;

	@ModelAttribute
	public ArticleForm setUpArticleForm() {
		return new ArticleForm();
	}

	@ModelAttribute
	public CommentForm setUpCommentForm() {
		return new CommentForm();
	}

	/**
	 * 全記事情報一覧を渡して掲示板画面にフォワード.
	 * 
	 * @param model
	 * @return リクエストスコープに全記事一覧情報を格納
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Article> articleList = articleRepository.findAll();

		// 記事情報リストの各記事情報にコメント情報リストを格納する.
		for (Article article : articleList) {
			List<Comment> commentList = commentRepository.findByArticleId(article.getId());
			article.setCommentList(commentList);
		}
		model.addAttribute("articleList", articleList);

		// List<Comment> commentList = commentRepository.findByArticleId()
		return "bbs";
	}

	/**
	 * フォームクラスから新規記事情報を受け取ってテーブルに格納.
	 * 
	 * @param form 記事フォーム
	 * @return 掲示板画面にフォワード.
	 */
	@RequestMapping("/insertArticle")
	public String insertArticle(ArticleForm form) {
		Article article = new Article();
		BeanUtils.copyProperties(form, article);
		articleRepository.insert(article);

		return "redirect:/article";
	}

	/**
	 * フォームクラスから新規記事情報を受け取ってテーブルに格納.
	 * 
	 * @param form　コメントフォーム
	 * @return　掲示板画面にフォワード
	 */
	@RequestMapping("/insertComment")
	public String insertComment(CommentForm form) {
		Comment comment = new Comment();
		BeanUtils.copyProperties(form, comment);
		commentRepository.insert(comment);

		return "redirect:/article";
	}

}
