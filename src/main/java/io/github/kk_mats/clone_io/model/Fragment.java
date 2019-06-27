package io.github.kk_mats.clone_io.model;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


public class Fragment implements Comparable<Fragment>
{
	private Path location;
	private Position start;
	private Position end;

	public Fragment(final String location, final Position start, final Position end) throws NullPointerException
	{
		this.location=Paths.get(Objects.requireNonNull(location));
		this.start=Objects.requireNonNull(start);
		this.end=Objects.requireNonNull(end);
	}

	public Path getLocation()
	{
		return location;
	}

	public Position getStart()
	{
		return start;
	}

	public Position getEnd()
	{
		return end;
	}

	@Override
	public int compareTo(final Fragment other) throws NullPointerException
	{
		final int l=this.location.compareTo(Objects.requireNonNull(other).location);
		if(l!=0)
		{
			return l;
		}

		final int s=this.start.compareTo(other.start);
		if(s!=0)
		{
			return s;
		}

		return this.end.compareTo(other.end);
	}
}
