package io.github.kk_mats.clone_io.model;


import java.util.Objects;


public class Position implements Comparable<Position>
{
	private int lineNumber;
	private int columnNumber;

	public Position(final int lineNumber, final int columnNumber)
	{
		this.lineNumber=lineNumber;
		this.columnNumber=columnNumber;
	}

	public Position(final int lineNumber)
	{
		this(lineNumber, 0);
	}

	public int getColumnNumber()
	{
		return columnNumber;
	}

	public int getLineNumber()
	{
		return lineNumber;
	}

	@Override
	public int compareTo(final Position other) throws NullPointerException
	{
		if(this.lineNumber<Objects.requireNonNull(other).lineNumber)
		{
			return -1;
		}
		else if(this.lineNumber>other.lineNumber)
		{
			return 1;
		}

		return Integer.compare(this.columnNumber, other.columnNumber);
	}
}
