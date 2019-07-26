package io.github.kk_mats.clone_io.ccvolti_io;


import io.github.kk_mats.clone_io.abstract_io.DetectionResultInput;
import io.github.kk_mats.clone_io.commons.CharsetDetector;
import io.github.kk_mats.clone_io.model.DetectionResult;
import io.github.kk_mats.clone_io.model.Fragment;
import io.github.kk_mats.clone_io.model.SimilarityPercentage;
import io.github.kk_mats.clone_io.model.SupportedFormat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class CCVoltiInput extends DetectionResultInput
{
	private static final String A_CLASS_NAME="A class name";
	private static final String A_START_LINE="A start line";
	private static final String A_END_LINE="A end line";
	private static final String B_CLASS_NAME="B class name";
	private static final String B_START_LINE="B start line";
	private static final String B_END_LINE="B end line";
	private static final String SIMILARITY="similarity";
	private HashMap<String, Integer> header=new HashMap<>();
	private DetectionResult result;
	
	protected CCVoltiInput()
	{
		super();
		this.header.put(A_CLASS_NAME, -1);
		this.header.put(A_START_LINE, -1);
		this.header.put(A_END_LINE, -1);
		this.header.put(B_CLASS_NAME, -1);
		this.header.put(B_START_LINE, -1);
		this.header.put(B_END_LINE, -1);
		this.header.put(SIMILARITY, -1);
	}
	
	@Override
	protected Optional<DetectionResult> readDetectionResult(final Path sourceFile)
			throws NullPointerException, IllegalArgumentException, IOException
	{
		var lines=Files.readAllLines(sourceFile, CharsetDetector.detect(sourceFile));
		
		if(lines.isEmpty() || !this.readHeader(lines.get(0)))
		{
			return Optional.empty();
		}
		
		lines.remove(0);
		this.result=new DetectionResult(sourceFile, SupportedFormat.CCVolti.name());
		
		// return Optional.empty() when one of the executions of this.readClonePair()
		if(!lines.parallelStream().map(this::readClonePair).reduce(true, Boolean::logicalAnd))
		{
			return Optional.empty();
		}
		
		return Optional.of(this.result);
	}
	
	private boolean readHeader(final String line)
	{
		final var headerElements=this.splitIntoElements(line);
		for(final var key : this.header.keySet())
		{
			final var index=headerElements.indexOf(key);
			
			// fail if a necessary header name does not exist
			if(index==-1)
			{
				return false;
			}
			this.header.put(key, index);
		}
		return true;
	}
	
	private boolean readClonePair(final String line)
	{
		try
		{
			final var elements=this.splitIntoElements(line);
			this.result.addClonePair(new Fragment(
					elements.get(this.header.get(A_CLASS_NAME)), elements.get(this.header.get(A_START_LINE)),
					elements.get(this.header.get(A_END_LINE))
			), new Fragment(elements.get(this.header.get(B_CLASS_NAME)), elements.get(this.header.get(B_START_LINE)),
			                elements.get(this.header.get(B_END_LINE))
			), SimilarityPercentage.fromFloatString(elements.get(this.header.get(SIMILARITY))));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	private List<String> splitIntoElements(final String line)
	{
		return Arrays.asList(Stream.of(line.split(",")).map(String::trim).toArray(String[]::new));
	}
}
