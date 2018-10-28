package org.gabrielcurio.tutorials.beam.wordcount.options;


import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.Validation;
import org.gabrielcurio.tutorials.beam.wordcount.WordCountApp;

/**
 * Options supported by {@link WordCountApp}.
 *
 * <p>Concept #4: Defining your own configuration options. Here, you can add your own arguments to
 * be processed by the command-line parser, and specify default values for them. You can then
 * access the options values in your pipeline code.
 *
 * <p>Inherits standard configuration options.
 */
public interface WordCountOptions extends PipelineOptions {

    /**
     * By default, this example reads from a public dataset containing the text of King Lear. Set
     * this option to choose a different input file or glob.
     */
    @Description("Path of the file to read from")
    @Default.String("gs://apache-beam-samples/shakespeare/kinglear.txt")
    String getInputFile();

    void setInputFile(String value);

    /** Set this required option to specify where to write the output. */
    @Description("Path of the file to write to")
    @Validation.Required
    String getOutput();

    void setOutput(String value);
}