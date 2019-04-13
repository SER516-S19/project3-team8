/**
 * 
 */
package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Quiz;

/**
 * Singleton File manager class to create json file and read the files
 * 
 * @author ishansarangi
 *
 */
public class FileManager {

	/**
	 * 
	 */
	private static FileManager __instance;
	private Quiz quiz = null;

	private String quizDirectoryPath;

	private FileManager() {
	}

	public static FileManager getInstance() {
		if (__instance == null) {
			__instance = new FileManager();
		}
		return __instance;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public void setQuizDirectoryPath(File file) {
		this.quizDirectoryPath = file.getAbsolutePath();
	}

	public List<String> getQuizFileList() throws FileNotFoundException {
		List<String> quizList = new ArrayList<>();
		File file = new File(this.quizDirectoryPath);
		if (!file.exists()) {
			throw new FileNotFoundException("Directory doesn't exist at: " + this.quizDirectoryPath);
		}
		String[] fileList = file.list();
		for (String name : fileList) {
			quizList.add(name);
			System.out.println(name);
		}
		return quizList;

	}

	public boolean writeFile(Quiz quiz) throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(quiz);
		PrintWriter writer = null;
		try {
			String fullpath = this.quizDirectoryPath + "/" + quiz.getName() + ".json";
			writer = new PrintWriter(new FileOutputStream(fullpath));
			writer.println(json);
		} catch (Exception exc) {
			exc.printStackTrace();
			throw exc;
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				throw e;
			}
		}
		return true;
	}

	public Quiz readFile(String fileName) throws FileNotFoundException, IOException {

		BufferedReader bufferReader = null;
		try {
			String fullpath = quizDirectoryPath + "/" + fileName + ".json";
			bufferReader = new BufferedReader(new FileReader(fullpath));

			this.quiz = new Gson().fromJson(bufferReader, Quiz.class);
			this.quiz.setName(fileName);
			System.out.println(this.quiz);

			return this.quiz;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				bufferReader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
}
