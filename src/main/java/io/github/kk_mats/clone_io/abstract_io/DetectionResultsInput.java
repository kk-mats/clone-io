package io.github.kk_mats.clone_io.abstract_io;


import io.github.kk_mats.clone_io.model.DetectionResults;

import java.io.IOException;
import java.nio.file.Path;


public abstract class DetectionResultsInput
{
	public abstract DetectionResults load(final Path sourceFile) throws NullPointerException, IOException;
}
