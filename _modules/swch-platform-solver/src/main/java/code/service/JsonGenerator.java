package code.service;

import static code.configuration.Constants.javaDir;
import static code.configuration.Constants.jsonPath;
import static code.configuration.Constants.outputDir;

import com.sun.codemodel.JCodeModel;
import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import lombok.SneakyThrows;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.stereotype.Service;

@SuppressWarnings("RedundantMethodOverride")
@Service
public class JsonGenerator {

  @SneakyThrows
  public void convertJsonToJavaClass(
    String inputJsonFileName,
    String javaClassName
  ) {
    URI uri = getResource(inputJsonFileName);

    JCodeModel jcodeModel = new JCodeModel();

    GenerationConfig config = getConfig();

    SchemaMapper mapper = new SchemaMapper(
      new RuleFactory(
        config, new Jackson2Annotator(config),
        new SchemaStore()),
      new SchemaGenerator()
    );
    mapper.generate(jcodeModel, javaClassName, outputDir, uri.toURL());

    jcodeModel.build(new File(javaDir));
  }

  public URI getResource(String inputJsonFileName) {
    return Path.of(jsonPath + inputJsonFileName).toUri();
  }

  private DefaultGenerationConfig getConfig() {
    return new DefaultGenerationConfig() {

      @Override
      public boolean isIncludeHashcodeAndEquals() {
        return false;
      }

      @Override
      public boolean isIncludeGetters() {
        return false;
      }

      @Override
      public boolean isIncludeSetters() {
        return false;
      }

      @Override
      public boolean isIncludeDynamicSetters() {
        return false;
      }

      @Override
      public boolean isIncludeDynamicGetters() {
        return false;
      }

      @Override
      public boolean isIncludeAdditionalProperties() {
        return false;
      }

      @Override
      public boolean isIncludeToString() {
        return false;
      }

      @Override
      public boolean isIncludeConstructors() {
        return true;
      }

      @Override
      public SourceType getSourceType() {
        return SourceType.JSON;
      }

      @Override
      public boolean isIncludeDynamicAccessors() {
        return false;
      }

      @Override
      public boolean isIncludeConstructorPropertiesAnnotation() {
        return true;
      }

    };
  }
}