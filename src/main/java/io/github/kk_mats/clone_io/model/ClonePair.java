package io.github.kk_mats.clone_io.model;


import java.util.Objects;

public class ClonePair
{
	private Fragment first, second;
	private CloneSimilarity similarity;

	public ClonePair(final Fragment fragment1, final Fragment fragment2, final CloneSimilarity similarity)
			throws NullPointerException
	{
		this.similarity=similarity;

		if(Objects.requireNonNull(fragment1).compareTo(Objects.requireNonNull(fragment2))<0)
		{
			this.first=fragment1;
			this.second=fragment2;
			return;
		}
		this.first=fragment2;
		this.second=fragment1;
	}

	public Fragment getFirstFragment()
	{
		return first;
	}

	public Fragment getSecondFragment()
	{
		return second;
	}

	public CloneSimilarity getSimilarity()
	{
		return similarity;
	}
}
