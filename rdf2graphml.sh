java -jar ../rdf2rdf/target/rdf2rdf.jar data/model.ttl data/model2.ttl truncate.yml
java -jar ../rdf2xml/target/rdf2xml.jar data/model2.ttl data/model.graphml ../rdf2xml/rdf2graphml.xsl add data/model-edited.graphml
