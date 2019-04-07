package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Answer;
import com.example.demo.domain.AnswerRepository;
import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionRepository;


@Controller
public class FormController {

	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired 
	private AnswerRepository aRepo;
	
	//Question list
	@RequestMapping(value="/list")
	public String getFormList(Model model) {
		List<Question> questions = (List<Question>) qRepo.findAll();
		model.addAttribute("questions", questions);
		return "notaform";
	}
	
	//Question form
	@RequestMapping(value="/form")
	public String getForm(Model model) {
		model.addAttribute("questions", qRepo.findAll());
		model.addAttribute("answer", aRepo.findAll());
		return "singleform";
	}
	
	
	
	//Submit form
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute Answer answer) {
		aRepo.save(answer);
		return "redirect:/singleform";
	}
	
	//RESTful service to get all questions
	@RequestMapping(value="/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> getQuestionRest(){
		return (List<Question>) qRepo.findAll();
	}
	
	//RESTful service to get one questions
	@RequestMapping(value="/question/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Question> findquestionRest(@PathVariable("id") Long id) {
		return qRepo.findById(id);
	}
	
	//RESTful service to get all answers
	@RequestMapping(value="/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> getAnswerRest(){
		return (List<Answer>) aRepo.findAll();
	}
}
