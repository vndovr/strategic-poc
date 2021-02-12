package com.github.vndovr.beneficiary;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.github.vndovr.common.exception.ObjectNotFoundException;
import com.github.vndovr.common.exception.UpdateConflictException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BeneficiaryService {

  private ModelMapper modelMapper;

  private BeneficiaryRepository beneficiaryRepository;

  /**
   * Retrieves the list of beneficiaries
   * 
   * @return
   */
  public List<BeneficiaryROShort> getBeneficiaries() {
    return beneficiaryRepository.findAll().stream()
        .map(obj -> modelMapper.map(obj, BeneficiaryROShort.class)).collect(Collectors.toList());
  }

  /**
   * Returns the information about single beneficiarlys
   * 
   * @param id
   * @return
   */
  public BeneficiaryROFull getBeneficiary(long id) {
    return beneficiaryRepository.findById(id)
        .map(obj -> modelMapper.map(obj, BeneficiaryROFull.class))
        .orElseThrow(ObjectNotFoundException::new);
  }

  /**
   * Deletes beneficiary identified by id
   * 
   * @param id
   */
  public void deleteBeneficiary(long id) {
    beneficiaryRepository.deleteById(id);
  }

  /**
   * Creates beneficiary
   * 
   * @param dto
   * @return
   */
  public BeneficiaryROFull createBeneficiary(@Valid BeneficiaryROFull ro) {
    Beneficiary beneficiary = modelMapper.map(ro, Beneficiary.class);
    beneficiary.setId(null);
    beneficiary.setVersion(0);
    return modelMapper.map(beneficiaryRepository.saveAndFlush(beneficiary),
        BeneficiaryROFull.class);
  }

  /**
   * Updates the beneficiary
   * 
   * @param id
   * @param ro
   * @return
   */
  public Object updateBeneficiary(long id, @Valid BeneficiaryROFull ro) {
    ro.setId(id);
    Beneficiary beneficiary =
        beneficiaryRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    if (beneficiary.getVersion() != ro.getVersion()) {
      throw new UpdateConflictException();
    }
    modelMapper.map(ro, beneficiary);
    return modelMapper.map(beneficiaryRepository.saveAndFlush(beneficiary),
        BeneficiaryROFull.class);
  }

}
