package org.hl7.davinci.pdex.refimpl.payer2provider.provider.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

@Getter
@Setter
@Data
public class CurrentContextDto {

  @NotBlank
  private final String patientId;
  //Disabling this check will let us launch and test the App without encounter selection.
  //@NotBlank
  private final String encounterId;
  @NotBlank
  private final String userProfile;

  public String getUserType() {
    //Might be null when persona contains dot or other special characters. Also might be cached in browser
    Assert.notNull(userProfile, "userProfile cannot be null");
    return StringUtils.substringBefore(userProfile, "/");
  }

  public String getUserId() {
    Assert.notNull(userProfile, "userProfile cannot be null");
    return StringUtils.substringAfter(userProfile, "/");
  }
}
