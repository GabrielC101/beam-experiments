package org.gabrielcurio.tutorials.beam.pipelineBuilders;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.MapElements;
import org.gabrielcurio.tutorials.beam.options.WordCountOptions;
import org.gabrielcurio.tutorials.beam.transforms.CountWords;
import org.gabrielcurio.tutorials.beam.transforms.simplefunctions.FormatAsTextFn;

public class WordCountPipelineBuilder {


    public static Pipeline build(WordCountOptions options) {
        Pipeline p = Pipeline.create(options);

        // Concepts #2 and #3: Our pipeline applies the composite CountWords transform, and passes the
        // static FormatAsTextFn() to the ParDo transform.
        p.apply("ReadLines", TextIO.read().from(options.getInputFile()))
                .apply(new CountWords())
                .apply(MapElements.via(new FormatAsTextFn()))
                .apply("WriteCounts", TextIO.write().to(options.getOutput()));
        return p;
    }
}
