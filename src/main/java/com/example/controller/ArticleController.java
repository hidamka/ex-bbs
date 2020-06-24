package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.repository.ArticleRepository;

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
	private ArticleRepository repository;

	@ModelAttribute
	public ArticleForm setUpForm() {
		return new ArticleForm();
	}

	/**
	 * 全記事一覧を渡して掲示板画面にフォワード.
	 * 
	 * @param model　
	 * @return　リクエストスコープに全記事一覧情報を格納
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<Article> articleList = repository.findAll();
		model.addAttribute("articleList", articleList);
		return "bbs";
	}

	/**
	 * フォームクラスから新規記事情報を受け取ってテーブルに格納.
	 * 
	 * @param form　記事フォーム
	 * @return　掲示板画面にフォワード.
	 */
	@RequestMapping("/insertArticle")
	public String insertArticle(ArticleForm form) {
		Article article = new Article();
		article.setName(form.getName());
		article.setContent(form.getContent());
		repository.insert(article);
		
		return "redirect:/article";
	}

}
