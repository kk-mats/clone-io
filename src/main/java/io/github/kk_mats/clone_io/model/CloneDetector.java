package io.github.kk_mats.clone_io.model;


import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;


public class CloneDetector
{
	private final String name;
	private final String version;
	private HashMap<String, String> parameters;

	public CloneDetector(final String name) throws NullPointerException
	{
		this(name, "", new HashMap<>());
	}

	public CloneDetector(final String name, final String version) throws NullPointerException
	{
		this(name, "", new HashMap<>());
	}

	public CloneDetector(final String name, final String version, HashMap<String, String> parameters)
			throws NullPointerException
	{
		this.name=Objects.requireNonNull(name);
		this.version=Objects.requireNonNull(version);
		this.parameters=parameters;
	}

	public String getName()
	{
		return name;
	}

	public Optional<String> getVersion()
	{
		return Optional.ofNullable(this.version);
	}

	public void setParameters(final HashMap<String, String> parameters)
	{
		this.parameters=parameters;
	}

	public void addParamter(final String paramterName, final String value)
	{
		this.parameters.put(paramterName, value);
	}

	public Optional<String> getParameterValueOf(final String paramterName)
	{
		return Optional.ofNullable(this.parameters.get(paramterName));
	}
}
