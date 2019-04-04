import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.Question;
import model.Quiz;

public class ProfessorMain {

	public static void main(String[] args) {
		
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("ProfessorApp");
				frame.setSize(500,400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				Quiz quiz = TestSetupData();
				System.out.print(generateJsonString(quiz));
			}
		});
	}

	@SuppressWarnings("unchecked")
	protected static JSONObject generateJsonString(Quiz quiz) {

		JSONArray questionsJsonArray = new JSONArray();
		ArrayList<Question> questionList = quiz.getQuestions();
		for(Question question : questionList){
			JSONObject questionsJsonObject = new JSONObject();
			questionsJsonObject.put("title", question.getQuestionTitle());
			
			JSONArray optionsJsonArray = new JSONArray();
			for(String option : question.getOptions()){
				optionsJsonArray.add(option);
				
			}
			questionsJsonObject.put("options", optionsJsonArray);
			questionsJsonObject.put("correctAnswer", question.getCorrectAnswer());
			
			questionsJsonArray.add(questionsJsonObject);
		}
		
		JSONObject quizJsonObject = new JSONObject();
		quizJsonObject.put("questions",questionsJsonArray);
		
		return quizJsonObject;
		
		
	}

	protected static Quiz TestSetupData() {
		
		// Question 1 details
		Question q1 = new Question();
		q1.setQuestionTitle("Question 1");
		ArrayList<String> optionsQuestion1 = new ArrayList<String>();
		optionsQuestion1.add("Question1_Option1");
		optionsQuestion1.add("Question1_Option2");
		optionsQuestion1.add("Question1_Option3");
		optionsQuestion1.add("Question1_Option4");
		q1.setOptions(optionsQuestion1);
		q1.setCorrectAnswer("Question1_Option2");
		
		// Question 2 details
		Question q2 = new Question();
		q2.setQuestionTitle("Question 2");
		ArrayList<String> optionsQuestion2 = new ArrayList<String>();
		optionsQuestion2.add("Question2_Option1");
		optionsQuestion2.add("Question2_Option2");
		optionsQuestion2.add("Question2_Option3");
		optionsQuestion2.add("Question2_Option4");
		q2.setOptions(optionsQuestion2);
		q2.setCorrectAnswer("Question2_Option4");
		
		Quiz quiz = new Quiz();
		ArrayList<Question> questionsList = new ArrayList<Question>();
		questionsList.add(q1);
		questionsList.add(q2);
		
		quiz.setQuizName("Quiz_1");
		quiz.setQuestions(questionsList);
		
		
		return quiz;
	}

}
