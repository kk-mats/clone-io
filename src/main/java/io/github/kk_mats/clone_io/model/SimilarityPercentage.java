package io.github.kk_mats.clone_io.model;


import java.util.Objects;

public class SimilarityPercentage extends CloneSimilarity
{
	public SimilarityPercentage(final int value) throws IllegalArgumentException
	{
		super(value);
	}

	SimilarityPercentage fromString(final String valueString) throws IllegalArgumentException, NullPointerException
	{
		return new SimilarityPercentage(Integer.parseInt(Objects.requireNonNull(valueString)));
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
