package io.github.kk_mats.clone_io.model;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;


public class DetectionResult
{
	private final Environment environment;
	private ArrayList<ClonePair> clonePairs;

	public DetectionResult(final String cloneSource, final String cloneDetectorName) throws NullPointerException
	{
		this(cloneSource, new CloneDetector(cloneDetectorName));
	}

	public DetectionResult(final String cloneSource, final CloneDetector cloneDetector) throws NullPointerException
	{
		this.environment=new Environment(cloneSource, cloneDetector);
	}

	public DetectionResult(final Environment environment) throws NullPointerException
	{
		this(environment, new ArrayList<>());
	}

	public DetectionResult(final Environment environment, final ArrayList<ClonePair> clonePairs)
			throws NullPointerException
	{
		this.environment=Objects.requireNonNull(environment);
		this.clonePairs=Objects.requireNonNull(clonePairs);
	}

	public Environment getEnvironment()
	{
		return environment;
	}

	public int size()
	{
		return this.clonePairs.size();
	}


	public boolean addClonePair(final Fragment fragment1, final Fragment fragment2, final CloneSimilarity similarity)
			throws NullPointerException
	{
		return this.addClonePair(new ClonePair(fragment1, fragment2, similarity));
	}

	public boolean addClonePair(final ClonePair clonePair) throws NullPointerException
	{
		return this.clonePairs.add(clonePair);
	}


	public class Environment
	{
		private final Path cloneSource;
		private final CloneDetector cloneDetector;

		public Environment(final String cloneSource, final CloneDetector cloneDetector) throws NullPointerException
		{
			this.cloneSource=Paths.get(Objects.requireNonNull(cloneSource));
			this.cloneDetector=Objects.requireNonNull(cloneDetector);
		}

		public Path getCloneSource()
		{
			return cloneSource;
		}

		public CloneDetector getCloneDetector()
		{
			return cloneDetector;
		}
	}


}
