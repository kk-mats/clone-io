package io.github.kk_mats.clone_io.model;


import java.util.Objects;

public class SimilarityPercentage extends CloneSimilarity
{
	public SimilarityPercentage(final int value) throws IllegalArgumentException
	{
		super(value);
	}
	
	public SimilarityPercentage(final float value) throws IllegalArgumentException
	{
		super((int) (value*100));
	}
	
	static public SimilarityPercentage fromIntString(final String intString)
			throws NullPointerException, NumberFormatException
	{
		return new SimilarityPercentage(Integer.parseInt(Objects.requireNonNull(intString)));
	}
	
	static public SimilarityPercentage fromFloatString(final String floatString)
			throws NullPointerException, NumberFormatException
	{
		return new SimilarityPercentage(Float.parseFloat(Objects.requireNonNull(floatString)));
	}
	
	@Override
	public String toString()
	{
		return this.value+"%";
	}

	@Override
	protected boolean isValid(final int value)
	{
		return 0<=value && value<=100;
	}
}
