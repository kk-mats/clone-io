package io.github.kk_mats.clone_io.model;


import java.util.ArrayList;
import java.util.Arrays;


public class DetectionResults
{
	private ArrayList<DetectionResult> results;

	public DetectionResults(DetectionResult... results)
	{
		this.results=new ArrayList<>(Arrays.asList(results));
	}

	public DetectionResult get(final int index) throws IndexOutOfBoundsException
	{
		return results.get(index);
	}
}
