package io.github.mlanlazc.models;

@lombok.Getter
@lombok.EqualsAndHashCode(callSuper = false)
@lombok.ToString
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.databind.annotation.JsonDeserialize(builder = Error.Builder.class)
public class Error extends io.github.mlanlazc.models.BaseModel {

  @lombok.Getter
  @lombok.Setter
  @lombok.experimental.Accessors(chain = true)
  @com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder(
    buildMethodName = "buildWithoutValidation",
    withPrefix = "set"
  )
  public static class Builder extends io.github.mlanlazc.models.BaseModel.Builder {

    static final java.util.Set<java.util.Set<String>> REQUIRED_FIELDS_GROUPS;

    static {
      java.lang.String[][] requiredFieldsGroups = new java.lang.String[][] {
        new java.lang.String[] { "code", "message" },
      };

      REQUIRED_FIELDS_GROUPS =
        java.util.Arrays
          .stream(requiredFieldsGroups)
          .map(group -> java.util.Arrays.stream(group).collect(java.util.stream.Collectors.toSet()))
          .collect(java.util.stream.Collectors.toSet());
    }

    @com.fasterxml.jackson.annotation.JsonProperty("code")
    private java.lang.Long code;

    @com.fasterxml.jackson.annotation.JsonProperty("message")
    private java.lang.String message;

    public Builder() {
      super(ValidationType.ALL_OF);
    }

    protected Builder(BaseModel.Builder.ValidationType validationType) {
      super(validationType);
    }

    public Error build() {
      String validateMsg = validate();

      if (validateMsg != null) {
        throw new io.github.mlanlazc.exceptions.ApiException(validateMsg);
      }

      return buildWithoutValidation();
    }

    public Error buildWithoutValidation() {
      return new Error(this);
    }

    @Override
    protected java.util.Set<String> getNonNullInstanceFieldNames() {
      // Introspect the class to get a list of all declared fields.
      return java.util.Arrays
        .stream(this.getClass().getDeclaredFields())
        .filter(field -> {
          try {
            // Filter fields that are non-static and have values that are not null.
            return (!java.lang.reflect.Modifier.isStatic(field.getModifiers()) && field.get(this) != null);
          } catch (IllegalArgumentException | IllegalAccessException e) {
            // This should never happen...

            throw new io.github.mlanlazc.exceptions.ApiException(
              "Unexpected exception thrown while accessing instance fields.",
              e
            );
          }
        })
        .map(java.lang.reflect.Field::getName)
        .collect(java.util.stream.Collectors.toSet());
    }

    @Override
    protected java.util.Set<java.util.Set<String>> getRequiredFieldsGroups() {
      return REQUIRED_FIELDS_GROUPS;
    }
  }

  @com.fasterxml.jackson.annotation.JsonProperty("code")
  private final java.lang.Long code;

  @com.fasterxml.jackson.annotation.JsonProperty("message")
  private final java.lang.String message;

  Error(Builder builder) {
    super(builder);
    this.code = builder.getCode();
    this.message = builder.getMessage();
  }
}
