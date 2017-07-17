package com.zycus.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zycus.model.ResultEntity;
import com.zycus.model.UserSubmissionEntity;
import com.zycus.utility.StatusEnum;

@Service
public class CompileExecuteService {
	public StatusEnum compile(String pathName) {
		ProcessBuilder p = new ProcessBuilder("javac", pathName);
		setProperties(p);
		try {
			return checkCompileStatus(p, true);
		} catch (IOException | InterruptedException e) {
			System.out.println("in compile() " + e);
		}
		return StatusEnum.COMPILE_ERROR;
	}

	private StatusEnum checkCompileStatus(ProcessBuilder p, boolean compiled)
			throws IOException, InterruptedException {
		Process pp = p.start();
		InputStream is = pp.getInputStream();
		compiled = getErrorMessage(compiled, is);
		pp.waitFor();
		is.close();
		if (!compiled)
			return StatusEnum.COMPILE_ERROR;
		return StatusEnum.COMPILE_SUCCESS;
	}

	private boolean getErrorMessage(boolean compiled, InputStream is)
			throws IOException {
		String temp;
		BufferedReader b = new BufferedReader(new InputStreamReader(is));
		while ((temp = b.readLine()) != null) {
			compiled = false;
			System.out.println(temp);
		}
		return compiled;
	}

	public void execute(String pathName, String userId) throws IOException {
		int index = 0;
		List<String> inputList = getInputList();
		List<String> outputList = getOutputList();
		ProcessBuilder p = new ProcessBuilder("java", pathName);
		setProperties(p);
		try {
			index = runForEachTestCase(userId, index, inputList, outputList, p);
		} catch (IOException | InterruptedException ioe) {
			System.err.println("in execute() " + ioe);
		}
	}

	private void setProperties(ProcessBuilder p) {
		p.directory(new File(System.getProperty("dir")));
		p.redirectErrorStream(true);
	}

	private int runForEachTestCase(String userId, int index,
			List<String> inputList, List<String> outputList, ProcessBuilder p)
			throws IOException, InterruptedException {
		for (String input : inputList) {
			long startTime = System.nanoTime();
			Process process = runProgram(p, input);
			long endTime = System.nanoTime();
			if (checkCompilationError(userId, process, startTime, endTime))
				saveResult(userId, (endTime - startTime), false, 0L);
			else
				index = compileSuccessfully(userId, index, outputList, process,
						startTime, endTime);
		}
		return index;
	}

	private Process runProgram(ProcessBuilder p, String input)
			throws IOException, InterruptedException {
		Process process;
		process = p.start();
		OutputStream outputStream = process.getOutputStream();
		outputStream.write(input.getBytes());
		outputStream.flush();
		outputStream.close();
		process.waitFor();
		return process;
	}

	private int compileSuccessfully(String userId, int index,
			List<String> outputList, Process process, long startTime,
			long endTime) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		int result = Integer.parseInt(br.readLine());
		long memoryUsed = Long.parseLong(br.readLine());
		br.close();
		boolean testCasebit = isTestCasePass(index, outputList, result);
		saveResult(userId, (endTime - startTime), testCasebit, memoryUsed);
		return ++index;
	}

	private boolean checkCompilationError(String userId, Process process,
			long startTime, long endTime) {
		if (process.exitValue() != 0)
			return true;
		return false;
	}

	private boolean isTestCasePass(int index, List<String> outputList,
			int result) {
		boolean testCasebit = false;
		if (result == Integer.parseInt(outputList.get(index)))
			testCasebit = true;
		return testCasebit;
	}

	private ResultEntity saveResult(String userId, long timeTaken,
			boolean testCasebit, long memoryUsed) {
		ResultEntity result = new ResultEntity();
		result.setTestCasebit(testCasebit);
		result.setMemoryConsumed(memoryUsed);
		result.setTimeTaken(timeTaken);
		result.setUserSubmission(new UserSubmissionEntity(Integer
				.parseInt(userId)));
		System.out.println(result.toString());
		return result;
	}

	private List<String> getOutputList() {
		// Write code to fetch outputList from DB
		List<String> outputList = new ArrayList<String>();
		outputList.add("6");
		outputList.add("8");
		outputList.add("10");
		outputList.add("12");
		return outputList;
	}

	private List<String> getInputList() {
		// Write code to fetch inputList from DB
		List<String> inputList = new ArrayList<String>();
		inputList.add("2 4");
		inputList.add("3 5");
		inputList.add("4 6");
		inputList.add("5 7");
		return inputList;
	}

}
