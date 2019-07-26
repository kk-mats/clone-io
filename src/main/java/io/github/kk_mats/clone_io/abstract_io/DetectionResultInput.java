package io.github.kk_mats.clone_io.abstract_io;


import io.github.kk_mats.clone_io.model.DetectionResult;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;


public abstract class DetectionResultInput
{
	protected DetectionResultInput()
	{}
	
	public final Optional<DetectionResult> load(final Path sourceFile) throws NullPointerException, IOException
	{
		return this.readDetectionResult(Objects.requireNonNull(sourceFile));
	}
	
	protected abstract Optional<DetectionResult> readDetectionResult(final Path sourceFile)
			throws NullPointerException, IllegalArgumentException, IOException;
}
