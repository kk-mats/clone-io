package io.github.kk_mats.clone_io.model;


public class SimilarityClassification extends CloneSimilarity
{
	public static final SimilarityClassification Type1=new SimilarityClassification(1);
	public static final SimilarityClassification Type2=new SimilarityClassification(2);
	public static final SimilarityClassification Type3=new SimilarityClassification(3);
	public static final SimilarityClassification Type4=new SimilarityClassification(4);

	private SimilarityClassification(final int value) throws IllegalArgumentException
	{
		super(value);
	}

	public SimilarityClassification create(final int value) throws IllegalArgumentException
	{
		switch(value)
		{
			case 1:
				return Type1;
			case 2:
				return Type2;
			case 3:
				return Type3;
			case 4:
				return Type4;
			default:
				throw new IllegalArgumentException("SimilarityClassification.value must meet 1<=value and value<=4");
		}
	}

	@Override
	public String toString()
	{
		return "Type-"+this.value;
	}

	@Override
	protected boolean isValid(final int value)
	{
		return 1<=value && value<=4;
	}
}
