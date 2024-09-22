package com.question.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question create(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> get() {
		return questionRepository.findAll();
	}

	@Override
	public Question getOne(Long id) {
		return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("question not found"));
	}

	@Override
	public List<Question> getQuestionOfQuiz(Long quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
