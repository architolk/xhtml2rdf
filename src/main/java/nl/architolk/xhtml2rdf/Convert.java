package nl.architolk.xhtml2rdf;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.any23.Any23;
import org.apache.any23.writer.TripleHandler;
import org.apache.any23.writer.TurtleWriter;
import org.apache.any23.source.DocumentSource;
import org.apache.any23.source.FileDocumentSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Convert {

  private static final Logger LOG = LoggerFactory.getLogger(Convert.class);

  public static void main(String[] args) {

    if (args.length == 2) {

      LOG.info("Starting conversion");
      LOG.info("Input file: {}",args[0]);
      LOG.info("Ouput file: {}",args[1]);

      try {
        Any23 runner = new Any23();
        DocumentSource source = new FileDocumentSource(new File(args[0]));
        FileOutputStream out = new FileOutputStream(new File(args[1]));
        TripleHandler handler = new TurtleWriter(out);
        try {
          runner.extract(source, handler);
        } finally {
          handler.close();
        }

        LOG.info("Done!");
      }
      catch (Exception e) {
        LOG.error(e.getMessage(),e);
      }
    } else {
      LOG.info("Usage: xhtml2rdf <input.xhtml> <output.tt>");
    }
  }
}
