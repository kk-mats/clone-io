package io.github.kk_mats.clone_io.model;

public abstract class CloneSimilarity
{
	protected final int value;

	public CloneSimilarity(final int value) throws IllegalArgumentException
	{
		if(!this.isValid(value))
		{
			throw new IllegalArgumentException();
		}
		this.value=value;
	}

	public int getValue()
	{
		return value;
	}

	@Override
	public abstract String toString();

	protected abstract boolean isValid(final int value);
}
