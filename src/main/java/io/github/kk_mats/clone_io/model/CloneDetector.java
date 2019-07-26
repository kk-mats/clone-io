package io.github.kk_mats.clone_io.model;


import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;


public class CloneDetector
{
	private final String name;
	private final String version;
	private HashMap<String, String> parameters;

	public CloneDetector(final String name, final String version) throws NullPointerException
	{
		this(name, version, new HashMap<>());
	}

	public CloneDetector(final String name, final String version, HashMap<String, String> parameters)
			throws NullPointerException
	{
		this.name=Objects.requireNonNull(name);
		this.version=version;
		this.parameters=Objects.requireNonNull(parameters);
	}

	public String getName()
	{
		return name;
	}
	
	public String getVersion()
	{
		return this.version;
	}

	public void setParameters(final HashMap<String, String> parameters)
	{
		this.parameters=parameters;
	}
	
	public void addParameter(final String parameterName, final String value)
	{
		this.parameters.put(parameterName, value);
	}
	
	public Optional<String> getParameterValueOf(final String parameterName)
	{
		return Optional.ofNullable(this.parameters.get(parameterName));
	}

}
