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

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleRepository repository;

	@ModelAttribute
	public ArticleForm setUpForm() {
		return new ArticleForm();
	}

	@RequestMapping("")
	public String index() {
		return "bbs";
	}

	@RequestMapping("/insertArticle")
	public String insertArticle(ArticleForm form, Model model) {
		Article article = new Article();
		article.setName(form.getName());
		article.setContent(form.getContents());
		repository.insert(article);
		List<Article> articleList = repository.findAll();
		model.addAttribute("articleList", articleList);
		return "bbs";
	}

}
