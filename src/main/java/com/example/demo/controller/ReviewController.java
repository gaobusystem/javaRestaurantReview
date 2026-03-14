package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ReviewRegistForm;

@Controller
public class ReviewController {

	/*--- レビュー登録画面表示リクエスト ---*/
	@GetMapping("/show-review-form")
	public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}

	/*--- レビュー登録画面表示リクエスト（確認画面からの戻り） ---*/
	@PostMapping("/show-review-form-ret")
	public String showReviewFormRet(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}

	/*--- レビュー登録リクエスト（登録画面より） ---*/
	@PostMapping("/regist-review")
	public String registReview(
			@Validated @ModelAttribute ReviewRegistForm form,
			BindingResult result) {

		// 入力エラーがある場合には レビュー登録画面に戻す
		if (result.hasErrors()) {
			return "regist-review";
		}
		
		// 正常な場合に レビュー登録確認画面に 遷移する
		return "confirm-regist-review";
	}

	/*--- レビュー登録リクエスト（登録確認画面より） ---*/
	@PostMapping("/confirm-regist-review")
	public String confirmRegistReview(
			@Validated ReviewRegistForm form,
			BindingResult result,
			Model model) {

		// 入力エラーがある場合には レビュー登録画面に戻す
		if (result.hasErrors()) {
			return "regist-review";
		}

		//
		// *** ここで from 内容で DB登録処理を行う ***
		//

		model.addAttribute("msg", "レビュー登録が完了しました。");
		
		return "complete-regist-review";
	}

}
