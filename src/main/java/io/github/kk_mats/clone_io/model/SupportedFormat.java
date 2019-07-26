package io.github.kk_mats.clone_io.model;


import java.util.Arrays;
import java.util.HashSet;


public enum SupportedFormat
{
	CCFinderX("10.2.7.2"), CCVolti(null), CCFinderSW("1.0"), NiCad("5.1"), OpenJCF("1.0"), OpenCF("1.0");
	
	private final HashSet<String> versions=new HashSet<>();
	
	SupportedFormat(final String head, final String... tail)
	{
		this.versions.add(head);
		this.versions.addAll(Arrays.asList(tail));
	}
	
	public boolean isSupported(final String version)
	{
		return this.versions.contains(version);
	}
}
