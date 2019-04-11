package stm.vis.web.privateapi.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * IdentityDescriptionObject
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-10T10:34:20.466Z")

public class IdentityDescriptionObject   {
  @JsonProperty("identityId")
  private String identityId = null;

  @JsonProperty("identityName")
  private String identityName = null;

  public IdentityDescriptionObject identityId(String identityId) {
    this.identityId = identityId;
    return this;
  }

   /**
   * identity in urn format according to ID registry
   * @return identityId
  **/
  @ApiModelProperty(value = "identity in urn format according to ID registry")


  public String getIdentityId() {
    return identityId;
  }

  public void setIdentityId(String identityId) {
    this.identityId = identityId;
  }

  public IdentityDescriptionObject identityName(String identityName) {
    this.identityName = identityName;
    return this;
  }

   /**
   * Identity shortname in ID registry
   * @return identityName
  **/
  @ApiModelProperty(value = "Identity shortname in ID registry")
  public String getIdentityName() {
    return identityName;
  }

  public void setIdentityName(String identityName) {
    this.identityName = identityName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentityDescriptionObject identityDescriptionObject = (IdentityDescriptionObject) o;
    return Objects.equals(this.identityId, identityDescriptionObject.identityId) &&
        Objects.equals(this.identityName, identityDescriptionObject.identityName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identityId, identityName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentityDescriptionObject {\n");
    
    sb.append("    identityId: ").append(toIndentedString(identityId)).append("\n");
    sb.append("    identityName: ").append(toIndentedString(identityName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

