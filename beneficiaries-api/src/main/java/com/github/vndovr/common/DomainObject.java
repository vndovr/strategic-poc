package com.github.vndovr.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Data;

/**
 * Base class for domain object with versioning
 * 
 * @author Vladimir Radchuk
 *
 */
@Data
@MappedSuperclass
public class DomainObject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Version
  private long version;
}
