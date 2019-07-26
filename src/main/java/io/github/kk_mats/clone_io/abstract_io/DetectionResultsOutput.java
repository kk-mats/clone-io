package io.github.kk_mats.clone_io.abstract_io;


import io.github.kk_mats.clone_io.model.DetectionResults;

import java.nio.file.Path;


public abstract class DetectionResultsOutput
{
	public abstract void output(final Path destination, final DetectionResults detectionResults);
	
	
}
