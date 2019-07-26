package io.github.kk_mats.clone_io.commons;


import org.mozilla.universalchardet.UniversalDetector;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;


public class CharsetDetector
{
	private static final int block_size=4096;
	private static byte[] buffer=new byte[block_size];
	private static UniversalDetector detector=new UniversalDetector(null);
	
	private CharsetDetector()
	{}

	public static Charset detect(final Path file) throws NullPointerException, IllegalArgumentException, IOException
	{
		detector.reset();
		var is=Files.newInputStream(Objects.requireNonNull(file), StandardOpenOption.READ);
		int loaded;
		while((loaded=is.read(buffer))>0 && !detector.isDone())
		{
			detector.handleData(buffer, 0, loaded);
		}

		detector.dataEnd();
		final var detected=detector.getDetectedCharset();
		return detected!=null ? Charset.forName(detected) : Charset.defaultCharset();
	}
}
