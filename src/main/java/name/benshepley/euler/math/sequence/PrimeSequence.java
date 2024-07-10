package name.benshepley.euler.math.sequence;

import name.benshepley.euler.framework.sequence.SequenceIndex;
import name.benshepley.euler.framework.sequence.SequenceStream;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.LongStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


/**
 * This class represents the sequence of numbers generated when finding prime numbers.
 * @author Ben Shepley
 */
public final class PrimeSequence implements SequenceStream, SequenceIndex {
    /* By File Method Variables */
    private final static String ZIP_FILE_LOCATION = "data/intPrimes.zip";
    private static AtomicBoolean fileAvailable = new AtomicBoolean(true);

    /* Sequence Variables */
    private static Vector<Long> PRIME_CACHE = new Vector<>();
    private int index = 0;

    @Override
    public LongStream generate() {
        return LongStream.generate(() -> {
            while (true) {
                if (index < PRIME_CACHE.size()) {
                    return PRIME_CACHE.get(index++);
                } else if (fileAvailable.get()) {
                    byFile();
                } else {
                    byAlgorithm();
                }
            }
        });
    }

    //TODO: Prime cache may not be up to index yet....
    @Override
    public long generate(long index) {
        return PRIME_CACHE.get((int) index);
    }

    private static synchronized void byFile() {
        /* 1: Find the zip file (if available). */
        Path zipPath;
        try {
            zipPath = Paths.get(ClassLoader.getSystemResource(ZIP_FILE_LOCATION).toURI());
        } catch (URISyntaxException e) {
            fileAvailable.set(false);
            return;
        }

        /* 2: Open the zip file and it's contents, then read into byte[]. */
        ZipInputStream zis = null;
        ZipEntry zipEntry = null;
        byte[] primesFile;
        try {
            zis = new ZipInputStream(new FileInputStream(zipPath.toFile()));
            zipEntry = zis.getNextEntry();
            primesFile = zis.readAllBytes();
        } catch (IOException e) {
            fileAvailable.set(false);
            return;
        } finally {
            try {
                if (zis != null) {
                    zis.closeEntry();
                }
                if (zipEntry != null) {
                    zis.close();
                }
            } catch (IOException e) {
                /* I don't care */
            }
        }

        /* 3: Convert the contents of the byte[] into integers. */
        var cursor = 0;
        var buffer = ByteBuffer.allocate(Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        while (cursor < primesFile.length) {
            byte[] bytes = {primesFile[cursor++], primesFile[cursor++], primesFile[cursor++], primesFile[cursor++]};
            buffer.put(bytes);
            buffer.flip();
            PRIME_CACHE.add((long) buffer.getInt());
            buffer.clear();
        }
    }

    //TODO:
    private static synchronized void byAlgorithm() {
        return;
    }


}
