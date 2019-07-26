package io.github.kk_mats.clone_io.abstract_io;


import io.github.kk_mats.clone_io.model.DetectionResult;

import java.nio.file.Path;


public abstract class DetectionResultOutput
{
	protected DetectionResultOutput()
	{}
	
	public abstract void output(final Path destination, final DetectionResult detectionResult);
}
