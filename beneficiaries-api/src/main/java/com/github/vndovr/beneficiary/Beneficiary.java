package com.github.vndovr.beneficiary;

import javax.persistence.Entity;
import com.github.vndovr.common.DomainObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Beneficiary extends DomainObject {

  private String name;

  private String cdiNumber;

  private String account;

}
