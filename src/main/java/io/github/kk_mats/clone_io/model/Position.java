package io.github.kk_mats.clone_io.model;


import java.util.Objects;


public class Position implements Comparable<Position>
{
	private static final int columnUndefined=-1;
	private final int line;
	private final int column;

	public Position(final int line, final int column)
	{
		this.line=line;
		this.column=column;
	}

	public Position(final int line)
	{
		this(line, columnUndefined);
	}

	public boolean hasColumn()
	{
		return this.column!=columnUndefined;
	}

	public int getColumn()
	{
		return column;
	}

	public int getLine()
	{
		return line;
	}

	@Override
	public int compareTo(final Position other) throws NullPointerException
	{
		if(this.line<Objects.requireNonNull(other).line)
		{
			return -1;
		}
		else if(this.line>other.line)
		{
			return 1;
		}

		return Integer.compare(this.column, other.column);
	}
}
