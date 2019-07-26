package io.github.kk_mats.clone_io.model;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;


public class DetectionResult
{
	private final Environment environment;
	private ArrayList<ClonePair> clonePairs;

	public DetectionResult(final Path cloneSource, final String cloneDetectorName) throws NullPointerException
	{
		this(cloneSource, new CloneDetector(cloneDetectorName, null));
	}

	public DetectionResult(final Path cloneSource, final CloneDetector cloneDetector) throws NullPointerException
	{
		this.environment=new Environment(cloneSource, cloneDetector);
		this.clonePairs=new ArrayList<>();
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
		return this.environment;
	}
	
	public ArrayList<ClonePair> getClonePairs()
	{
		return clonePairs;
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
	
	synchronized public boolean addClonePair(final ClonePair clonePair) throws NullPointerException
	{
		return this.clonePairs.add(clonePair);
	}


	public class Environment
	{
		private final Path cloneSource;
		private Path detectionTarget;
		private String resultName;
		private final CloneDetector cloneDetector;

		public Environment(final Path cloneSource, final CloneDetector cloneDetector) throws NullPointerException
		{
			this(cloneSource, null, cloneSource.toString(), cloneDetector);
		}

		public Environment(final Path cloneSource, final Path detectionTarget, CloneDetector cloneDetector)
				throws NullPointerException
		{
			this(cloneSource, detectionTarget, null, cloneDetector);
		}

		public Environment(final Path cloneSource, final String resultName, final CloneDetector cloneDetector)
				throws NullPointerException
		{
			this(cloneSource, null, resultName, cloneDetector);
		}

		public Environment(final Path cloneSource, final Path detectionTarget, final String resultName,
		                   final CloneDetector cloneDetector)
		{
			this.cloneSource=Objects.requireNonNull(cloneSource);
			this.detectionTarget=detectionTarget;
			this.resultName=Objects.requireNonNull(resultName);
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

		public void setResultName(final String resultName)
		{
			this.resultName=resultName;
		}

		public void setDetectionTarget(final Path detectionTarget)
		{
			this.detectionTarget=detectionTarget;
		}
	}
}
